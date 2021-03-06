package quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		// int[] inputArray = {1, 2, 3, 4, 5, 6, 7 , 8};
		Path path = Paths.get(args[0]);
		int n = 10000;
		int inputArray[] = new int[n];
		int i = 0;
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String line = null;
			while ((line = reader.readLine()) != null) {
				inputArray[i++] = Integer.parseInt(line);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		int numComparisons = Quicksort.sort(inputArray, 0, inputArray.length);
		System.out.println("Sorted Array is: " + Arrays.toString(inputArray));
		System.out.println("numComparisons: " + numComparisons);
	}
}
