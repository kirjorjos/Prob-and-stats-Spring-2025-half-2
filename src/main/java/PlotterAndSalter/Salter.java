package PlotterAndSalter;

import java.util.Random;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class Salter {
	
	static Random rand = new Random();
	
	public static XYSeries salt(XYSeries coords, double saltingRange) {
		XYSeries newCoords = new XYSeries("Salted");
		for (Object element : coords.getItems()) {
			XYDataItem coord = (XYDataItem) element;
			double randomSaltValue = rand.nextDouble(saltingRange);
			if (rand.nextBoolean()) {	//Subtract the random salt value
				newCoords.add(new XYDataItem(coord.getX(), (double) coord.getY() - randomSaltValue));
			} else {	//Add the random salt value
				newCoords.add(new XYDataItem(coord.getX(), (double) coord.getY() + randomSaltValue));
			}
		}
		return newCoords;
	}
}
