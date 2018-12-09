package fields;

import java.util.Arrays;



import pages.RentPage;

public class Inventory implements RentDvd{
	
	public static String DVDName[] = {"Lord of the ring","Harry potter","Game of throne",
			"Divergent", "Twilight", "Hungergame", "Percy jackson"};
	public static double DVDPrice[] = {400,300,250,600,450,300,150};
	private double DVDStock[] = {12,12,12,12,12,12,12};
	private Double price;
	private String name;
	private int stock ;
	private int day;
	private RentPage rentPage;
	
	private boolean returnable ;
	
	public Inventory(RentPage rentPage) {
		this.rentPage = rentPage;
		this.returnable = true;
	}
	
	
	
		
	
	
	public boolean returnDVD(String name, int stock) throws MyException {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		int i = Arrays.asList(DVDName).indexOf(name);
		if(DVDStock[i]+stock>12) {
			/*Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Number of DVD has reached the max number.\nNow we have "+(int)DVDStock[i]+" instock"
					+ "\nPlease input the right number of return DVD again.");
			alert.showAndWait();*/
			throw new MyException("Number of DVD has reached the max number.\nNow we have "+(int)DVDStock[i]+" instock"
					+ "\nPlease input the right number of return DVD again.");
			//this.reTurnable = false;
			
			
		}else {
			this.DVDStock[i] += stock;
			this.returnable = true;
		}
		return isReTurnable();
		
	}
	
	public double rentDVD(String name,int day,int stock) throws MyException {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		int i = Arrays.asList(DVDName).indexOf(name);
		if(DVDStock[i]-stock<0.0) {
			/*Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Don't have enough " + name + " in stock ,we have "+(int)DVDStock[i]+" in stock");
			alert.showAndWait();
			price=-1.0;*/
			throw new MyException("Don't have enough " + name + " in stock ,we have "+(int)DVDStock[i]+" in stock");
		}else {
			this.DVDStock[i] -= stock;
			
			String card = rentPage.getDiscount();
			double discount = 1;
			if(card.equals("Gold Card")) {
				discount = 0.9;
			}else if(card.equals("Silver Card")) {
				discount = 0.8;
			}else if(card.equals("Copper Card")) {
				discount = 0.7;
			}else {
				discount = 1;
			}
			price = (Double) (discount)*(this.DVDPrice[i] + day*5+stock);
		}
		return price;
		
	}
	public int getRemain(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		int i = Arrays.binarySearch(this.DVDName, name);
		return (int)this.DVDStock[i];
	}

	public boolean isReTurnable() {
		return returnable;
	}
	
	
	

}
