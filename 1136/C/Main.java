import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = readMatrix(sc, n, m);
		int[][] B = readMatrix(sc, n, m);
		System.out.println(solve(A, B) ? "YES" : "NO");

		sc.close();
	}

	static int[][] readMatrix(Scanner sc, int n, int m) {
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		return matrix;
	}

	static boolean solve(int[][] A, int[][] B) {
		return buildCoordSumToValues(A).equals(buildCoordSumToValues(B));
	}

	static Map<Integer, List<Integer>> buildCoordSumToValues(int[][] matrix) {
		Map<Integer, List<Integer>> result = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int coordSum = i + j;
				if (!result.containsKey(coordSum)) {
					result.put(coordSum, new ArrayList<>());
				}

				result.get(coordSum).add(matrix[i][j]);
			}
		}

		result.values().forEach(Collections::sort);

		return result;
	}
}
