package main;


import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

//Works :)
//Finding the leftmost index location of a given number (numToFind) within a sorted (ascending) list of integers,
//in the most efficient method.
public class BinarySearch {

	public static void main(String[] args) {
		int[] myIntArray = {0 ,1 ,1, 2, 2, 5, 6, 8, 8, 9, 10, 10, 10, 11, 11, 15};
		String strNumToFind = JOptionPane.showInputDialog("What number would you like to find the leftmost index of?");
		int numToFind = Integer.parseInt(strNumToFind);
		System.out.print("Array to search within: ");
		//easy way to print the contents of an array
		System.out.print(Arrays.toString(myIntArray));
		System.out.println("\nThe length of this array is " + myIntArray.length);
		
		//Print the solution:
		System.out.println("\nThe leftmost index of " + numToFind + " is " + printStartIndex(myIntArray, numToFind));
	}

	public static int printStartIndex(int[] arrayList, int numToFind){
		int targetIndex = 0;
		int fakeLeftIndex = 0;
		int fakeRightIndex = arrayList.length;
		boolean isfoundTargetIndex = false;
		
		//while we have not found the target index, keep going through the loop searching.
		while (!isfoundTargetIndex){
			targetIndex = (fakeLeftIndex + fakeRightIndex)/2;
			
			//if we found the number
			if (arrayList[targetIndex] == numToFind){
				//make sure you are not at the very end left of the array
				if(targetIndex == 0){
					return 0;
				}
				//if you are not at the very end left of the array, check if you have reached 
				//the very left occurance of your number
				if(arrayList[targetIndex-1] < numToFind){
					return targetIndex;
				}
				else{
					fakeRightIndex = targetIndex;
				}
			}
			
			//if the number is in the index is larger than our numToFind
			else if (arrayList[targetIndex] > numToFind){
				//set the target our right end
				fakeRightIndex = targetIndex;
			}
			
			//if the number is in the index is smaller than our numToFind
			else if (arrayList[targetIndex] < numToFind){
				//set the target our left end
				fakeLeftIndex = targetIndex;
			}
		}
		return targetIndex;
	}
}
