package com.assessment3;

import java.util.*;

public class Store {

	ArrayList<Grocery> list = new ArrayList<Grocery>();
	
	 Scanner sc = new Scanner(System.in);
	 
		class QuantityException extends Exception {
			public QuantityException(String message) {
				super(message);
			}
		}
		
		public boolean validateQuantity(int req,int quan) {
			boolean match =  true;
			for(Grocery g:list) {
				if(req == g.getItemId()) {
					if(quan > g.getItemQuantity()) {
						try {
							throw new QuantityException("Required Quantity exceeds Stock Quantity..");
							
						}catch(QuantityException e){
							System.err.println(e.getMessage());
						       match = true;
						}
					}
				else {match = false;}
				}
			}
			return match;
	}
		
	 class IdException extends Exception {
			public IdException(String message) {
				super(message);
			}
		}
	 
		public boolean validateId(int vId) {
			boolean matchit = false;
		
			if(vId != 101 && vId != 102 && vId != 103 && vId != 104 && vId != 105 && vId != 106  )
			{
				try {
					throw new IdException("Please Enter a valid 3 digit Number");
				}catch(IdException e){
					System.err.println(e.getMessage());
					matchit = true;
				}
			}
			else {matchit = false;}
		
		
		return matchit;
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Store m = new Store();
		 Scanner sc = new Scanner(System.in);
		 
			m.list.add(new Grocery(101,"Rice",55.00,100));
			m.list.add(new Grocery(102,"Wheat",60.00,100));
			m.list.add(new Grocery(103,"Dal",100.00,100));
			m.list.add(new Grocery(104,"Sugar",40.00,100));
			m.list.add(new Grocery(105,"Coffee",150.00,50));
			m.list.add(new Grocery(106,"Tea",90.00,50));
			
			
            int optionA = 0;
            do {
            	System.out.println("Login to the Desired Module");
            	System.out.println("1.Stock Module");
            	System.out.println("2.Sales Module");
            	System.out.println("Select an option:");
            	int c  = sc.nextInt();
            	sc.nextLine();
            	switch(c) {
            	case 1:
            		
            		int optionB = 0;
            		
            		do {
            			System.out.println("1.View available Stocks");
                		System.out.println("2.Add Items into Stocks");
                		System.out.println("3.Exit");
                		System.out.println("Select an option");
                		int d = sc.nextInt();
                		sc.nextLine();
                		switch(d) {
                		case 1:
                			m.view();
                			break;
                		case 2:
                			System.out.println("Enter the Item Id to be updated:");
                			int aId = sc.nextInt();
                			sc.nextLine();
                			while(m.validateId(aId)) {
                				System.out.println("Enter Item Id to be updated");
                				aId = sc.nextInt();
                			}
                			m.add(aId);
                			break;
                		case 3:
                			optionB = -1;
                		}
            			
            		}while(optionB != -1);
            		
            		break;
            	case 2:
            		System.out.println("Welcome to our Store!!");
            		ArrayList<Grocery> cart = new ArrayList<Grocery>();
            		int optionD = 0;
            		do {
            			System.out.println("1.Need any Items??");
            			System.out.println("2.Generate Bill");
            			System.out.println("3.Exit");
            			System.out.println("Select an Option");
            			int f = sc.nextInt();
            			sc.nextLine();
            			switch(f) {
            			case 1:
            				System.out.println("Enter the Id of the Item requested by Customer");
                    		int req = sc.nextInt();
                    		sc.nextLine();
                    		for(Grocery g:m.list) {
                    			if(req == g.getItemId()) {
                    				System.out.println("Enter Quantity Required");
                    				int quan = sc.nextInt();
                    				sc.nextLine();
                    				while(m.validateQuantity(req,quan)) {
                    					System.out.println("Enter Quantity with in Range of Stock");
                    					quan = sc.nextInt();
                    				}
                    				System.out.println("Cart Items..");
                    				int cartId = g.getItemId();
                    				String cartName = g.getItemName();
                    				double cartPrice =  (quan * g.getItemPrice());
                    				int cartQuantity = quan;
                    				System.out.println("\t Item Id:" + cartId + "\t" +"Name:" + cartName + "\t" + "Price:" + cartPrice + "\t" + "Quantity:" + cartQuantity +"\n");
                                     int now = (g.getItemQuantity() - quan);
                    				g.setItemQuantity(now);
                    				Grocery gAdd = new Grocery(cartId,cartName,cartPrice,cartQuantity);
                    				cart.add(gAdd);
						System.out.println("Entire List.....");
                    				for(Grocery g5: cart) {
                        				System.out.println("\t Item Id:" + g5.getItemId() + "\t" +"Name:" + g5.getItemName() + "\t" + "Price:" + g5.getItemPrice() + "\t" + "Quantity:" + g5.getItemQuantity() +"\n");

                    				}
                    					
                    			}
                    		}
            				break;
            			case 2:
            				System.out.printf("%70s \n","Bill....");
            				double total = 0.00;
            				for(Grocery g: cart) {
                				System.out.println("\t Item Id:" + g.getItemId() + "\t" +"Name:" + g.getItemName() + "\t" + "Price:" + g.getItemPrice() + "\t" + "Quantity:" + g.getItemQuantity() +"\n");
                			     total =  (total + g.getItemPrice());

            				}
            				
            				System.out.println("Total Amount to be Paid:" + total);
            				break;
            			case 3:
            				System.out.println("Thank you for Shopping..");
            				optionD = -1;
            				break;
            			}
            		}while(optionD != -1);
            		
            		break;
            	}
            	
            	
            }while(optionA != -1);
	}
	
	public void view() {
		System.out.printf("%70s \n","Items Available..");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	for(Grocery g:list) {
		System.out.println("\t Item Id:" + g.getItemId() + "\t" +"Name:" + g.getItemName() + "\t" + "Price:" + g.getItemPrice() + "\t" + "Quantity:" + g.getItemQuantity() +"\n");
	
	}

	}
	
	public void add(int aId) {
		System.out.println("Do you want to update Price or Quantity??");
		int optionC = 0;
		do {
			System.out.println("1.Update Price");
			System.out.println("2.Update Quantiy");
			System.out.println("3.Exit");
			int e = sc.nextInt();
			sc.nextLine();
			switch(e) {
			case 1:
				for(Grocery g:list) {
					if(aId == g.getItemId()) {
						System.out.println("Enter new Price:");
						double p = sc.nextDouble();
						g.setItemPrice(p);
					}
				}
				break;
			case 2:
				for(Grocery g2:list) {
					if(aId == g2.getItemId()) {
						System.out.println("Enter new Quantity:");
						int q = sc.nextInt();
						g2.setItemQuantity(q);
					}
				}
				break;
			case 3:
				optionC = -1;
				break;
			}
		}while(optionC != -1);
		
	}
	
	
}
