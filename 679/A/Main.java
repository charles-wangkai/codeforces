import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Map<Integer, int[]> primeToPowers = new HashMap<>();

	static {
		primeToPowers.put(2, new int[] { 4, 8, 16, 32, 64 });
		primeToPowers.put(3, new int[] { 9, 27, 81 });
		primeToPowers.put(5, new int[] { 25 });
		primeToPowers.put(7, new int[] { 49 });
		primeToPowers.put(11, new int[] {});
		primeToPowers.put(13, new int[] {});
		primeToPowers.put(17, new int[] {});
		primeToPowers.put(19, new int[] {});
		primeToPowers.put(23, new int[] {});
		primeToPowers.put(29, new int[] {});
		primeToPowers.put(31, new int[] {});
		primeToPowers.put(37, new int[] {});
		primeToPowers.put(41, new int[] {});
		primeToPowers.put(43, new int[] {});
		primeToPowers.put(47, new int[] {});
	}

	public static void main(String[] args) {
		output(solve());
	}

	static String solve() {
		int primeDivisor = -1;
		for (int prime : primeToPowers.keySet()) {
			if (queryIsDivisor(prime)) {
				if (primeDivisor != -1) {
					return "composite";
				}

				primeDivisor = prime;
			}
		}

		if (primeDivisor == -1) {
			return "prime";
		} else {
			for (int power : primeToPowers.get(primeDivisor)) {
				if (queryIsDivisor(power)) {
					return "composite";
				}
			}
		}

		return "prime";
	}

	static boolean queryIsDivisor(int x) {
		output(x);
		String response = sc.next();

		return response.equals("yes");
	}

	static void output(Object o) {
		System.out.println(o);
		System.out.flush();
	}
}
