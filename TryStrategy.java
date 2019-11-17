package com.design.patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TryStrategy {
	class Security {
		String name;
		int id;	
		String expireDate;
		ExpireDate expDate;
		
		public String getExpireDate() {
			return this.expDate.getExpireDate();
		}
		
		
	}
	class Equity extends Security {
		public Equity(String name) {
			expDate=new NoExpireDate();
			this.name=name;
		}
	}
	
	class Certificate extends Security {
		public Certificate(String name) {
			this.name=name;
			expDate=new MiddleOfTheMonthExpireDate();
		}
	}
	class Warrant extends Security {
		public Warrant(String name ) {
			this.name=name;
			expDate=new EndOfTheMonthExpireDate();
		}
	}
	
	interface ExpireDate{
		public String getExpireDate();
	}

	class NoExpireDate implements ExpireDate{

		public String getExpireDate() {
			return " no expire date";
		}		
	}
	
	class EndOfTheMonthExpireDate implements ExpireDate{

		public String getExpireDate() {
			return " expires at the end of the Month";
		}		
	}
	
	class MiddleOfTheMonthExpireDate implements ExpireDate{

		public String getExpireDate() {
			return " expires at the every 15th of the month";
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Security> secList=new ArrayList();
		TryStrategy strategy=new TryStrategy();
		Equity equity=strategy.new Equity("Equity");
		secList.add(equity);
		Certificate certificate=strategy.new Certificate("Certificate");
		secList.add(certificate);
		Warrant warrant=strategy.new Warrant("Warrant");
		secList.add(warrant);
		
		Iterator<Security> itr=secList.iterator();
		while(itr.hasNext()) {
			Security sec=itr.next();
			System.out.println("My name is "+sec.name+" and my expire date "+sec.getExpireDate());
		}
		

	}

}
