import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		Map<Integer, Integer> strengthToCount = new HashMap<>();
		for (int strength : a) {
			strengthToCount.put(strength, strengthToCount.getOrDefault(strength, 0) + 1);
		}

		int minStrength = Arrays.stream(a).min().getAsInt();
		int maxStrength = Arrays.stream(a).max().getAsInt();

		return strengthToCount.keySet().stream().filter(strength -> strength != minStrength && strength != maxStrength)
				.mapToInt(strengthToCount::get).sum();
	}
}
