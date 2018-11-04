package com.mukit.lambda;

public class MyMath {

	public static boolean checker(PerformOperation p, int num) {
		
		return p.check(num);
	}
	
	public PerformOperation isOdd() {
		
		PerformOperation isOddOperation = number -> ((number & 1) == 1) ? true : false;
		return isOddOperation;
	}
	
	public boolean isPrime(int number) {
		
		if(number <= 1)
			return false;
		if(number <= 3)
			return true;
		
		if(number%2 == 0)
			return false;
		
		int sqareRoot = (int) Math.sqrt(number);
		
		for(int i = 3; i<=sqareRoot; i+=2) {
			
			if(number%i == 0)
				return false;
		}
		return true;
	}
	
	public PerformOperation isPrime() {
		
		PerformOperation isPrimeOperation = number -> isPrime(number);
		return isPrimeOperation;
	}
	
	public boolean checkPalindrome(int number) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(number);
		String originalNumber = stringBuilder.toString();
		
		StringBuilder stringBuilder2 = stringBuilder.reverse();
		String reversedNumber = stringBuilder2.toString();
		if(originalNumber.equals(reversedNumber))
			return true;
		return false;
	}
	
	public PerformOperation isPalindrome() {
		
		PerformOperation isPrimeOperation = number -> checkPalindrome(number);
		return isPrimeOperation;
	}
}
