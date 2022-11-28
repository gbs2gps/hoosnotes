import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.Scanner;

class RandomStringGeneratorTest {
	
	static RandomStringGenerator rs;
	static ArrayList<String> expected;

	
	@BeforeEach
	void setUp() throws Exception {
		
		rs = new RandomStringGenerator();
		expected = new ArrayList<String>();		
		
	}
	
	@Test
	@Order(1)
	//Test: The constructor and initializing of the collection of words
	//Input: None
	//Expected Output: An empty array list
	void testRandomStringGenerator() {
		
		System.out.println("TESTING THE INITIALIZATION OF THE ARRAY LIST COLLECTION:");
		System.out.println("Excpeted Output: []");
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");

		assertEquals(expected, rs.getCollection());
		
		System.out.println("Actual Output:");
		rs.print();
		System.out.println("");

	}
	
	@Test
	@Order(2)
	//Test: Whether the software correctly adds a word to its array list collection
	//Input: The string "hey"
	//Expected Output: An array list with the word hey and nothing else
	void testAddWord() {
		
		System.out.println("TESTING THE ADDWORD() METHOD WHEN A SINGULAR STRING IS INPUT:");
		System.out.println("Excpeted Output: [hey]");
		System.out.println("Running Test");
		System.out.println("------------------------------------------------------");
		
		
		expected.add("hey");
		rs.addWord("hey");
		assertEquals(expected, rs.getCollection());
		
		System.out.println("Actual Output:");
		rs.print();
		System.out.println("");

	}
	
	@Test
	@Order(3)
	//Test: Whether the software correctly adds a word to its array list collection
	//Input: The strings "hey," "how," "are," "you," and "today"
	//Expected Output: An array list with the words "hey how are you today" and nothing else
	void testAddMultipleWords() {
		
		System.out.println("TESTING THE ADDWORD() METHOD WHEN MULTIPLE STRINGS ARE INPUT:");
		System.out.println("Excpeted Output: [hey, how, are, you, today]");
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");

		expected.add("hey");
		rs.addWord("hey");
		
		expected.add("how");
		rs.addWord("how");

		expected.add("are");
		rs.addWord("are");

		expected.add("you");
		rs.addWord("you");
		
		expected.add("today");
		rs.addWord("today");

		assertEquals(expected, rs.getCollection());

		System.out.println("Actual Output:");
		rs.print();
		System.out.println("");
	}
	

	@Test
	@Order(4)
	//Test: Whether the collections array list is empty or not
	//Input: The string "hey"
	//Expected Output: False, because the string is not empty
	void testisEmpty() {

		System.out.println("TESTING THE THAT ISEMPTY() PROPERLY IDENTIFIES WHETHER THE ARRAY LIST CONTAINS ANY OBJECTS:");
		System.out.println("Excpeted Output: false");
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");

		rs.addWord("hey");
		boolean expected = false;
		boolean actual = rs.isEmpty();
		assertEquals(expected, actual);
		
		System.out.println("Actual Output: " + rs.isEmpty());
		System.out.println("");

	}

	
	@Test
	@Order(5)
	// Test: Whether the correct array list (collection) is returned
	// Input: list of words given by user
	// Expected Output: Array list of words input by user
	void testGetCollection() {
		
		System.out.println("TESTING WHETHER THE ARRAY LIST COLLECTION IS PROPERLY RETURNED:");
		System.out.println("Excpeted Output: []");
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");
		
		ArrayList<String> actual = rs.getCollection();
		assertEquals(expected, actual);
		
		System.out.println("Actual Output:");
		rs.print();
		System.out.println("");
	}
	
	@RepeatedTest(5)
	@Order(6)
	// Test: The collection of strings correctly returns a random word and replaces it
	// Input: List of words "hey," "how," "are," "you," and "today"
	// Expected Output: The original array list and the random generated word
	void testReplaceWord() {
		
		
		expected.add("hey");
		rs.addWord("hey");
		
		expected.add("how");
		rs.addWord("how");

		expected.add("are");
		rs.addWord("are");

		expected.add("you");
		rs.addWord("you");
		
		expected.add("today");
		rs.addWord("today");
		
		int number = rs.randNum();
		
		String actual2 = rs.doRandom(true, number);
		String expected2 = expected.get(number);
		
		
		System.out.println("TESTING THE DORANDOM() METHOD WHEN INPUT IS TRUE:");
		System.out.println("Excpeted Output: word = " + expected2 + ", collection = [hey, how, are, you, today]");
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");
		
		System.out.println("Actual Output: " + actual2);
		rs.print();
		System.out.println("");
		
		assertEquals(expected, rs.getCollection());
		assertEquals(expected2, actual2);
		
		

	}
	
	@RepeatedTest(5)	
	@Order(7)
	// Test: The collection of strings correctly returns a random word and does not replace it
	// Input: List of words "hey," "how," "are," "you," and "today"
	// Expected Output: Varies based on random number generated
	void testUnreplaceWord() {
		
		
		
		expected.add("hey");
		rs.addWord("hey");
		
		expected.add("how");
		rs.addWord("how");

		expected.add("are");
		rs.addWord("are");

		expected.add("you");
		rs.addWord("you");
		
		expected.add("today");
		rs.addWord("today");
		
		
		int number = rs.randNum();

		
		String actual2 = rs.doRandom(false, number);
		String expected2 = expected.get(number);
		expected.remove(number);

		System.out.println("TESTING THE DORANDOM() METHOD WHEN INPUT IS FALSE:");
		System.out.println("Excpeted Output: word = " + expected2 + ", collection = " + expected);
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");
		System.out.println("Actual Output: " + actual2);
		rs.print();
		System.out.println("");
		assertEquals(expected, rs.getCollection());
		assertEquals(expected2, actual2);
		
		
	}
	
	@Test
	@Order(8)
	// Test: The software notifies user when string is empty and they try to get a random words
	// Input: None
	// Expected Output: Empty array list
	void testDoRandomWhenEmpty() {
		
		int number = rs.randNum();

		rs.doRandom(false, number);
		System.out.println("TESTING THE DORANDOM() METHOD WHEN ARRAY LIST IS EMPTY:");
		System.out.println("Excpeted Output: []");
		System.out.println("Running Test");
		System.out.println("----------------------------------------------------");
		assertEquals(expected, rs.getCollection());
		System.out.println("Actual Output: ");
		rs.print();
		System.out.println("");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Thanks for joining!! You're done!");
	}

}


