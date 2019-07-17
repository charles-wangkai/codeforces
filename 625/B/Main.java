import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String aiName = sc.next();
		String phoneName = sc.next();
		System.out.println(solve(aiName, phoneName));

		sc.close();
	}

	static int solve(String aiName, String phoneName) {
		int result = 0;
		int beginIndex = 0;
		while (true) {
			int index = aiName.indexOf(phoneName, beginIndex);
			if (index == -1) {
				break;
			}

			result++;
			beginIndex = index + phoneName.length();
		}
		return result;
	}
}
