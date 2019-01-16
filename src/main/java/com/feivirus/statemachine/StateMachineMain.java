package com.feivirus.statemachine;

import com.feivirus.statemachine.annotation.StateMachineBinder;
import com.feivirus.statemachine.impl.AbstractStateMachine;
import com.feivirus.statemachine.impl.StateMachineBuilderImpl;

/**
 * 
 * 自动机
 * @author feivirus
 * 应用:比如订单状态切换,订单状态/合同规则状态切换,词法分析，审批工作流
 * 参考
 * https://www.jianshu.com/p/209f1fb6a827 java词法分析器小demo
 * https://www.jianshu.com/p/f3ad78613072 androie自动机
 * http://smc.sourceforge.net/ smc首页
 * http://unimod.sourceforge.net/fsm-framework.html java开源自动机
 * http://www.blogjava.net/caizh2009/archive/2010/07/26/327157.html 开源smc
 * https://blog.csdn.net/qq_33223761/article/details/82796231 订单状态机概念
 * http://www.cnblogs.com/bastard/archive/2012/06/05/2536258.html android statemachine
 * https://blog.csdn.net/hguisu/article/details/7557252 状态模式
 * https://www.jianshu.com/p/326bd3ac2bf2?winzoom=1 spring statemachine
 */
public class StateMachineMain {
	enum SampleEvent {
		ToA, ToB, ToC, ToD
	}
	
	//TODO 通过注解生成状态机
	//@StateMachineBinder(stateType = String.class, eventType = SampleEvent.class, contextType = Integer.class)
	private static class StateMachineSample extends AbstractStateMachine<SingleStateMachine, Object, Object, Object> {
		protected void fromAToB(String from, String to, SampleEvent event, Integer context) {
			System.out.println("Transition from " + from + " to " + to + " on event "
					+ event + " with context " + context);
		}	
		
		protected void fromBToC(String from, String to, SampleEvent event, Integer context) {
			System.out.println("Transition from " + from + " to " + to + " on event "
					+ event + " with context " + context);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		StateMachineBuilder builder = new StateMachineBuilderImpl(StateMachineSample.class, String.class, SampleEvent.class, Integer.class);
		builder.singleTransition().from("A").to("B").on(SampleEvent.ToB).callMethod("fromAToB");
		builder.singleTransition().from("B").to("C").on(SampleEvent.ToC).callMethod("fromBToC");
		
		StateMachine ssm = builder.newStateMachine("A");
		ssm.fire(SampleEvent.ToB, 10);
		ssm.fire(SampleEvent.ToC, 20);
	}
}
