import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		int avg = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, r, avg));

		sc.close();
	}

	static long solve(int[] a, int[] b, int r, int avg) {
		long diff = Math.max(0, (long) a.length * avg - Arrays.stream(a).asLongStream().sum());

		int[] sortedIndices = IntStream.range(0, a.length).boxed()
				.sorted((index1, index2) -> Integer.compare(b[index1], b[index2])).mapToInt(x -> x).toArray();

		long result = 0;
		int index = 0;
		while (diff != 0) {
			int raiseNum = (int) Math.min(diff, r - a[sortedIndices[index]]);
			result += (long) raiseNum * b[sortedIndices[index]];

			diff -= raiseNum;
			index++;
		}

		return result;
	}
}
