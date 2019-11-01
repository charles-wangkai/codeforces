import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		Map<Integer, List<Integer>> valueToOperationNums = new HashMap<>();

		for (int ai : a) {
			int operationNum = 0;
			while (true) {
				if (!valueToOperationNums.containsKey(ai)) {
					valueToOperationNums.put(ai, new ArrayList<>());
				}
				valueToOperationNums.get(ai).add(operationNum);

				if (ai == 0) {
					break;
				}

				operationNum++;
				ai /= 2;
			}
		}

		return valueToOperationNums.values().stream().filter(operationNums -> operationNums.size() >= k)
				.mapToInt(operationNums -> operationNums.stream().sorted().limit(k).mapToInt(x -> x).sum()).min()
				.getAsInt();
	}
}
