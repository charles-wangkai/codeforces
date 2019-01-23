import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[] l = new int[m];
		for (int i = 0; i < l.length; i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = Integer.parseInt(st.nextToken());
		}

		int[] solution = solve(a, l);
		StringBuilder output = new StringBuilder();
		for (int elem : solution) {
			output.append(elem).append("\n");
		}
		System.out.print(output);
	}

	static int[] solve(int[] a, int[] l) {
		int[] distinctNums = new int[a.length];
		Set<Integer> numbers = new HashSet<>();
		for (int i = distinctNums.length - 1; i >= 0; i--) {
			numbers.add(a[i]);
			distinctNums[i] = numbers.size();
		}

		return Arrays.stream(l).map(li -> distinctNums[li - 1]).toArray();
	}
}
