public class MaxDifferenceCalculation {

	public static void main(String[] args) {
		int array[] = { 1, 2, 6, 4 };
		System.out.println("Maximum differnce is " + maxDifference(array));
	}
	
	static int maxDifference(int array[]) {
		int result = calcFistDiference(array[1], array[0]);
		for (int i = 0; i < array.length; i++)
			for (int j = i + 1; j < array.length; j++)
				if (array[j] - array[i] > result)
					result = array[j] - array[i];

		return result;
	}

	private static int calcFistDiference(int array1, int array0) {
		int result = array1 - array0;
		if (result < -1)
			return -1;
		return result;
	}

	
}