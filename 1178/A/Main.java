import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		List<Integer> indices = new ArrayList<>();
		indices.add(0);
		for (int i = 1; i < a.length; i++) {
			if (a[0] >= a[i] * 2) {
				indices.add(i);
			}
		}

		if (indices.stream().mapToInt(i -> a[i]).sum() * 2 > Arrays.stream(a).sum()) {
			return String.format("%d\n%s", indices.size(),
					indices.stream().map(index -> String.valueOf(index + 1)).collect(Collectors.joining(" ")));
		} else {
			return "0";
		}
	}
}
