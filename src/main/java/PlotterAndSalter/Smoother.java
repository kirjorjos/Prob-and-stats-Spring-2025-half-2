package PlotterAndSalter;

import java.util.ArrayList;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class Smoother {

	public static XYSeries smooth(XYSeries saltedCoords, int windowValue, boolean useNewCoords) throws CloneNotSupportedException {
		XYSeries newCoords = (XYSeries) saltedCoords.clone();
		int dataSize = saltedCoords.getItemCount();
		for (int i = 0; i < dataSize; i++) {
			ArrayList<Double> tempYs = new ArrayList<Double>();
			for (int j = (Math.max(0, i-windowValue)); j < Math.min(dataSize, i+windowValue); j++) {
				if (useNewCoords) {
					tempYs.add((double) newCoords.getDataItem(j).getY());
				} else {
					tempYs.add((double) saltedCoords.getDataItem(j).getY());
				}
			}
			newCoords.add(new XYDataItem((double) newCoords.getDataItem(i).getX(), average(tempYs.toArray(new Double[0]))));
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
