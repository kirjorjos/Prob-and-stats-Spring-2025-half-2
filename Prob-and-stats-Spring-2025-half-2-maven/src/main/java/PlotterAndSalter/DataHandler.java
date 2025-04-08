package PlotterAndSalter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {
	public static void write(ArrayList<Coordinate> coords, String filePath) throws IOException {
		FileWriter file = new FileWriter(filePath);
		String fileContent = "";
		for (int i = 0; i<coords.size(); i++) {
			Coordinate coord = coords.get(i);
			fileContent += (coord.getX() + ", " + coord.getY() + "\n");
		}
		file.write(fileContent);
		file.close();
	}
	
	public static ArrayList<Coordinate> read(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
		Scanner fileReader = new Scanner(file);
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			String[] stringCoords = line.split(", ");
			int x = Integer.parseInt(stringCoords[0]);
			double y = Double.parseDouble(stringCoords[1]);
			coords.add(new Coordinate(x, y));
		}
		fileReader.close();
		return coords;
	}
}
