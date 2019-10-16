import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < q; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] x = new int[n];
			for (int i = 0; i < x.length; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solve(x, r));
		}
	}

	static int solve(int[] x, int r) {
		Deque<Integer> deque = new ArrayDeque<>(Arrays.stream(x).boxed().sorted().collect(Collectors.toList()));

		int left = 0;
		int result = 0;
		while (!deque.isEmpty()) {
			left += r;
			int max = deque.pollLast();

			while (!deque.isEmpty() && deque.peekLast() == max) {
				deque.pollLast();
			}

			while (!deque.isEmpty() && deque.peekFirst() <= left) {
				deque.pollFirst();
			}

			result++;
		}

		return result;
	}
}
