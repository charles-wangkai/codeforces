import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(a, m) ? "YES" : "NO");
	}

	static boolean solve(int[] a, int m) {
		boolean[] p = new boolean[m];
		boolean[] nexts = new boolean[m];

		for (int ai : a) {
			int d = ai % m;
			if (d == 0) {
				return true;
			}

			Arrays.fill(nexts, false);

			nexts[d] = true;
			int index = d;
			for (int i = 0; i < p.length; i++) {
				if (p[i]) {
					nexts[i] = true;
					nexts[index] = true;
				}

				index++;
				if (index == nexts.length) {
					index -= nexts.length;
				}
			}

			boolean[] temp = p;
			p = nexts;
			nexts = temp;

			if (p[0]) {
				return true;
			}
		}

		return false;
	}
}
