/*
---------- PROJECT EULER PROBLEM 23 DESCRIPTION ----------


A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.


*/


import java.util.*;


public class Problem23 {

	public static ArrayList<Integer> divisors(int n) {
		// Return ArrayList of n's proper divisors
		
		ArrayList divs = new ArrayList();

		for (int i=1; i<n; i++) {
			if (n % i == 0) divs.add(i);
		}
		
		return divs;		
	}
	
	public static boolean isAbundant(int n) {
		// Return true if the sum of the divisors of n is greater than n
		
		int sum = 0;
		ArrayList<Integer> divs = divisors(n);

		for (int i=0; i<divs.size(); i++) {
			sum += divs.get(i);
		}

		if (sum > n) return true;
		
		return false;
	}
	
	public static boolean sumOfTwoAbundants(int n, ArrayList<Integer> abundants) {
		// Return true if n can be expressed as the sum of 2 abundant numbers

		for (int i=0; i<abundants.size(); i++) {
			int base = abundants.get(i);

			for (int j=0; j<abundants.size(); j++) {
				int abundantSum = base + abundants.get(j);

				if (abundantSum > n) break;
				else if (abundantSum == n) return true;
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// All numbers greater than 28123 can be expressed as a sum of 2 abundant numbers 
		
		int LIMIT = 28123;
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		
		for (int i=0; i<=LIMIT; i++) {
			if (isAbundant(i)) abundants.add(i);
		}

		int sumOfNonAbundants = 0;
		
		for (int k=1; k<LIMIT; k++) {
			if (!sumOfTwoAbundants(k, abundants)) sumOfNonAbundants += k;
		}
		
		System.out.println(sumOfNonAbundants);
	}

}
