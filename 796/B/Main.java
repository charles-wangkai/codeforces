import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] h = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < h.length; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		int[] u = new int[k];
		int[] v = new int[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			u[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(n, h, u, v));
	}

	static int solve(int n, int[] h, int[] u, int[] v) {
		Set<Integer> holes = Arrays.stream(h).boxed().collect(Collectors.toSet());

		int bone = 1;
		if (!holes.contains(bone)) {
			for (int i = 0; i < u.length; i++) {
				if (u[i] == bone) {
					bone = v[i];
				} else if (v[i] == bone) {
					bone = u[i];
				}

				if (holes.contains(bone)) {
					break;
				}
			}
		}

		return bone;
	}
}
