import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n = sc.next();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(String n) {
		int[] evenIndices = IntStream.range(0, n.length()).filter(i -> (n.charAt(i) - '0') % 2 == 0).toArray();

		if (evenIndices.length == 0) {
			return "-1";
		}

		for (int evenIndex : evenIndices) {
			if (n.charAt(evenIndex) < n.charAt(n.length() - 1)) {
				return swap(n, evenIndex, n.length() - 1);
			}
		}

		return swap(n, evenIndices[evenIndices.length - 1], n.length() - 1);
	}

	static String swap(String n, int index1, int index2) {
		char[] chs = n.toCharArray();
		char temp = chs[index1];
		chs[index1] = chs[index2];
		chs[index2] = temp;
		return new String(chs);
	}
}
