import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			sc.nextInt();
			long k = sc.nextLong();
			String s = sc.next();

			System.out.println(solve(s, k));
		}

		sc.close();
	}

	static String solve(String s, long k) {
		List<Integer> zeroIndices = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zeroIndices.add(i);
			}
		}

		for (int i = 0; i < zeroIndices.size(); i++) {
			int moveNum = (int) Math.min(zeroIndices.get(i) - ((i == 0) ? 0 : (zeroIndices.get(i - 1) + 1)), k);

			zeroIndices.set(i, zeroIndices.get(i) - moveNum);
			k -= moveNum;
		}

		StringBuilder result = IntStream.range(0, s.length()).mapToObj(i -> '1').collect(StringBuilder::new,
				StringBuilder::append, StringBuilder::append);
		for (int zeroIndex : zeroIndices) {
			result.setCharAt(zeroIndex, '0');
		}

		return result.toString();
	}
}
