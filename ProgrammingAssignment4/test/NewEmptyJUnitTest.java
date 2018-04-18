/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import programmingassignment4.ChangeMaker;

/**
 *
 * @author Rusty
 */
public class NewEmptyJUnitTest {
    
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
		
		assertTrue(coinList.size() == 4 && coinList.get(0) == 25 && coinList.get(1) == 1 && coinList.get(2) == 5 && coinList.get(3) == 10);
	}
	
	@Test
	public void testThreeCoinsDue() {
		int changeDue = 7;
		int coinArray[] = {25, 10, 5, 1};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 3 && coinList.get(0) == 1 && coinList.get(1) == 1 && coinList.get(2) == 5);
	}
        
        @Test
	public void DifferentMoneySystem() {
		int changeDue = 64;
		int coinArray[] = {25, 12, 5, 1};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 5 && coinList.get(0) == 25 && coinList.get(1) == 25 && coinList.get(2) == 1 && coinList.get(3) == 1 && coinList.get(4) == 12);
	}
}
