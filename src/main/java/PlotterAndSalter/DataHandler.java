package PlotterAndSalter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class DataHandler {
	public static void write(XYSeries coords, String filePath) throws IOException {
		FileWriter file = new FileWriter(filePath);
		String fileContent = "";
		for (int i = 0; i < coords.getItemCount(); i++) {
			XYDataItem coord = coords.getDataItem(i);
			fileContent += (coord.getX() + ", " + coord.getY() + "\n");
		}
		file.write(fileContent);
		file.close();
	}
	
	public static XYSeries read(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		XYSeries coords = new XYSeries(file.getName());
		Scanner fileReader = new Scanner(file);
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			String[] stringCoords = line.split(", ");
			int x = Integer.parseInt(stringCoords[0]);
			double y = Double.parseDouble(stringCoords[1]);
			coords.add(x, y);
		}
		fileReader.close();
		return coords;
	}
}
