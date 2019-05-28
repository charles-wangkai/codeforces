import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		int t = sc.nextInt();
		int[] p = new int[n + 1];
		for (int i = 1; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(p, s, t));

		sc.close();
	}

	static int solve(int[] p, int s, int t) {
		boolean[] visited = new boolean[p.length];
		int index = s;
		int result = 0;
		while (index != t) {
			index = p[index];

			if (visited[index]) {
				return -1;
			}
			visited[index] = true;
			result++;
		}

		return result;
	}
}
