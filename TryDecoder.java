package com.design.patterns;

public class TryDecoder {
	
	interface Pizza{
		public String getDescription();
		public double getCost();
	}
	
	abstract class ToppingDecorator implements Pizza{
		protected Pizza pizza;
		public ToppingDecorator (Pizza newPizza) {
			this.pizza=newPizza;
		}
		
		public String getDescription() {
			return pizza.getDescription();
		}

		public double getCost() {
			return pizza.getCost();
		}
	}
	
	class Mozeralla extends ToppingDecorator {

		public Mozeralla(Pizza newPizza) {
			super(newPizza);
			// TODO Auto-generated constructor stub
		}
		
		public String getDescription() {
			return pizza.getDescription() + ",Mozzarella";
		}

		public double getCost() {
			return pizza.getCost() + new Double("4");
		}
		
	}
	
	class TomatoSauce extends ToppingDecorator {

		public TomatoSauce(Pizza newPizza) {
			super(newPizza);
			// TODO Auto-generated constructor stub
		}
		
		public String getDescription() {
			return pizza.getDescription() + ",TomatoSauce";
		}

		public double getCost() {
			return pizza.getCost() + new Double("6");
		}		
	}
	
	class PlainPizza implements Pizza {
		
		public String getDescription() {
			return  "Thin dough";
		}

		public double getCost() {
			return new Double("3");
		}		
	}
	
	
	public static void main(String[] args) {
		TryDecoder decoder=new TryDecoder();		
		Pizza plain=decoder.new PlainPizza();
		Pizza margarita=decoder.new TomatoSauce(decoder.new Mozeralla(plain));
		System.out.println("Desc:"+margarita.getDescription());
		System.out.println("Cost:"+margarita.getCost());

	}

}
