import java.util.Scanner;
import java.util.stream.IntStream;

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
		int[] counts = new int[IntStream.range(1, a.length).map(i -> a[i]).max().getAsInt() + 1];
		for (int i = 1; i < a.length; i++) {
			counts[a[i]]++;
		}

		int vote = a[0];
		int result = 0;
		for (int i = counts.length - 1; i >= vote; i--) {
			int bribeNum = Math.min(counts[i], i - vote + 1);

			counts[i - 1] += bribeNum;
			vote += bribeNum;
			result += bribeNum;
		}
		return result;
	}
}
