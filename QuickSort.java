package SortingitAllout;

public class QuickSort {

	public static int partition(City[] cities, int left, int right, String field) { //split array
		City pivot = cities[right - 1];
		int i = left - 1;
		int j = left;
		City temp;
		while (j < right - 1) {

			if (field.equals("name")) { // field equals "name"
				if (cities[j].compareToCity(pivot) < 0) {
					i++;
					temp = cities[i];
					cities[i] = cities[j];
					cities[j] = temp;
				}

			}

			if (field.equals("latitude")) { // field equals "lattitude"
				if (cities[j].compareToLat(pivot) < 0) {
					i++;
					temp = cities[i];
					cities[i] = cities[j];
					cities[j] = temp;

				}

			}

			if (field.equals("population")) { // field equals "population"
				if (cities[j].compareToPop(pivot) > 0) {
					i++;
					temp = cities[i];
					cities[i] = cities[j];
					cities[j] = temp;

				}

			}
			j++;
		}
		temp = cities[i + 1];
		cities[i + 1] = cities[right - 1];
		cities[right - 1] = temp;
		return (i + 1);
	}

	public static void quickSort(City[] a, int p, int r, String field) { // sort array
		int q = partition(a, p, r, field);
		if (q > p) {
			quickSort(a, p, q, field);
		}
		if (r > q + 1)
			quickSort(a, q + 1, r, field);
		}

}
