import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		String[] oldHandles = new String[q];
		String[] newHandles = new String[q];
		for (int i = 0; i < q; i++) {
			oldHandles[i] = sc.next();
			newHandles[i] = sc.next();
		}
		System.out.print(solve(oldHandles, newHandles));

		sc.close();
	}

	static String solve(String[] oldHandles, String[] newHandles) {
		Map<String, String> newHandleToOriginalHandle = new HashMap<>();
		for (int i = 0; i < oldHandles.length; i++) {
			String originalHandle = newHandleToOriginalHandle.getOrDefault(oldHandles[i], oldHandles[i]);

			newHandleToOriginalHandle.remove(oldHandles[i]);
			newHandleToOriginalHandle.put(newHandles[i], originalHandle);
		}

		return String.format("%d\n%s", newHandleToOriginalHandle.size(),
				newHandleToOriginalHandle.entrySet().stream()
						.map(entry -> String.format("%s %s", entry.getValue(), entry.getKey()))
						.collect(Collectors.joining("\n")));
	}
}
