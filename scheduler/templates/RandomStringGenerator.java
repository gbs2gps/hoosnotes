import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomStringGenerator {

  private ArrayList<String> collection;
  
  public RandomStringGenerator() {
	  collection = new ArrayList<String>();
  }
  
  public void addWord(String w) {
	  collection.add(w);

  }
  
  public ArrayList<String> getCollection() {
	  return collection;
  }
  
  public void print() {
	 System.out.print("Your current collection of words: ");
	 System.out.print("[");

	  for(int i = 0; i < collection.size(); i++) {
		  if(i == collection.size()-1) {
			  System.out.print(collection.get(i));

		  } else {
			  System.out.print(collection.get(i) + ", ");
		  }
	  }
	  System.out.println("]");

  }
  
  public int randNum() {
	  int number = (int) Math.floor(Math.random() * (collection.size()-1));
	  return number;
  }
  
  public boolean isEmpty() {
	 return collection.isEmpty();
  }
  
  public String doRandom(boolean flag, int number){
	  String word = "";

	  if(isEmpty()) {
		  System.out.println("The collection of words is empty!");
		  System.out.println("");

	  } else {
	  if(flag == true) {
		  word = collection.get(number);
	  }
	  
	  if(flag == false) {
		  word = collection.get(number);
		  collection.remove(number);
	  }

	  print();
  }
	  
	  return word;
  }
  
public static void main(String[] args) {
	RandomStringGenerator rs = new RandomStringGenerator();
	String next = "";
	InputStream stdin = System.in;
	Scanner scanner  = new Scanner(stdin);
	while(!next.equals("Q") && !next.equals("q")) {
	System.out.println("Enter a collection of words");
	System.out.print("Want to add a word? ");
	System.out.println("No? Press Q if done.");
	next = scanner.nextLine();
	if(!next.equals("Q") && !next.equals("q")) {
		rs.addWord(next);
	}
	}
	
	while(rs.getCollection().size() != 0) {
		System.out.println("Enter true if you want a random word from your collection to be returned and replaced!");
		System.out.println("OR");
		System.out.println("Enter false if you want a random word from your collection to be returned and unreplaced!");

		String bline = scanner.nextLine();
		if(bline.equals("true") || bline.equals("false")) {
			boolean dec = Boolean.parseBoolean(bline);
			int num = rs.randNum();
			rs.doRandom(dec, num);
			
			
		} else {
			System.out.println("WHOOPS try again!");
			System.out.println("Enter true if you want a random word from your collection to be returned and replaced!");
			System.out.println("OR");
			System.out.println("Enter false if you want a random word from your collection to be returned and unreplaced!");
		}
	}
	
	System.out.println("Thanks for joining!! You're done!");

}


	
	

}