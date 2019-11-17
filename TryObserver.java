package com.design.patterns;

import java.util.ArrayList;
import java.util.List;

public class TryObserver {
	private static int observerTrackerID;

	interface Subject {
		public void register(Observer observer);
		public void unregister(Observer observer);
		public void notifyObserver();		
	}
	
	interface Observer {
		public void update(double ibmPrice,double aaplPrice,double googPrice);
	}
	
	class StockGrabber implements Subject{
		private double ibmPrice;
		private double aaplPrice;
		private double googPrice;
		List<Observer> observerList;
		
		public StockGrabber() {
			observerList=new ArrayList<Observer>();
		}
		public void register(Observer observer) {

			observerList.add(observer);
			System.out.println("observer " +observer+" is added");
		}

		public void unregister(Observer observer) {
			int index=observerList.indexOf(observer);
			observerList.remove(index);
			System.out.println("observer " +observer+" is deleted");
		}

		public void notifyObserver() {	
			for (Observer o:observerList) {
				o.update(this.ibmPrice,this.aaplPrice,this.googPrice);
			}
		}
	
		public void setIbmPrice(double ibmPrice) {
			this.ibmPrice = ibmPrice;
			this.notifyObserver();
		}
	
		public void setAaplPrice(double aaplPrice) {
			this.aaplPrice = aaplPrice;
			this.notifyObserver();
		}
	
		public void setGoogPrice(double googPrice) {
			this.googPrice = googPrice;
			this.notifyObserver();
		}
	}
	
	public class StockObserver implements Observer{
		private double ibmPrice;
		private double aaplPrice;
		private double googPrice;
		private StockGrabber stockGrabber;
			
		private int observerID;
		public StockObserver(StockGrabber stockGrabber) {
			this.stockGrabber=stockGrabber;
			observerID=observerTrackerID++;
			//System.out.println("New observer id:"+this.observerID);
			stockGrabber.register(this);
		}
		
		public void update(double ibmPrice, double aaplPrice, double googPrice) {
			this.ibmPrice=ibmPrice;
			this.aaplPrice=aaplPrice;
			this.googPrice=googPrice;
			printThePrices();
		}
		public void printThePrices() {
			System.out.println(observerID);
			System.out.println("IBM price:"+this.ibmPrice+System.lineSeparator()+"Apple price:"+this.aaplPrice+System.lineSeparator()+"Google price:"+this.googPrice);
		}
		
		public String toString() {
			Integer _val=Integer.valueOf(observerID);
			return _val.toString();
		}
	}
	public static void main(String[] args) {
		TryObserver tryObserver=new TryObserver();
		StockGrabber stockGrabber=tryObserver.new StockGrabber();
		StockObserver obs1=tryObserver.new StockObserver(stockGrabber);
		StockObserver obs2=tryObserver.new StockObserver(stockGrabber);

		stockGrabber.setIbmPrice(474.95);
		stockGrabber.setAaplPrice(600.15);
		stockGrabber.setGoogPrice(745.95);
		
		
		stockGrabber.unregister(obs1);
		stockGrabber.setIbmPrice(472.95);
		stockGrabber.setAaplPrice(559.15);
		stockGrabber.setGoogPrice(945.95);
		
		
	}
}
