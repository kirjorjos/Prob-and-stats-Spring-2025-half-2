package src.PlotterAndSalter;

import java.util.ArrayList;

public class Smoother {

	public static ArrayList<Coordinate> smooth(ArrayList<Coordinate> saltedCoords, int windowValue, boolean useNewCoords) {
		ArrayList<Coordinate> newCoords = new ArrayList<Coordinate>();
		for (Coordinate coord : saltedCoords) {
			newCoords.add(coord.clone());
		}
		for (int i = 0; i < newCoords.size(); i++) {
			ArrayList<Double> tempYs = new ArrayList<Double>();
			for (int j = (Math.max(0, i-windowValue)); j < Math.min(newCoords.size(), i+windowValue); j++) {
				if (useNewCoords) {
					tempYs.add(newCoords.get(j).getY());
				} else {
					tempYs.add(saltedCoords.get(j).getY());
				}
			}
			newCoords.set(i, new Coordinate(newCoords.get(i).getX(), average(tempYs.toArray(new Double[0]))));
		}
		return newCoords;
		
	}
	
	private static double average(Double[] values) {
		double total = 0;
		for (double value : values) {
			total += value;
		}
		return total/values.length;
	}

}
