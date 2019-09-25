import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		System.out.println(solve(x));

		sc.close();
	}

	static String solve(int x) {
		List<Integer> exponents = new ArrayList<>();
		while (true) {
			String binary = Integer.toBinaryString(x);

			int firstZeroIndex = binary.indexOf('0');
			if (firstZeroIndex == -1) {
				break;
			}

			int exponent = binary.length() - firstZeroIndex
					- ((Integer.parseInt(binary.substring(firstZeroIndex), 2) == 0) ? 1 : 0);
			exponents.add(exponent);

			x ^= (1 << exponent) - 1;
			x++;
		}

		return String.format("%d\n%s", exponents.size() * 2,
				exponents.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
