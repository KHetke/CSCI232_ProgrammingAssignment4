
package programmingassignment4;

/*
 * @authors Kamran Hetke, Rusty Clayton
 * Date: 4/17/2018
 * Description: Change Maker class runs a dynamic algorith to return a list of coins as change.
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
                            
                            if(i%coinArray[j]==0){ 
                                memoArray[i]=coinArray[j];
                                j=coinArray.length;                           
                                
                            }
                            
                            else if(i>=coinArray[0]){
                                memoArray[i]=coinArray[0];
                                j=coinArray.length;
                            }
                                                       
                            
                            else{
                                memoArray[i]=coinArray[j];
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