package src.PlotterAndSalter;

import java.util.ArrayList;

public class Smoother {

	public static ArrayList<Coordinate> smooth(ArrayList<Coordinate> saltedCoords, int windowValue) {
		ArrayList<Coordinate> newCoords = new ArrayList<Coordinate>();
		for (Coordinate coord : saltedCoords) {
			newCoords.add(coord.clone());
		}
		for (int i = 0; i < newCoords.size(); i++) {
			double[] tempYs = new double[windowValue*2+1];
			int k = 0;
			for (int j = (Math.max(0, i-windowValue)); j < Math.min(newCoords.size(), i+windowValue); j++) {
				tempYs[k++] = newCoords.get(j).getY();
			}
			newCoords.set(i, new Coordinate(newCoords.get(i).getX(), average(tempYs)));
		}
		return newCoords;
		
	}
	
	private static double average(double[] values) {
		double total = 0;
		for (double value : values) {
			total += value;
		}
		return total/values.length;
	}

}
