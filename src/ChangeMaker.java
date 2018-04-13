/*
 * Author: Kamran Hetke
 * Date: 4/13/2018
 * Overview: This program finds the minimum amount of coins via
 * greedy algorithm, and puts the coins that constitute the
 * change due into a list.
 */
import java.util.*;

public class ChangeMaker {
	
	public static List<Integer> makeChange(int changeDue, int[] coinArray) {
		
		List<Integer> coinList = new ArrayList<Integer>();
		
		if(coinArray.length == 0) {
			throw new IllegalArgumentException("Empty array");
		}
		
		for (int i = 0; i < coinArray.length; i++) {

			while (changeDue >= coinArray[i]) {
				changeDue -= coinArray[i];
				coinList.add(coinArray[i]);
			}
			
		}
		
		return coinList;
		
	}
	
}
