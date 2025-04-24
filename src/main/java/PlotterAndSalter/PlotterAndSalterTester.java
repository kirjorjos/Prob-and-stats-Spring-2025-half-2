package PlotterAndSalter;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PlotterAndSalterTester {
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		Function function = Plotter.getFunction("(x^3)+(x^2)+3x+1");
		
		XYSeries initialCoords = Plotter.graphFunction(function, -50, 50);
		XYSeries saltedCoords = Salter.salt(initialCoords, 10000);
		XYSeries smoothedCoords = Smoother.smooth(saltedCoords, 10, true);
		
		System.out.println("Initial Coords: " + initialCoords.getItems());
		System.out.println("Salted Coords: " + saltedCoords.getItems());
		System.out.println("Smoothed Coords: " + smoothedCoords.getItems());
		
		DataHandler.write(initialCoords, "Initial.csv");
		DataHandler.write(saltedCoords, "Salted.csv");
		DataHandler.write(smoothedCoords, "Smoothed.csv");
		
		JFreeChart initialPlot = ChartFactory.createScatterPlot("Initial Coordinates", "X", "Y", new XYSeriesCollection(initialCoords));
		JFreeChart saltedPlot = ChartFactory.createScatterPlot("Salted Coordinates", "X", "Y", new XYSeriesCollection(saltedCoords));
		JFreeChart smoothedPlot = ChartFactory.createScatterPlot("Smoothed Coordinates", "X", "Y", new XYSeriesCollection(smoothedCoords));
		
		ChartUtils.saveChartAsPNG(new File("initial.png"), initialPlot, (int) Math.min(1200, Math.max(400, 50*(initialCoords.getMaxX()-initialCoords.getMinX()))), (int) Math.min(1000, Math.max(400, 50*(initialCoords.getMaxY()-initialCoords.getMinY()))));
		ChartUtils.saveChartAsPNG(new File("salted.png"), saltedPlot, (int) Math.min(1200, Math.max(400, 50*(saltedCoords.getMaxX()-saltedCoords.getMinX()))), (int) Math.min(1000, Math.max(400, 50*(saltedCoords.getMaxY()-saltedCoords.getMinY()))));
		ChartUtils.saveChartAsPNG(new File("smoothed.png"), smoothedPlot, (int) Math.min(1200, Math.max(400, 50*(smoothedCoords.getMaxX()-smoothedCoords.getMinX()))), (int) Math.min(1000, Math.max(400, 50*(smoothedCoords.getMaxY()-smoothedCoords.getMinY()))));
	}
}
