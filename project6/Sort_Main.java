import java.io.*;
import java.util.*;

//**************************************************
// 
// Author: N8 Swalley
// Date: Monday, 6-April 2020
//
// 
//**************************************************

public class Sort_Main 
{    
   
    public static void main(String[] args) 
	{
        
        System.out.println("What's the size of the list you would like to sort?");        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("");
        
        Comparable [] list = new Comparable[n];
        Comparable [] bubbleSort = new Comparable[n];
        Comparable [] selectionSort = new Comparable[n];
        Comparable [] insertionSort = new Comparable[n];
		Comparable [] quickSort = new Comparable[n];
        Comparable [] mergeSort = new Comparable[n];
        
        int num;
        for (int i = 0; i < n; i++)  // loop for filling the arrays
		{
            num = (int)(n*Math.random()+1);
            list[i] = num;
            bubbleSort[i] = num;
            selectionSort[i] = num;
            insertionSort[i] = num;
			quickSort[i] = num;
            mergeSort[i] = num;
        }
        
        if (n<=100)
		{
			System.out.println("Original List: ");
            for (int i = 0; i < n; i++)
			{
				System.out.print(list[i]+ " ");
            }
            System.out.println();
        }
        System.out.println("");
       
		Sort_Time.bubbleSortTime(bubbleSort);
        Sort_Time.selectionSortTime(selectionSort);
        Sort_Time.insertionSortTime(insertionSort);
		Sort_Time.quickSortTime(quickSort);
        Sort_Time.mergeSortTime(mergeSort);        
    }
}

