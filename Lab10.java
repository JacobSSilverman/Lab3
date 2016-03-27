import java.util.*;

//fix the deep copy

public class Lab10 {

    public static void printArray(int[] arr) {
	System.out.print("[ ");
	for (int j=0; j < (arr.length - 1); j++) {
	    System.out.print(arr[j] + ", ");
	}
	if (arr.length > 0) {
	    System.out.print(arr[arr.length - 1]);
	}
	System.out.println(" ]");
	    
    }

    public static Boolean isSorted(int[] arr){
	Boolean toSort = true; 
	for (int i = 0; i < (arr.length - 1); i++){
	    if (!(arr[i] <= arr[i+1])){
		toSort = false;
	    }//if 

	    
	}//for loop
	return toSort;
    }//isSorted
    public static void swap(int[] arr, int index1, int index2) {
	if (index1 == index2) {
	    // Do nothing!
	} else {
	    int tmp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = tmp;
	}
    }

    public static int[][] deepCopy(int[][] arr){
	int[][] newArr = new int[arr.length][];
	for(int i = 0; i < (arr.length); i++){
	    int[] array = arr[i];
	    int length = array.length;
	    newArr[i] = new int[length];
	    for(int j = 0; j < length; j++){
		newArr[i][j] = array[j];
	    }//for loop
	}//for loop
	return newArr;
    }//deep copy

    public static void bubbleSort(int[][] arr){
	int numSwap;
	System.out.println("These Arrays are sorted using Bubble Sort!");
	for (int i = 0; i < (arr.length); i++){	    
	    int[] array = arr[i];
	    Boolean sorted = isSorted(array);
	    System.out.println();
	    System.out.println("Array number " + i);
	    numSwap = 0;
	    while (!sorted){	        
		for (int j = 0; j < array.length-1 ; j++){
		    int k = j + 1;
		    if (array[j] > array[k]){
			int temp = array[j];
			array[j] = array[k];
			array[k] = temp;
			numSwap++;			
		    }//if
		    
		}//for loop
		sorted = isSorted(array);
	    }//while loop 
	    printArray(array);
	    System.out.println("Number of Swaps: " + numSwap);
	    
	}//for loop
	System.out.println();

    }//bubble sort
    
    public static void selectionSort(int[][] arr) {
	System.out.println("These are the Arrays sorted using Selection Sort!");


	if (arr.length < 2) {
	    return;
	}
	int numSwap = 0;
	int minIndex = 0;
	int minValue = 0;
	for (int i = 0; i < (arr.length); i++){
	    int [] array = arr[i];
	    System.out.println();
	    System.out.println("Array Number " + i);
	    numSwap = 0;
	    for (int j = 0; j < (array.length); j++) {

		minIndex = j;
		minValue = array[j];
		for(int k = j + 1; k < array.length; k++) {

		    if (array[k] < minValue) {

			minValue = array[k];
			minIndex = k;
			numSwap++;
		    }
		    
		}
		swap(array, j, minIndex);

		
	    }
	    printArray(array);
	    System.out.println("Number of Swaps: " + numSwap);
	}

    }

    public static void main(String[] args) {
	int[][] a1 = { {8, 9, 5, 6, 4, 3},
		       {9, 0, 14, 13, 10, 8, 2, 1, 17, 18, 19, 201, 220, 235, 2},
		       {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 },
		       {22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 1},
		       {20, 18, 13, 12, 11, 9, 6, 5, 4, 3, 2, 1, -87, -900, -9, -909, -911, -80, -44, -32, -1000} };
	int[][] a2;
	a2 = deepCopy(a1);
	bubbleSort(a1);
	selectionSort(a2);
	
    }

    
}