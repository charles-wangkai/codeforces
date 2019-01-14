import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] x = readArray(sc);
		int[] m = readArray(sc);
		Arrays.stream(solve(x, m)).forEach(System.out::println);

		sc.close();
	}

	static int[] readArray(Scanner sc) {
		int size = sc.nextInt();
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int[] solve(int[] x, int[] m) {
		NavigableMap<Integer, Integer> priceToCount = new TreeMap<>();
		for (int xi : x) {
			priceToCount.put(xi, priceToCount.getOrDefault(xi, 0) + 1);
		}

		Map<Integer, Integer> priceToPrefixSum = new HashMap<>();
		int prefixSum = 0;
		for (int price : priceToCount.keySet()) {
			prefixSum += priceToCount.get(price);
			priceToPrefixSum.put(price, prefixSum);
		}

		int[] result = new int[m.length];
		for (int i = 0; i < result.length; i++) {
			Integer price = priceToCount.floorKey(m[i]);
			result[i] = (price == null) ? 0 : priceToPrefixSum.get(price);
		}
		return result;
	}
}
