package src.PlotterAndSalter;

import java.io.IOException;
import java.util.ArrayList;

public class PlotterAndSalterTester {
	public static void main(String[] args) throws IOException {
		Function function = Plotter.getFunction("(x^3)+(x^2)+3x+1");
		ArrayList<Coordinate> initialCoords = Plotter.graphFunction(function, -50, 50);
		ArrayList<Coordinate> saltedCoords = Salter.salt(initialCoords, 10);
		ArrayList<Coordinate> smoothedCoords = Smoother.smooth(saltedCoords, 5);
		System.out.println("Initial Coords: " + initialCoords);
		System.out.println("Salted Coords: " + saltedCoords);
		System.out.println("Smothed Coords: " + smoothedCoords);
		DataHandler.write(initialCoords, "Initial.csv");
		DataHandler.write(saltedCoords, "Salted.csv");
		DataHandler.write(smoothedCoords, "Smoothed.csv");
	}
}
