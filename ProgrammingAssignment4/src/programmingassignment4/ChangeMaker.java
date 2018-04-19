
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
		
                int [][] memoArray= new int [coinArray.length+1][changeDue+1];
                memoArray[0][0]=0;
                
                
                for (int i=1; i<memoArray.length;i++){
                    for(int j=0; j<memoArray[0].length; j++){
                        if(j>=coinArray[i-1] && i>1){
                            memoArray[i][j]=getMin(memoArray[i-1][j],1+memoArray[i][j-coinArray[i-1]]);
                        }else if(i>1){
                            memoArray[i][j]=memoArray[i-1][j];
                        }else{
                            memoArray[i][j]=j;
                        }
                    }
                }
                
                
                int i=memoArray.length-1;
                int j=memoArray[0].length-1;
		while(memoArray[i][j]>0){
                    
                    
                    if(memoArray[i-1][j]==memoArray[i][j]){
                        i--;
                    }else{
                        j-=coinArray[i-1];
                        coinList.add(coinArray[i-1]);
                    }
                    
                }
		
		return coinList;
		
	}
        
        public static int getMin(int one, int two){
            if(one<=two){
                return one;
            }
            else{
                return two;
            }
            
        }
	
}