package PlotterAndSalter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class DataHandler {
	/**
	 * Write the coordinates to the given file
	 * @param coords The coordinates to write
	 * @param filePath The file to write to
	 * @throws IOException If for some reason, the file can't be made
	 */
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
	
	/**
	 * Read a file to get the coordinates
	 * @param filePath The file to read
	 * @return The read coordinates
	 * @throws FileNotFoundException If the file isn't there
	 */
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
