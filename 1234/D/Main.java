import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		String[] queries = new String[q];
		for (int i = 0; i < queries.length; i++) {
			queries[i] = br.readLine();
		}
		System.out.println(solve(s, queries));
	}

	static String solve(String s, String[] queries) {
		@SuppressWarnings("unchecked")
		NavigableSet<Integer>[] posSets = new NavigableSet[26];
		for (int i = 0; i < posSets.length; i++) {
			posSets[i] = new TreeSet<>();
		}

		for (int i = 0; i < s.length(); i++) {
			posSets[s.charAt(i) - 'a'].add(i + 1);
		}

		char[] letters = new char[s.length() + 1];
		for (int i = 1; i < letters.length; i++) {
			letters[i] = s.charAt(i - 1);
		}

		List<Integer> result = new ArrayList<>();
		for (String query : queries) {
			String[] fields = query.split(" ");

			if (fields[0].equals("1")) {
				int pos = Integer.parseInt(fields[1]);
				char c = fields[2].charAt(0);

				posSets[letters[pos] - 'a'].remove(pos);
				posSets[c - 'a'].add(pos);

				letters[pos] = c;
			} else {
				int l = Integer.parseInt(fields[1]);
				int r = Integer.parseInt(fields[2]);

				result.add((int) Arrays.stream(posSets).filter(posSet -> {
					Integer candidatePos = posSet.ceiling(l);

					return candidatePos != null && candidatePos <= r;
				}).count());
			}
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
