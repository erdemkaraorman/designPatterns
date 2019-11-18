package com.design.patterns;

public class TryFactory {

	abstract class absClass{
		private String name;
		private String type;
		
		public absClass(String name, String type) {
			super();
			this.name = name;
			this.type = type;
		}
		public String toString() {
			return "Hi my name is "+this.name+" and my type is "+this.type;
		}
	}
	
	class classOne extends absClass{

		public classOne(String name, String type) {
			super(name, type);
		}
		
	}
	class classTwo extends absClass{

		public classTwo(String name, String type) {
			super(name, type);
		}		
	}
	
	class classFactory {
		absClass makeClass(String type) {
			if (type=="One") {
				return new classOne("classOne",type);
			}
			else if (type=="Two") {
				return new classTwo("classTwo",type);
			} 
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		TryFactory tryFactory=new TryFactory();
		classFactory factory=tryFactory.new classFactory();
		absClass class1=factory.makeClass("One");
		absClass class2=factory.makeClass("Two");
		absClass class3=factory.makeClass("Three");
		
		System.out.println(class1);
		System.out.println(class2);
		System.out.println(class3);
		
		
	}

}
