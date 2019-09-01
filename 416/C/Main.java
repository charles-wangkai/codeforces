import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Request[] requests = new Request[n];
		for (int i = 0; i < requests.length; i++) {
			int c = sc.nextInt();
			int p = sc.nextInt();

			requests[i] = new Request(i, c, p);
		}
		int k = sc.nextInt();
		int[] r = new int[k];
		for (int i = 0; i < r.length; i++) {
			r[i] = sc.nextInt();
		}
		System.out.print(solve(requests, r));

		sc.close();
	}

	static String solve(Request[] requests, int[] r) {
		NavigableMap<Integer, List<Integer>> sizeToTableIndices = new TreeMap<>();
		for (int i = 0; i < r.length; i++) {
			addToMap(sizeToTableIndices, r[i], i);
		}

		Arrays.sort(requests, (r1, r2) -> Integer.compare(r2.p, r1.p));

		int totalMoney = 0;
		List<String> mapping = new ArrayList<>();
		for (Request request : requests) {
			Integer size = sizeToTableIndices.ceilingKey(request.c);

			if (size != null) {
				totalMoney += request.p;

				int tableIndex = removeFromMap(sizeToTableIndices, size);
				mapping.add(String.format("%d %d", request.index + 1, tableIndex + 1));
			}
		}

		return String.format("%d %d\n%s", mapping.size(), totalMoney, String.join("\n", mapping));
	}

	static void addToMap(NavigableMap<Integer, List<Integer>> sizeToTableIndices, int size, int tableIndex) {
		if (!sizeToTableIndices.containsKey(size)) {
			sizeToTableIndices.put(size, new ArrayList<>());
		}

		sizeToTableIndices.get(size).add(tableIndex);
	}

	static int removeFromMap(NavigableMap<Integer, List<Integer>> sizeToTableIndices, int size) {
		List<Integer> tableIndices = sizeToTableIndices.get(size);
		int result = tableIndices.remove(tableIndices.size() - 1);

		if (tableIndices.isEmpty()) {
			sizeToTableIndices.remove(size);
		}

		return result;
	}
}

class Request {
	int index;
	int c;
	int p;

	Request(int index, int c, int p) {
		this.index = index;
		this.c = c;
		this.p = p;
	}
}