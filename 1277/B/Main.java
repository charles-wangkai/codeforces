import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a));
		}

		sc.close();
	}

	static int solve(int[] a) {
		Map<Integer, Integer> remainToMoveNum = new HashMap<>();
		for (int ai : a) {
			int remain = ai;
			int moveNum = 0;
			while (remain % 2 == 0) {
				remain /= 2;
				moveNum++;
			}

			remainToMoveNum.put(remain, Math.max(remainToMoveNum.getOrDefault(remain, 0), moveNum));
		}

		return remainToMoveNum.values().stream().mapToInt(x -> x).sum();
	}
}
