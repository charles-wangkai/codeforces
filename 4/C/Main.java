import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] requests = new String[n];
		for (int i = 0; i < requests.length; i++) {
			requests[i] = sc.next();
		}
		System.out.print(solve(requests));

		sc.close();
	}

	static String solve(String[] requests) {
		StringBuilder result = new StringBuilder();
		Map<String, Integer> requestToCount = new HashMap<>();
		for (String request : requests) {
			if (requestToCount.containsKey(request)) {
				result.append(String.format("%s%d", request, requestToCount.get(request)));
			} else {
				result.append("OK");
			}

			requestToCount.put(request, requestToCount.getOrDefault(request, 0) + 1);
			result.append("\n");
		}
		return result.toString();
	}
}
