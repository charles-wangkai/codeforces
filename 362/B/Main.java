import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] d = new int[m];
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		System.out.println(solve(n, d) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int[] d) {
		Set<Integer> dirtyStairs = Arrays.stream(d).boxed().collect(Collectors.toSet());

		return !dirtyStairs.contains(1) && !dirtyStairs.contains(n) && dirtyStairs.stream().allMatch(
				dirtyStair -> !(dirtyStairs.contains(dirtyStair + 1) && dirtyStairs.contains(dirtyStair + 2)));
	}
}
