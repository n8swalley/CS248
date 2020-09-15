import java.io.*;
import java.util.*;

//**************************************************
// 
// Author: N8 Swalley
// Date: Monday, 6-April 2020
//
// 
//**************************************************
public class Sort_Time 
{
    public static long beforeTime; 
    public static long afterTime;
    
    public static void bubbleSortTime(Comparable [] bubbleSort)
	{
        beforeTime = System.currentTimeMillis();
        Sorts.bubble(bubbleSort);
        afterTime = System.currentTimeMillis();
        
        if (bubbleSort.length <= 100)
		{
            System.out.println("Bubble Sorted List: "); // Print the list if less than 100
            for (int i = 0; i < bubbleSort.length; i++)
			{
				System.out.print(bubbleSort[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Bubble Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
    
    public static void insertionSortTime(Comparable [] insertionSort)
	{
        beforeTime = System.currentTimeMillis();
        Sorts.insertion(insertionSort);
        afterTime = System.currentTimeMillis();
        
        if (insertionSort.length <= 100)
		{
            System.out.println("Insertion Sorted List: ");
            for (int i = 0;i<insertionSort.length;i++)
			{
				System.out.print(insertionSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Insertion Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
   
    public static void quickSortTime(Comparable [] quickSort)
	{
        beforeTime = System.currentTimeMillis();
        Sorts.quick(quickSort);
        afterTime = System.currentTimeMillis();
        
        if (quickSort.length <= 100)
		{
            System.out.println("Quick Sorted List: ");
            for (int i = 0; i < quickSort.length; i++) 
			{
				System.out.print(quickSort[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Quick Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
	
	 public static void selectionSortTime(Comparable [] selectionSort)
	{
        beforeTime = System.currentTimeMillis();
        Sorts.selection(selectionSort);
        afterTime = System.currentTimeMillis();
  
        if (selectionSort.length <= 100)
		{
            System.out.println("Selection Sorted List: ");
            for (int i = 0; i < selectionSort.length; i++)
			{
				System.out.print(selectionSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Selection Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
	
	public static void mergeSortTime(Comparable [] mergeSort)
	{
        beforeTime = System.currentTimeMillis();
        Sorts.merge(mergeSort);
        afterTime = System.currentTimeMillis();
     
        if (mergeSort.length <= 100)
		{
            System.out.println("Merge Sorted List: ");
            for (int i = 0; i < mergeSort.length; i++)
			{
				System.out.print(mergeSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Merge Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
}