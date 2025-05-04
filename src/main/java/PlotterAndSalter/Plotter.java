package PlotterAndSalter;

import org.jfree.data.xy.XYSeries;

public class Plotter {
	/**
	 * Get the function object for the equation
	 * @param userInput The equation to get the function of
	 * @return The function object
	 */
	public static Function getFunction(String userInput) {
		Function function = new Function(userInput);
		return function;
	}
	
	/**
	 * Graph a function object
	 * @param function The function to graph
	 * @param minX The minimum x coordinate
	 * @param maxX The maximum x coordinate
	 * @return The graph object
	 */
	public static XYSeries graphFunction(Function function, int minX, int maxX) {
		XYSeries coords = new XYSeries(function.toString());
		for (int i = 0; i < (maxX-minX); i++) {
			coords.add(minX++, function.run(i));
		}
		return coords;
	}
}
