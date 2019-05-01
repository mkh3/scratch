package exercise;

import java.util.List;

/**
 * @author M K Hayat
 * 
 * Helper class for Q3
 *
 */
public class SweepResult {

	
	
	private Integer max;
	private List<Integer> dataList;

	public SweepResult(Integer max, List<Integer> dataList) {
		this.max = max;
		this.dataList = dataList;
	}

	/**
	 * @return the max
	 */
	public Integer getMax() {
		return max;
	}

	/**
	 * @return the dataList
	 */
	public List<Integer> getDataList() {
		return dataList;
	}
	
}
