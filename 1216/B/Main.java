import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		Element[] elements = IntStream.range(0, a.length).mapToObj(i -> new Element(i, a[i]))
				.sorted((e1, e2) -> Integer.compare(e2.value, e1.value)).toArray(Element[]::new);

		return String.format("%d\n%s", IntStream.range(0, elements.length).map(i -> i * elements[i].value + 1).sum(),
				Arrays.stream(elements).map(element -> String.valueOf(element.index + 1))
						.collect(Collectors.joining(" ")));
	}
}

class Element {
	int index;
	int value;

	Element(int index, int value) {
		this.index = index;
		this.value = value;
	}
}