import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Query[] queries = { new Query(0, 1), new Query(1, 2), new Query(2, 3), new Query(3, 4) };
		for (Query query : queries) {
			System.out.println(String.format("? %d %d", query.index1 + 1, query.index2 + 1));
			System.out.flush();

			query.answer = sc.nextInt();
		}

		search(queries, new int[] { 4, 8, 15, 16, 23, 42 }, 0);

		sc.close();
	}

	static void search(Query[] queries, int[] a, int index) {
		if (index == a.length) {
			if (Arrays.stream(queries).allMatch(query -> a[query.index1] * a[query.index2] == query.answer)) {
				System.out.println(String.format("! %s",
						Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "))));
				System.out.flush();
			}

			return;
		}

		for (int i = index; i < a.length; i++) {
			swap(a, i, index);
			search(queries, a, index + 1);
			swap(a, i, index);
		}
	}

	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}

class Query {
	int index1;
	int index2;
	int answer;

	Query(int index1, int index2) {
		this.index1 = index1;
		this.index2 = index2;
	}
}