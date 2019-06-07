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
		System.out.println(solve(a).stream().map(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static List<Integer> solve(int[] a) {
		int count1 = (int) Arrays.stream(a).filter(x -> x == 1).count();
		int count2 = a.length - count1;

		List<Integer> result = new ArrayList<>();
		if (count2 != 0) {
			result.add(2);
			count2--;
		}
		if (count1 != 0) {
			result.add(1);
			count1--;
		}

		while (count1 != 0 || count2 != 0) {
			if (count2 != 0) {
				result.add(2);
				count2--;
			} else {
				result.add(1);
				count1--;
			}
		}

		return result;
	}
}
