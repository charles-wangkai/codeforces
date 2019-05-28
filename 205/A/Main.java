import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] times = new int[n];
		for (int i = 0; i < times.length; i++) {
			times[i] = sc.nextInt();
		}
		System.out.println(solve(times));

		sc.close();
	}

	static String solve(int[] times) {
		int resultIndex = 0;
		boolean multiple = false;
		for (int i = 1; i < times.length; i++) {
			if (times[i] < times[resultIndex]) {
				resultIndex = i;
				multiple = false;
			} else if (times[i] == times[resultIndex]) {
				multiple = true;
			}
		}

		return multiple ? "Still Rozdil" : String.valueOf(resultIndex + 1);
	}
}
