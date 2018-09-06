package com.feivirus.commonclass;

import java.util.Date;

/**
 * 引用传递和值传递
 * @author feivirus
 *
 */
public class ReferenceAssign {
	public static void main(String []args) {
		Date day = new Date();
		System.out.println("before setNextDay" + day);
		setNextDay(day);
		System.out.println("after setNextDay" + day);
		setNextDayWithNew(day);
		System.out.println("after setNextDayWithNew " + day);
		
		Person person = new ReferenceAssign().new Person();
		person.setAge(1);
		person.setName("feivirus");
		updatePerson(person);
		System.out.println("after name " + person.getName());
		System.out.println("after age " + person.getAge());		
	}
	
	public static void setNextDay(Date day) {
		day.setDate(day.getDate() + 1);
		System.out.println("in setNextDay " + day);
	}
	
	public static void setNextDayWithNew(Date day) {
		day = new Date(day.getYear(), day.getMonth() + 1, day.getDate() + 1);
		System.out.println("in setNextDayWithNew " + day);
	}
	
	public static void updatePerson(Person p) {
		p.setName(p.getName() + "_1");
		p.setAge(p.getAge() + 1);
		System.out.println("name " + p.getName());
		System.out.println("age " + p.getAge());
	}
	
	class Person {
		private String name;
		private Integer age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}		
	}
}
