package com.dp.world.test;

public class DeckOfCards {


	  public static void main(String[] args) {
	    String [] deck = new String[52];
	    String[] suits = {"Spade", "Heart", "Diamond", "Club"};
	    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	    initializeTheDeck(deck, suits, ranks);
	    printTheDeck(deck);
	    suffleTheDeck(deck);
	    System.out.println("priting the suffle deck------------> ");
	    printTheDeck(deck);
	  }
	  
	  public static void initializeTheDeck(String [] deck, String[] suits, String[] ranks) {
		  int deckCount=0;
		  for(int i = 0; i < suits.length; i++) {
			  for(int j =0; j< ranks.length; j++) {
				  deck[deckCount++] = suits[i]+ " : " + ranks[j];
			  }
		  }
		  
	  }
	  
	  public static void suffleTheDeck(String [] deck) {
		  for (int i = 0; i < deck.length; i++) {
		      int index = (int)(Math.random() * deck.length);
		      String temp = deck[i];
		      deck[i] = deck[index];
		      deck[index] = temp;
		    }
	  }
	  
	  public static void printTheDeck(String [] deck) {
		  
		  for (int i = 0; i < deck.length; i++) {
		      System.out.println(deck[i]);
		    }
	  }
	}
