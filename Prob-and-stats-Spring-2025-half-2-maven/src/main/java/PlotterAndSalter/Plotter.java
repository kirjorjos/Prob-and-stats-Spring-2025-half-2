package PlotterAndSalter;

import java.util.ArrayList;

public class Plotter {
	
	public static Function getFunction(String userInput) {
		Function function = new Function(userInput);
		return function;
	}
	
	public static ArrayList<Coordinate> graphFunction(Function function, int minX, int maxX) {
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
		for (int i = 0; i < (maxX-minX); i++) {
			coords.add(new Coordinate(minX++, function.run(i)));
		}
		return coords;
	}
}
