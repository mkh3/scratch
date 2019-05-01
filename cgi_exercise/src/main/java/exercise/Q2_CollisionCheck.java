package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author M K Hayat
 *
 * Please refer to the readme.rtf for an explanation of the approach.
 * 
 */
public class Q2_CollisionCheck {

	
	
	public static void main (String args[]) {
		
		List<Balloon> balloonList = generateSomeBalloons();
		
		//Using Map as a tuple
		Map<Location, Set<Balloon>> result = checkForCollisions(balloonList);
		
		System.out.println("Collisions are:");
		for( Entry<Location, Set<Balloon>> x: result.entrySet()) {
			
			System.out.println("Location: "+x.getKey());
			System.out.println("\tBalloons: "+x.getValue());
		}
	}
	
	
	/**
	 * @param balloonList list of all balloons
	 * @return a Map that shows all locations where collisions have happened, with a lost of all balloons at that location
	 */
	private static Map<Location, Set<Balloon>> checkForCollisions(List<Balloon> balloonList) {
		
		Map<Location, Set<Balloon>> collisions =  new HashMap<Location, Set<Balloon>>();
		for(int i=0; i<balloonList.size(); i++) {
			
			/*
			 * For every i-th balloon...
			 * (leftBalloon)
			 */
			
			Balloon leftBalloon = balloonList.get(i);
			for(int j=i+1; j<balloonList.size(); j++) {
				
				/*
				 * ...check every balloon that is lower down in the order (i.e. i+1 to N)
				 * (rightBalloon)
				 */
				
				Balloon rightBalloon = balloonList.get(j);
				
				if(leftBalloon.isCollide(rightBalloon)) {
					
					Location l = leftBalloon.getLocation();
					//'Add' the collision
					if(collisions.containsKey(l)) {
						collisions.get(l).add(leftBalloon);
						collisions.get(l).add(rightBalloon);
					}else {
						Set<Balloon> s = new HashSet<Balloon>();
						s.add(leftBalloon); s.add(rightBalloon);
						collisions.put(l, s);
					}
				}
			}
			
		}
		
		return collisions;
	}
	
	
	
	
	/**
	 * @return Just generates some balloons. Edit this method to experiment with varying inputs.
	 */
	private static List<Balloon> generateSomeBalloons(){
		
		
		//l1 and l3 are the same
		//l4, l6 and l7 are the same
		
		Location l1 = new Location(1);
		Location l2 = new Location(-1);
		Location l3 = new Location(1);
		Location l4 = new Location(5);
		Location l5 = new Location(10);
		Location l6 = new Location(5);
		Location l7 = new Location(5);
		Location l8 = new Location(4);
		Location l9 = new Location(22);
		Location l10 = new Location(19);
		
		Balloon b1 =new Balloon("b1", l1);
		Balloon b2 =new Balloon("b2", l2);
		Balloon b3 =new Balloon("b3", l3);
		Balloon b4 =new Balloon("b4", l4);
		Balloon b5 =new Balloon("b5", l5);
		Balloon b6 =new Balloon("b6", l6);
		Balloon b7 =new Balloon("b7", l7);
		Balloon b8 =new Balloon("b8", l8);
		Balloon b9 =new Balloon("b9", l9);
		Balloon b10 =new Balloon("b10", l10);
		
		 List<Balloon> result = new ArrayList<Balloon>();
		 result.add(b1);result.add(b2);result.add(b3);result.add(b4);result.add(b5);
		 result.add(b6);result.add(b7);result.add(b8);result.add(b9);result.add(b10);

		 return result;
	}
	
}
