
package programmingassignment4;

/*
 * @authors Kamran Hetke, Rusty Clayton, Derek Jacobson
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
                /*
                //two dimensional memo array built so that first row and column can be zero values.
                int [][] memoArray= new int [coinArray.length+1][changeDue+1];
                
                //builds the memoArray that can be referenced to find coins
                for (int i=1; i<memoArray.length;i++){
                    for(int j=0; j<memoArray[0].length; j++){
                        if(j>=coinArray[i-1] && i>1){
                            //logic for any rows beyond the ones place
                            //if the value of the current coin is less than
                            //the current value desired it assumes the minimum
                            //value between the number of coins in the row above it
                            //or the number of coins at the value minus the value of the coin back in the row plus 1
                            //for example( if coins system is {1,5} and value is 11
                            // the ones place fills with 1-11 on it's row, on 5's row
                            // it fills 1,2,3,4,1 because 1 is the minimum between 5, 
                            //the ones place at val 5, and 1+0.  It continues to fill to
                            // 11 as 1,2,3,4,1,2,3,4,2,3
                            memoArray[i][j]=getMin(memoArray[i-1][j],1+memoArray[i][j-coinArray[i-1]]);
                            
                        }else if(i>1){
                            //if the value is less than the value of the current coin, it adds
                            //number of coins in the row above it
                            memoArray[i][j]=memoArray[i-1][j];
                        }else{
                            //first row of the array(the ones place), fills up with the values of j to get the table started
                            memoArray[i][j]=j;
                        }
                    }
                }
                
                //gets the value of the bottom right of the 2d array
                int i=memoArray.length-1;
                int j=memoArray[0].length-1;
		while(memoArray[i][j]>0){//runs until the number of coins is zero                  
                    
                    if(memoArray[i-1][j]==memoArray[i][j]){
                        //the number of the coins to make the value is the same
                        //as the row above it it decrements the row(changes the coins
                        //value)
                        i--;
                    }else{
                        //if the number of coins is not the same in the row above
                        //the array indices the coins value left along the columns
                        //by decrementing j by the coins value
                        j-=coinArray[i-1];
                        
                        //adds the value of the coin to the list that will be the output
                        coinList.add(coinArray[i-1]);
                    }                    
                }
		*/
                
                
                
                int [] memoArray2 = new int[changeDue+1];
                int [] outputArray2 = new int[changeDue+1];
                
                int maximum=Integer.MAX_VALUE-1;
                
                memoArray2[0]=0;
                outputArray2[0]=-1;
                for(int i=1; i<changeDue+1; i++){
                    memoArray2[i]=maximum;
                    outputArray2[i]=-1;
                }
                
                for(int i=0; i<coinArray.length;i++){
                    for(int j=0; j<changeDue+1; j++){     
                        if(j>=coinArray[i]){   
                            
                            int temp = memoArray2[j];                            
                            memoArray2[j]=getMin((memoArray2[j-coinArray[i]]+1),j);
                            
                            if(memoArray2[j]<=temp){
                                outputArray2[j]=i;
                            }
                        }                                           
                    }
                }
                
                int i=changeDue;
                while(i>0){
                    if(outputArray2[i]==-1){
                        List<Integer> emptyList = new ArrayList<Integer>();
                        return emptyList; 
                    }else{
                        coinList.add(coinArray[outputArray2[i]]);
                        i-=coinArray[outputArray2[i]];
                    }
                    
                }
                
		return coinList;
		
	}
        
        
        //function to grab the minimum between two ints
        public static int getMin(int one, int two){
            if(one<=two){
                return one;
            }
            else{
                return two;
            }           
        }
	
}
