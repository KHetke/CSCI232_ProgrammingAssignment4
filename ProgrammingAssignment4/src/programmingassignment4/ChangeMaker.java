/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingassignment4;

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
		
                int [] memoArray= new int [changeDue+1];
                memoArray[0]=0;
                
		for (int i = 1; i < memoArray.length; i++) {

			for(int j = 0; j< coinArray.length; j++){
                            if ((i-coinArray[j])>=coinArray[0]){
                                memoArray[i]=coinArray[0];
                                j=coinArray.length;
                            }                           
                            
                            else if(i%coinArray[j]==0){
 
                                memoArray[i]=coinArray[j];
                                j=coinArray.length;                            
                                
                            }
                            else{
                                memoArray[i]=1;
                            }                                  
                            
                        }			
		}                
                while(changeDue>0){
                    
                    coinList.add(memoArray[changeDue]);
                    changeDue-=memoArray[changeDue];
                }
		
		return coinList;
		
	}
	
}