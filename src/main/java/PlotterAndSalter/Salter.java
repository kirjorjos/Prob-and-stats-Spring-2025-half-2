package PlotterAndSalter;

import java.util.Random;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class Salter {
	
	static Random rand = new Random();
	
	/**
	 * Salt the input coordinates
	 * @param coords The coordinates to salt
	 * @param saltingRange The maximum amount to add or subtract from the data when salting
	 * @return The salted data
	 */
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
