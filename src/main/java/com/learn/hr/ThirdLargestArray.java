package com.learn.hr;

import java.util.*;
import java.util.regex.Pattern;

public class ThirdLargestArray {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			String length = scanner.nextLine();
			if(Integer.parseInt(length)>=3 && Integer.parseInt(length)<=1000) {
				String array = scanner.nextLine();
				String numbersArray[] = array.split("[\\s]");
				List<Integer> numbers = new ArrayList<Integer>(Integer.parseInt(length));
				for(int i =0;i<numbersArray.length;i++) {
					if(isNumeric(numbersArray[i])) {
						numbers.add(Integer.parseInt(numbersArray[i]));
					}
					System.out.println(numbersArray[i]);
				}
				System.out.println(numbersArray.length);
//				List<Integer> numbers = new ArrayList<>();
//				numbers.add(scanner.nextInt());
				numbers = bubbleSort(numbers);
				System.out.print(numbers.get(numbers.size()-3));
				
			}
		}
	}
	private static boolean isNumeric(String strNum) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	static List<Integer> bubbleSort(List<Integer> arr)
    {
		List<Integer> list = new ArrayList<Integer>();
		list= arr;
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list.get(j) > list.get(j+1))
                {
                    // swap temp and arr[i]
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
        return list;
    }

	//Heap sort .
	private static void sort(List<Integer> numbers) 
	{ 
		int n = numbers.size(); 

		// Build heap (rearrange array) 
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(numbers, n, i); 

		// One by one extract an element from heap 
		for (int i=n-1; i>=0; i--) 
		{ 
			// Move current root to end 
			Integer temp = numbers.get(0); 
			numbers.add(0, numbers.get(i));
			numbers.add(i, temp);

			// call max heapify on the reduced heap 
			heapify(numbers, i, 0); 
		} 
	} 

	// To heapify a subtree rooted with node i which is 
	// an index in arr[]. n is size of heap 
	private static void heapify(List<Integer> numbers, int n, int i) 
	{ 
		int largest = i;  // Initialize largest as root 
		int l = 2*i + 1;  // left = 2*i + 1 
		int r = 2*i + 2;  // right = 2*i + 2 

		// If left child is larger than root 
		if (l < n && numbers.get(l) > numbers.get(largest)) 
			largest = l; 

		// If right child is larger than largest so far 
		if (r < n && numbers.get(r) > numbers.get(largest)) 
			largest = r; 

		// If largest is not root 
		if (largest != i) 
		{ 
			int swap = numbers.get(i); 
			numbers.add(i, numbers.get(largest));
			numbers.add(largest, swap);

			// Recursively heapify the affected sub-tree 
			heapify(numbers, n, largest); 
		} 
	} 

}
