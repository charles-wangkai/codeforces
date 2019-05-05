import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		Arrays.sort(a);

		List<Integer> increasing = new ArrayList<>();
		List<Integer> decreasing = new ArrayList<>();
		for (int number : a) {
			if (increasing.isEmpty() || increasing.get(increasing.size() - 1) != number) {
				increasing.add(number);
			} else if (decreasing.isEmpty() || decreasing.get(decreasing.size() - 1) != number) {
				decreasing.add(number);
			} else {
				return "NO";
			}
		}
		Collections.reverse(decreasing);

		return String.format("YES\n%s\n%s", output(increasing), output(decreasing));
	}

	static String output(List<Integer> sequence) {
		return String.format("%d\n%s", sequence.size(),
				sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
