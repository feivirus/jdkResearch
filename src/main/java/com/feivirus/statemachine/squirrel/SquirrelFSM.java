package com.feivirus.statemachine.squirrel;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * http://hekailiang.github.io/squirrel/
 * @author feivirus
 *
 */
public class SquirrelFSM {
	enum OrderEventEnum {
		PAY, DELIVERY
	}
	enum OrderStateEnum {
		UNPAIED("unpaid"),
		UNDELIVERY("undelivery"),
		DONE("done");
		private String 	value;
		
		private OrderStateEnum(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	//订单三状态"unpaid", "undelivery", "done"
	
	@StateMachineParameters(stateType = String.class, eventType = OrderEventEnum.class, contextType = Integer.class)
	static class OrderStateMachine extends AbstractUntypedStateMachine {
		protected void fromUnpaidToUndelivery(String from, String to, OrderEventEnum eventEnum, Integer context) {
			System.out.println("Transition from " + from + " to " + to + " on event " + eventEnum + " with context " + context);
		}
		
		protected void onEntryUndelivery(String from, String to, OrderEventEnum eventEnum, Integer context) {
			System.out.println("entry state " + to);
		}
	}
	
	public static void main(String [] args) {
		UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(OrderStateMachine.class);
		
		builder.externalTransition().from(OrderStateEnum.UNPAIED.getValue())
			.to(OrderStateEnum.UNDELIVERY.getValue())
			.on(OrderEventEnum.PAY).callMethod("fromUnpaidToUndelivery");
		builder.onEntry(OrderStateEnum.UNDELIVERY.getValue()).callMethod("onEntryUndelivery");
		
		UntypedStateMachine fsm = builder.newStateMachine(OrderStateEnum.UNPAIED.getValue());
		fsm.fire(OrderEventEnum.PAY, 1);
		
		System.out.println("current state " + fsm.getCurrentState());
	}
}
