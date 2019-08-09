import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		Set<Type> missingTypes = findMissingTypes(s);
		if (missingTypes.isEmpty()) {
			return s;
		}

		for (int i = 0; i < s.length(); i++) {
			missingTypes = findMissingTypes(String.format("%s%s", s.substring(0, i), s.substring(i + 1)));
			if (missingTypes.size() == 1) {
				return String.format("%s%c%s", s.substring(0, i), buildChar(missingTypes.iterator().next()),
						s.substring(i + 1));
			}
		}

		missingTypes = findMissingTypes(s.substring(2, 3));
		return String.format("%s%s", missingTypes.stream().map(missingType -> String.valueOf(buildChar(missingType)))
				.collect(Collectors.joining()), s.substring(2));
	}

	static char buildChar(Type type) {
		if (type == Type.DIGIT) {
			return '0';
		} else if (type == Type.UPPERCASE) {
			return 'A';
		} else {
			return 'a';
		}
	}

	static Set<Type> findMissingTypes(String str) {
		Set<Type> result = Arrays.stream(Type.values()).collect(Collectors.toSet());
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				result.remove(Type.DIGIT);
			} else if (Character.isUpperCase(ch)) {
				result.remove(Type.UPPERCASE);
			} else {
				result.remove(Type.LOWERCASE);
			}
		}

		return result;
	}
}

enum Type {
	DIGIT, UPPERCASE, LOWERCASE;
}