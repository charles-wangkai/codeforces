import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int LIMIT = 1_000_030;

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] w = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w.length; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(w));
	}

	static int solve(int[] w) {
		int[] counts = new int[LIMIT];
		for (int wi : w) {
			counts[wi]++;
		}

		int result = 0;
		int index = 0;
		while (true) {
			while (index != counts.length && counts[index] == 0) {
				index++;
			}

			if (index == counts.length) {
				break;
			}

			if (counts[index] == 1) {
				counts[index]--;
				result++;
			} else {
				counts[index] -= 2;
				counts[index + 1]++;
			}
		}

		return result;
	}
}
