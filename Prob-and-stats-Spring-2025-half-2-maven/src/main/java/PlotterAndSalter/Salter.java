package PlotterAndSalter;

import java.util.ArrayList;
import java.util.Random;

public class Salter {
	
	static Random rand = new Random();
	
	public static ArrayList<Coordinate> salt(ArrayList<Coordinate> coords, double saltingRange) {
		ArrayList<Coordinate> newCoords = new ArrayList<Coordinate>();
		for (Coordinate coord : coords) {
			double randomSaltValue = rand.nextDouble()*saltingRange;
			if (rand.nextBoolean()) {	//Subtract the random salt value
				newCoords.add(new Coordinate(coord.getX(), coord.getY() - randomSaltValue));
			} else {	//Add the random salt value
				newCoords.add(new Coordinate(coord.getX(), coord.getY() + randomSaltValue));
			}
		}
		return newCoords;
	}
}
