import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] a = readArray(sc, n);
		String[] b = readArray(sc, n);
		System.out.println(solve(a, b));

		sc.close();
	}

	static String[] readArray(Scanner sc, int size) {
		String[] result = new String[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.next();
		}

		return result;
	}

	static int solve(String[] a, String[] b) {
		List<String> aList = Arrays.stream(a).collect(Collectors.toList());

		int result = 0;
		for (String bi : b) {
			if (aList.contains(bi)) {
				aList.remove(bi);
			} else {
				result++;
			}
		}

		return result;
	}
}
