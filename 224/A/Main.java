import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] areas = new int[3];
		for (int i = 0; i < areas.length; i++) {
			areas[i] = sc.nextInt();
		}
		System.out.println(solve(areas));

		sc.close();
	}

	static int solve(int[] areas) {
		int product = (int) Math
				.round(Math.sqrt(Arrays.stream(areas).asLongStream().reduce(1, (result, area) -> result * area)));

		return Arrays.stream(areas).map(area -> product / area).sum() * 4;
	}
}
