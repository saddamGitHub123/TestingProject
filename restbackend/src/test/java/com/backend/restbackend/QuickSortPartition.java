/**
 * 
 */
package com.backend.restbackend;

/**
 * @author Sk Saddam Hosan
 *
 * restbackend 22-May-2018
 */
public class QuickSortPartition {
	
	   static int[] quickSort(int[] arr) {
		   
		   int size = arr.length;

	        for (int i = 0; i<size;i++){
	            for (int j = 1; j< (size-i) ; j++){
	                
	                if(arr[j-1] > arr[j]){
	                	int temp = 0;
	                    temp = arr[j-1];
	                    arr[j-1] = arr[j];
	                    arr[j] = temp;
	                }
	                
	            }    
	        }
	        return arr;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {4,5,3,7,2};

		//int p = arr[0];
		
		
		quickSort(arr);
		
		  for(int i=0; i < arr.length; i++){  
              System.out.print(arr[i] + " ");  
      }
	}

}
