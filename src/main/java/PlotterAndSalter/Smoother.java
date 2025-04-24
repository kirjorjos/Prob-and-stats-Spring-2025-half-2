package PlotterAndSalter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class Smoother {

	public static XYSeries smooth(XYSeries saltedCoords, int windowValue, boolean useNewCoords) {
		XYSeries smoothedCoords = new XYSeries("Smoothed");
		List<XYDataItem> saltedCoordsList = saltedCoords.getItems();

		int windowSize = windowValue * 2 + 1;
		int saltedCoordsSize = saltedCoordsList.size();

		ArrayList<Double> workingY = new ArrayList<>();
		for (XYDataItem item : saltedCoordsList) {
			workingY.add(item.getYValue());
		}

		for (int i = windowValue; i < (saltedCoordsSize - windowValue); i++) {
			double sum = 0;
			for (int j = i - windowValue; j <= i + windowValue; j++) {
				sum += workingY.get(j);
			}
			double average = sum / windowSize;
			double x = saltedCoordsList.get(i).getXValue();
			smoothedCoords.add(x, average);

			if (useNewCoords) {
				workingY.set(i, average);
			}
		}
		
		return smoothedCoords;
	}
}
