import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String t = sc.next();
		String p = sc.next();
		int[] a = new int[t.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(t, p, a));

		sc.close();
	}

	static int solve(String t, String p, int[] a) {
		int result = -1;
		int lower = 0;
		int upper = t.length();
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (check(t, p, a, middle)) {
				result = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return result;
	}

	static boolean check(String t, String p, int[] a, int removeCount) {
		boolean[] removed = new boolean[t.length()];
		for (int i = 0; i < removeCount; i++) {
			removed[a[i] - 1] = true;
		}

		int index = 0;
		for (char target : p.toCharArray()) {
			while (index < t.length() && (removed[index] || t.charAt(index) != target)) {
				index++;
			}

			if (index == t.length()) {
				return false;
			}

			index++;
		}

		return true;
	}
}
