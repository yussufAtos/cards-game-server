package com.card.model;

public class Card {
	
	private String color;
	private String value;
	
	
	public Card(String color, String value) {
		super();
		this.color = color;
		this.value = value;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	   @Override
	    public boolean equals(Object obj) {
	        if (obj == this) {
	            return true;
	        }
	        if (!(obj instanceof Card)) {
	            return false;
	        }
	        Card other = (Card) obj;
	        boolean colorEquals = (this.color == null && other.getColor() == null)
	          || (this.color != null && this.color.equals(other.getColor()));
	        boolean valueEquals = (this.value == null && other.getValue() == null)
	                || (this.value != null && this.value.equals(other.getValue()));
	        return valueEquals && colorEquals;
	    }


	@Override
	public String toString() {
		return "Card [color=" + color + ", value=" + value + "]";
	}
	

}
