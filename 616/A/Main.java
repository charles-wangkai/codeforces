import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String b = st.nextToken();
		System.out.println(solve(a, b));
	}

	static char solve(String a, String b) {
		int length = Math.max(a.length(), b.length());

		for (int i = 0; i < length; i++) {
			int indexA = a.length() - length + i;
			int indexB = b.length() - length + i;

			char chA = (indexA >= 0) ? a.charAt(indexA) : '0';
			char chB = (indexB >= 0) ? b.charAt(indexB) : '0';

			if (chA < chB) {
				return '<';
			} else if (chA > chB) {
				return '>';
			}
		}

		return '=';
	}
}
