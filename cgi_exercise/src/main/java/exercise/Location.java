package exercise;

public class Location {

	/**
	 * Class encapsulating a simple way to model balloon coordinates
	 * 
	 * @author stuart
	 *
	 */

	private int where;

	/**
	 * Constructor Simple implementation with just a single int to signify basic
	 * concept of location
	 * 
	 * @param where
	 */
	public Location(final int where) {
		this.where = where;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + where;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (where != other.where)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Location [where=" + where + "]";
	}
	
	public int compareTo(Location other) {
		return Integer.compare(this.where, other.where);
	}
}
