

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import programmingassignment4.ChangeMaker;

/**
 *
 * @authors Kamran Hetke, Rusty Clayton, Derek Jacobson
 * Date: 4/17/2018
 * Description: A test file to run the changemaker class with a dynamic algorithm
 */
public class changeMakerTest {
    
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
		int coinArray[] = {1,5,10,25};
			
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);

		assertTrue(coinList.size() == 1 && coinList.get(0) == 1);
		
	}
	
	@Test
	public void testAllCoinTypesDue() {
		int changeDue = 41;
		int[] coinArray = {1,5,10,25};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 4 && coinList.get(0) == 25 && coinList.get(1) == 10 && coinList.get(2) == 5 && coinList.get(3) == 1);
	}
	
	@Test
	public void testHigherValue() {
		int changeDue = 81;
		int coinArray[] = {1,5,10,25};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 5 && coinList.get(0) == 25 && coinList.get(1) == 25 && coinList.get(2) == 25 && coinList.get(3) == 5 && coinList.get(4) == 1 );
	}
        
        @Test
	public void testDifferentMoneySystem() {
		int changeDue = 64;
		int coinArray[] = {1,5,12,25};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 5 && coinList.get(0) == 25 && coinList.get(1) == 25 && coinList.get(2) == 12 && coinList.get(3) == 1 && coinList.get(4) == 1);
	}
        
      
        
        @Test
	public void testDifferentMoneySystem2() {
		int changeDue = 67;
		int coinArray[] = {1,13,17,27};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 3 && coinList.get(0) == 27 && coinList.get(1) == 27 && coinList.get(2) == 13 );
	}
        @Test
	public void testDifferentMoneySystem3() {
		int changeDue = 67;
		int coinArray[] = {1,13,22,25};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size() == 4 && coinList.get(0) == 22 && coinList.get(1) == 22 && coinList.get(2) == 22 && coinList.get(3)==1 );
	}
        
        @Test
	public void testCoinSystemCannotGetValue1() {
		int changeDue = 3;
		int coinArray[] = {2,4,6};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size()==0);
	}
        
        @Test
	public void testCoinSystemCannotGetValue2() {
		int changeDue = 32;
		int coinArray[] = {5,10,25};
		
		List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
		
		assertTrue(coinList.size()==0 );
	}
        
        @Test
        public void testCoinSystemValue10()
        {
            int changeDue = 10;
            int coinArray[] = {1, 10, 12};
            
            List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
            
            assertTrue(coinList.size() == 1 && coinList.get(0) == 10);
        }
        
        @Test
        public void testCoinSystemValue12()
        {
            int changeDue = 12;
            int coinArray[] = {1, 10, 12};
            
            List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
            
            assertTrue(coinList.size() == 1 && coinList.get(0) == 12);
        }
        
        @Test
        public void testCoinSystemValue13()
        {
            int changeDue = 13;
            int coinArray[] = {1, 10, 12};
            
            List<Integer> coinList = ChangeMaker.makeChange(changeDue, coinArray);
            
            assertTrue(coinList.size() == 2 && coinList.get(0) == 12 && coinList.get(1) == 1);
        }
}
