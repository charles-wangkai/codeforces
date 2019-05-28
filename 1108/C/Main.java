import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static int minRecolorNum;
	static String garlandWithMinRecolorNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.print(solve(s));

		sc.close();
	}

	static String solve(String s) {
		minRecolorNum = Integer.MAX_VALUE;
		garlandWithMinRecolorNum = null;

		search(s, new char[] { 'R', 'G', 'B' }, 0);

		return String.format("%d\n%s", minRecolorNum, garlandWithMinRecolorNum);
	}

	static void search(String s, char[] colors, int index) {
		if (index == colors.length) {
			String garland = buildGarland(colors, s.length());
			int recolorNum = (int) IntStream.range(0, s.length()).filter(i -> s.charAt(i) != garland.charAt(i)).count();

			if (recolorNum < minRecolorNum) {
				minRecolorNum = recolorNum;
				garlandWithMinRecolorNum = garland;
			}

			return;
		}

		for (int i = index; i < colors.length; i++) {
			swap(colors, i, index);
			search(s, colors, index + 1);
			swap(colors, i, index);
		}
	}

	static void swap(char[] a, int index1, int index2) {
		char temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	static String buildGarland(char[] colors, int length) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			result.append(colors[i % colors.length]);
		}
		return result.toString();
	}
}
