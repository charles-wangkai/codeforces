import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] opinions = new int[n];
		for (int i = 0; i < opinions.length; i++) {
			opinions[i] = sc.nextInt();
		}
		System.out.println(solve(opinions));

		sc.close();
	}

	static String solve(int[] opinions) {
		return Arrays.stream(opinions).anyMatch(opinion -> opinion == 1) ? "HARD" : "EASY";
	}
}
