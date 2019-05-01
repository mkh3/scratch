package exercise;


/**
 * Simple class encapsulating a Balloon. 
 * Designed to support the collission detection aspects of the problem.
 * 
 * The Balloon contains:
 * 'name' field which is simply a unique identifier for a Balloon instance. 
 * 'location  field which encapsulates a simple way to identify where in space the balloon is. This implementation is simply a single number 
 * 
 * @author stuart
 *
 */

public class Balloon {

	
	/** 
	 * Descriptive for the balloon
	 */
	private String name;
	
	/**
	 * Location of the balloon
	 */
	private Location location;
	
	public Balloon(String name, Location location) {
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Simple implementation to help drive the collision functionality. 
	 * Although probably fair to say that this is not a realistic implementation
	 * @param other
	 * @return
	 */
	public boolean isCollide(final Balloon other) {
		
		return this.location.equals(other.location);
	}
	
	@Override
	public String toString() {
		return "Balloon [name=" + name + ", location=" + location + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Balloon other = (Balloon) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
