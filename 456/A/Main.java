import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Laptop[] laptops = new Laptop[n];
		for (int i = 0; i < laptops.length; i++) {
			int price = sc.nextInt();
			int quality = sc.nextInt();

			laptops[i] = new Laptop(price, quality);
		}
		System.out.println(solve(laptops));

		sc.close();
	}

	static String solve(Laptop[] laptops) {
		Arrays.sort(laptops, (laptop1, laptop2) -> Integer.compare(laptop1.price, laptop2.price));

		return IntStream.range(0, laptops.length - 1).anyMatch(i -> laptops[i].quality > laptops[i + 1].quality)
				? "Happy Alex"
				: "Poor Alex";
	}
}

class Laptop {
	int price;
	int quality;

	Laptop(int price, int quality) {
		this.price = price;
		this.quality = quality;
	}
}