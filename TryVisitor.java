package com.design.patterns;

import java.util.ArrayList;
import java.util.Iterator;

public class TryVisitor {
	
	interface SessionVisitor {
		String getTradingSession(Equity stock);
		String getTradingSession(Warrant stockA);
		String getTradingSession(Certificate stockA);
	}
	
	class DailySession implements SessionVisitor{
		
		public String getTradingSession(Equity stock) {
			return stock.getName()+",88" ;
		}

		public String getTradingSession(Warrant warrant) {
			return warrant.getName()+",77" ;
		}
		public String getTradingSession(Certificate certificate) {
			return certificate.getName()+",51" ;
		}
	}
		
	
	interface  SessionVisitable{
		public String accept(SessionVisitor visitor);
	}
	class Equity implements SessionVisitable{
	
		private String name;
		public Equity(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public String accept(SessionVisitor visitor) {
			return visitor.getTradingSession(this);
		}		
	}
	class Warrant implements SessionVisitable{
		
		private String name;
		public Warrant(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public String accept(SessionVisitor visitor) {
			return visitor.getTradingSession(this);
		}		
	}

	class Certificate implements SessionVisitable{
		
		private String name;
		public Certificate(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public String accept(SessionVisitor visitor) {
			return visitor.getTradingSession(this);
		}		
	}

	
	public static void main(String[] args) {
		TryVisitor tryVisitor=new TryVisitor();
		DailySession session=tryVisitor.new DailySession();
		Equity equity=tryVisitor.new Equity("Equity");
		Warrant warrant=tryVisitor.new Warrant("Warrant");
		Certificate certificate=tryVisitor.new Certificate("Certificate");
		
		//System.out.println(equity.accept(session));
		//System.out.println(warrant.accept(session));
		//System.out.println(certificate.accept(session));
		
		ArrayList<SessionVisitable> list=new ArrayList<SessionVisitable>();
		list.add(equity);list.add(warrant);list.add(certificate);
		Iterator<SessionVisitable> itr=list.iterator();
		while(itr.hasNext()) {
			SessionVisitable item=itr.next();
			System.out.println(item.accept(session));
		}

		
		
	}

}
