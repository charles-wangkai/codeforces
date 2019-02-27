import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	static final Map<String, String> COLOR_TO_NAME = new HashMap<>();
	static {
		COLOR_TO_NAME.put("purple", "Power");
		COLOR_TO_NAME.put("green", "Time");
		COLOR_TO_NAME.put("blue", "Space");
		COLOR_TO_NAME.put("orange", "Soul");
		COLOR_TO_NAME.put("red", "Reality");
		COLOR_TO_NAME.put("yellow", "Mind");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] colors = new String[n];
		for (int i = 0; i < colors.length; i++) {
			colors[i] = sc.next();
		}

		List<String> result = solve(colors);
		System.out.println(result.size());
		result.stream().forEach(System.out::println);

		sc.close();
	}

	static List<String> solve(String[] colors) {
		Set<String> colorSet = Arrays.stream(colors).collect(Collectors.toSet());

		return COLOR_TO_NAME.keySet().stream().filter(color -> !colorSet.contains(color)).map(COLOR_TO_NAME::get)
				.collect(Collectors.toList());
	}
}
