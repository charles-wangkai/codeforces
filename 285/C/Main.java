import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(a));
	}

	static long solve(int[] a) {
		int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		long result = 0;
		for (int i = 0; i < sorted.length; i++) {
			result += Math.abs(sorted[i] - (i + 1));
		}
		return result;
	}
}
