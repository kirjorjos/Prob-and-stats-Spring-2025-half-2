package PlotterAndSalter;

import org.jfree.data.xy.XYSeries;

public class Plotter {
	
	public static Function getFunction(String userInput) {
		Function function = new Function(userInput);
		return function;
	}
	
	public static XYSeries graphFunction(Function function, int minX, int maxX) {
		XYSeries coords = new XYSeries(function.toString());
		for (int i = 0; i < (maxX-minX); i++) {
			coords.add(minX++, function.run(i));
		}
		return coords;
	}
}
