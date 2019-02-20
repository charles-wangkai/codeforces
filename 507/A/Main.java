import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		int[] sequences = solve(a, k);
		System.out.println(sequences.length);
		System.out.println(String.join(" ", Arrays.stream(sequences).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] a, int k) {
		Instrument[] instruments = IntStream.range(0, a.length).mapToObj(i -> new Instrument(i + 1, a[i]))
				.sorted((instrument1, instrument2) -> Integer.compare(instrument1.day, instrument2.day))
				.toArray(Instrument[]::new);

		int daySum = 0;
		int length = 0;
		while (length < instruments.length && daySum + instruments[length].day <= k) {
			daySum += instruments[length].day;
			length++;
		}

		return IntStream.range(0, length).map(i -> instruments[i].sequence).toArray();
	}
}

class Instrument {
	int sequence;
	int day;

	Instrument(int sequence, int day) {
		this.sequence = sequence;
		this.day = day;
	}
}