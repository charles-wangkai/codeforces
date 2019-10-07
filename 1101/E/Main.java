import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Query[] queries = new Query[n];
		for (int i = 0; i < queries.length; i++) {
			char type = sc.next().charAt(0);
			int arg1 = sc.nextInt();
			int arg2 = sc.nextInt();

			queries[i] = new Query(type, arg1, arg2);
		}
		System.out.println(solve(queries));

		sc.close();
	}

	static String solve(Query[] queries) {
		int lowerMax = -1;
		int upperMax = -1;
		List<String> result = new ArrayList<>();
		for (Query query : queries) {
			if (query.type == '+') {
				lowerMax = Math.max(lowerMax, Math.min(query.arg1, query.arg2));
				upperMax = Math.max(upperMax, Math.max(query.arg1, query.arg2));
			} else {
				int lowerLimit = Math.min(query.arg1, query.arg2);
				int upperLimit = Math.max(query.arg1, query.arg2);

				result.add((lowerMax <= lowerLimit && upperMax <= upperLimit) ? "YES" : "NO");
			}
		}

		return String.join("\n", result);
	}
}

class Query {
	char type;
	int arg1;
	int arg2;

	Query(char type, int arg1, int arg2) {
		this.type = type;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
}