import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a, k));

		sc.close();
	}

	static String solve(int[] a, int k) {
		Element[] elements = new Element[a.length];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = new Element(i, a[i]);
		}

		Element[] sortedElements = Arrays.stream(elements)
				.sorted((element1, element2) -> Integer.compare(element2.value, element1.value)).limit(k)
				.sorted((element1, element2) -> Integer.compare(element1.index, element2.index))
				.toArray(Element[]::new);

		int totalProfit = Arrays.stream(sortedElements).mapToInt(element -> element.value).sum();

		List<Integer> counts = new ArrayList<>();
		if (sortedElements.length == 1) {
			counts.add(a.length);
		} else {
			counts.add(sortedElements[1].index);
			for (int i = 1; i < sortedElements.length; i++) {
				counts.add(((i == sortedElements.length - 1) ? a.length : sortedElements[i + 1].index)
						- sortedElements[i].index);
			}
		}

		return String.format("%d\n%s", totalProfit,
				counts.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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