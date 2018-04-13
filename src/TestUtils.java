/*
 * Author: Kamran Hetke
 * Date: 4/13/2018
 * Overview: This is the JUnit4 testing application, with a variety
 * of cases to test ChangeMaker.java
 */

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestUtils {

	@Test
	public void testEmptyArray() {
		int coinArray[] = {};
		try {
			ChangeMaker.makeChange(0, coinArray);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage() == "Empty array");
		}
	}
	
	@Test
	public void testOneCoinDue() {
		int changeDue = 1;
		int coinArray[] = {25, 10, 5, 1};
			
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);

		assertTrue(coinList.size() == 1 && coinList.get(0) == 1);
		
	}
	
	@Test
	public void testAllCoinTypesDue() {
		int changeDue = 41;
		int[] coinArray = {25, 10, 5, 1};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 4 && coinList.get(0) == 25 && coinList.get(1) == 10 && coinList.get(2) == 5 && coinList.get(3) == 1);
	}
	
	@Test
	public void testThreeCoinsDue() {
		int changeDue = 7;
		int coinArray[] = {25, 10, 5, 1};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 3 && coinList.get(0) == 5 && coinList.get(1) == 1 && coinList.get(2) == 1);
	}

}
