import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] strings = new String[N];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = sc.next();
		}
		System.out.println(solve(strings));

		sc.close();
	}

	static String solve(String[] strings) {
		return Arrays.stream(strings).sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1)).collect(Collectors.joining());
	}
}
