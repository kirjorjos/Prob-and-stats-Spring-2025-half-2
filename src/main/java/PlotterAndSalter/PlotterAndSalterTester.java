package PlotterAndSalter;

import java.io.IOException;
import org.jfree.data.xy.XYSeries;

public class PlotterAndSalterTester {
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		Function function = Plotter.getFunction("(x^3)+(x^2)+3x+1");
		XYSeries initialCoords = Plotter.graphFunction(function, -50, 50);
		XYSeries saltedCoords = Salter.salt(initialCoords, 10);
		XYSeries smoothedCoords = Smoother.smooth(saltedCoords, 5, true);
		System.out.println("Initial Coords: " + initialCoords.getItems());
		System.out.println("Salted Coords: " + saltedCoords.getItems());
		System.out.println("Smothed Coords: " + smoothedCoords.getItems());
		DataHandler.write(initialCoords, "Initial.csv");
		DataHandler.write(saltedCoords, "Salted.csv");
		DataHandler.write(smoothedCoords, "Smoothed.csv");
	}
}
