import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] l = new int[6];
		for (int i = 0; i < l.length; i++) {
			l[i] = sc.nextInt();
		}
		System.out.println(solve(l));

		sc.close();
	}

	static String solve(int[] l) {
		Arrays.sort(l);

		if (canMakeBear(l)) {
			return "Bear";
		} else if (canMakeElephant(l)) {
			return "Elephant";
		} else {
			return "Alien";
		}
	}

	static boolean canMakeBear(int[] l) {
		return (l[0] == l[3] && l[4] != l[5]) || (l[1] == l[4] && l[0] != l[5]) || (l[2] == l[5] && l[0] != l[1]);
	}

	static boolean canMakeElephant(int[] l) {
		return (l[0] == l[3] && l[4] == l[5]) || (l[1] == l[4] && l[0] == l[5]) || (l[2] == l[5] && l[0] == l[1]);
	}
}
