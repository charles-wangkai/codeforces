import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] genders = new char[n];
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			genders[i] = sc.next().charAt(0);
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(genders, a, b));

		sc.close();
	}

	static int solve(char[] genders, int[] a, int[] b) {
		return IntStream.rangeClosed(1, 366).map(day -> (int) Math.min(
				IntStream.range(0, genders.length).filter(i -> genders[i] == 'F' && day >= a[i] && day <= b[i]).count(),
				IntStream.range(0, genders.length).filter(i -> genders[i] == 'M' && day >= a[i] && day <= b[i]).count())
				* 2).max().getAsInt();
	}
}
