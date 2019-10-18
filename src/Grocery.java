package com.assessment3;

public class Grocery {
 int itemId;
 String itemName;
 double itemPrice;
 int itemQuantity;
public Grocery(int itemId, String itemName, double itemPrice, int itemQuantity) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.itemPrice = itemPrice;
	this.itemQuantity = itemQuantity;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public double getItemPrice() {
	return itemPrice;
}
public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}
public int getItemQuantity() {
	return itemQuantity;
}
public void setItemQuantity(int itemQuantity) {
	this.itemQuantity = itemQuantity;
}
 
}
