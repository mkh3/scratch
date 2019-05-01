package exercise;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * @author M K Hayat
 *
 */
public class Q1_Divisor {

	public static void main(String[] args) {
		
		//Edit these 2 variables to experiment with the input
		int N = 72;
		int x= 50;
		
		
		System.out.println(checkForDivisors(x, N));

	}

	//Version 1 of the method
	/**
	 * @param x Is x a divisor of N?
	 * @param N Is x a divisor of N?
	 * @return
	 */
	private static boolean checkIfDivisor(int x, int N) {
		if(x<=0)
			return false;
		return (N%x ==0);

	}

	
	
	//Version 2 of the method
	/**
	 * @param x What numbers from 1 to x are divisors of N?
	 * @param N What numbers from 1 to x are divisors of N?
	 * @return
	 */
	private static List<Integer> checkForDivisors(int x, int N) {
		
		/*
		 * The naive approach would be to iterate over all numbers from 1 to x, and check if each is a divisor.
		 * But the highest factor that any number can have (apart from itself) is 'half' of that number. (Since apart from 1
		 * , 2 is the lowest factor a number can have)
		 * 
		 * So the search space can be pruned by finding the 'half' of N, and if x happens to be higher than that, then iterate from
		 * the half-way point, rather than X.
		 * 
		 * Example:
		 * 
		 * If N = 72 and x= 50, i.e. we need to find all factors of 72 that are less than or equal to 50. Naively 
		 * we would want to iterate down from 50 to 1, checking if each was a factor. But we can prune the space by iterating from 36 (72/2)
		 * as there won't be any factors of 72 between 36 and 50.
		 */
		
		int halfway = Math.floorDiv(N, 2);
		int startingPoint = Math.min(x, halfway);

		List<Integer> result = new ArrayList<Integer>();
		for(int y = startingPoint; y>=1; y--) {
			if(checkIfDivisor(y,N)) {
				result.add(y);
			}
		}
		
		return result;
	}
}
