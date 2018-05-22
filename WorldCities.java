package SortingitAllout;

/*Richard Thomas
 * CSI 201
 * Lab 3 Checkpoint
 * Due Date: 11/15/2016
 * I colloborated with Brittany Chlesea for file reading
 */
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdDraw;

public class WorldCities {

	public static void writeTofile(String filename, City[] cities) { //create and write text file
		Out output = new Out(filename);
		for (int i = 0; i < cities.length; i++) {
			output.println(cities[i].toString());
		}

	}

	public static void displayCities(City[] cities, int count, int time) { // draw # of cities 

		int WINDOW_WIDTH = 720;
		int WINDOW_HEIGHT = 360;
		double x = 0;
		double y = 0;
		StdDraw.setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);
		StdDraw.picture(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, "file:world.png");
		StdDraw.setPenColor(StdDraw.RED);

		for (int index = cities.length - 1; index > cities.length - count - 1; index--) {
			x = WINDOW_WIDTH / 2 + cities[index].CITYLONGITUDE / 180 * 360;
			y = WINDOW_HEIGHT / 2 + cities[index].CITYLATITUDE / 90 * 180;
			StdDraw.filledRectangle(x, y, 5, 5);
			StdDraw.pause(time);
		}
	}

	public static void main(String[] args) { // read text file, sort and draw
		City[] cities = new City[47913];
		In input = new In("world_cities.txt");
		int counter = 0;
		while (!input.isEmpty()) { // read text file and arrange elements
			String line = input.readLine();
			String[] token = line.split(",");
			cities[counter] = new City(token[0], token[2], token[1], Integer.parseInt(token[3]),
					Double.parseDouble(token[4]), Double.parseDouble(token[5]));
			counter++;

		}
		//Sort and Draw
		System.out.println("done");
		QuickSort.quickSort(cities, 0, cities.length, "name");
		System.out.println("done");
		writeTofile("cities_alpha.txt", cities);
		System.out.println("done");
		QuickSort.quickSort(cities, 0, cities.length, "latitude");
		writeTofile("cities_latitude.txt", cities);
		QuickSort.quickSort(cities, 0, cities.length, "population");
		writeTofile("cities_population.txt", cities);
		System.out.println("done");
		displayCities(cities, 50, 1000);
	}

}
