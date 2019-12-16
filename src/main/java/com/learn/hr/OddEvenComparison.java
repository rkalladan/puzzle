package com.learn.hr;

import java.util.Scanner;

public class OddEvenComparison {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			String length = scanner.nextLine();
			if(Integer.parseInt(length)>=1 && Integer.parseInt(length)<=1000) {
				String array = scanner.nextLine();
				String numbersArray[] = array.split("[\\s]");
				if(numbersArray.length>=1 && numbersArray.length<=1000) {
					int evenCount = 0;
					int oddCount =0;

					for(int i =0;i<numbersArray.length;i++) {
						int number = Integer.parseInt(numbersArray[i]);
						if(number%2==0) {
							evenCount=evenCount+number;
						}else {
							oddCount=oddCount+number;
						}
					}
					if(evenCount>oddCount) {
						System.out.print("Even");
					}else if(oddCount>evenCount) {
						System.out.print("odd");
					}else {
						System.out.print("Tied");
					}
				}

			}
		}	

	}

	//System.out.println(evenCount +"=="+oddCount);
}
