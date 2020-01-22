import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[n];
		for (int i = 0; i < f.length; ++i) {
			f[i] = sc.nextInt();
		}
		System.out.println(solve(f));

		sc.close();
	}

	static String solve(int[] f) {
		Set<Integer> values = IntStream.rangeClosed(1, f.length).boxed().collect(Collectors.toSet());
		Set<Integer> positions = new HashSet<>();
		for (int i = 0; i < f.length; ++i) {
			if (f[i] == 0) {
				positions.add(i + 1);
			} else {
				values.remove(f[i]);
			}
		}

		List<Integer> selves = positions.stream().filter(values::contains).collect(Collectors.toList());
		for (int self : selves) {
			values.remove(self);
			positions.remove(self);
		}

		if (selves.size() == 1) {
			int self = selves.get(0);
			int position = positions.iterator().next();
			positions.remove(position);
			int value = values.iterator().next();
			values.remove(value);

			f[self - 1] = value;
			f[position - 1] = self;
		} else {
			for (int i = 0; i < selves.size(); ++i) {
				f[selves.get(i) - 1] = selves.get((i + 1) % selves.size());
			}
		}

		Iterator<Integer> valuesIter = values.iterator();
		Iterator<Integer> positionsIter = positions.iterator();
		while (valuesIter.hasNext()) {
			f[positionsIter.next() - 1] = valuesIter.next();
		}

		return Arrays.stream(f).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
