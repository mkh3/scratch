package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author M K Hayat
 * 
 * Class contains basic logic to find the k highest 
 * numbers from an integer array.
 * 
 * Edit the variables 'data' and 'k' to alter the input and run the main method.
 *
 */
public class Q3_HighNumbers {

	public static void main(String[] args) {
		Integer[] data;
		
		
		data = new Integer[] { 10, 4, 30, 3, 2, -5, 6, 24, 1, 0 };
		int k = 4;
		/*
		 * data is the input
		 * 'k' is however many highest integers you want out of data
		 */

	
		System.out.println(k+" highest numbers are: "+getKHighestNumbers(data, k));

	}

	/**
	 * @param data Input array of integers
	 * @param k How many highest integers do you want?
	 * @return k highest integers from data
	 */
	private static List<Integer> getKHighestNumbers (Integer data[], int k){
		
		if(k>data.length) {
			System.out.println("Error: k is higher than the length of input array");
			return null;
		}
		
		List<Integer> dataList = Arrays.asList(data);

		List<Integer> maxNumbers = new ArrayList<Integer>();
		for ( int j = 0; j < k; j++ ) {
			
			SweepResult sr = getMaxAndResidualList(dataList);
			maxNumbers.add(sr.getMax());
			dataList = sr.getDataList();
			
		}
		
		return maxNumbers;
	}

	/**
	 * @param list input list of integers
	 * @return SweepResult object that contains the highest integer from the input list
	 * and the residual list after that highest integer has been removed
	 */
	private static SweepResult getMaxAndResidualList(List<Integer> list) {

		Integer max = list.get(0);
		int maxPosition = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= max) {
				max = list.get(i);
				maxPosition = i;
			}

		}

		SweepResult result = new SweepResult(max, removeFromList(maxPosition, list));

		return result;
	}

	/**
	 * @param p Position of integer to be removed from the input list
	 * @param list the input list
	 * @return
	 */
	private static List<Integer> removeFromList(int p, List<Integer> list) {

		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			if (i < p) {
				left.add(list.get(i));
			} else if (i == p) {
				continue;
			} else {
				right.add(list.get(i));
			}
		}

		left.addAll(right);
		return left;

	}


}
