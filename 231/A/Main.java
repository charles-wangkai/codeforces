import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int PEOPLE_NUM = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] sures = new int[n][PEOPLE_NUM];
		for (int i = 0; i < sures.length; i++) {
			for (int j = 0; j < PEOPLE_NUM; j++) {
				sures[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(sures));

		sc.close();
	}

	static int solve(int[][] sures) {
		return (int) Arrays.stream(sures).filter(sureLine -> Arrays.stream(sureLine).sum() >= 2).count();
	}
}
