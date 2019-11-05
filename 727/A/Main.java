import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int a = sc.nextInt();
	int b = sc.nextInt();
	System.out.println(solve(a, b));

	sc.close();
    }

    static String solve(int a, int b) {
	List<Long> sequence = new ArrayList<>();
	sequence.add((long) a);

	if (search(b, sequence)) {
	    return String.format("YES\n%d\n%s", sequence.size(),
		    sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	} else {
	    return "NO";
	}
    }

    static boolean search(int b, List<Long> sequence) {
	long last = sequence.get(sequence.size() - 1);
	if (last == b) {
	    return true;
	} else if (last > b) {
	    return false;
	}

	for (long next : new long[] { last * 2, last * 10 + 1 }) {
	    sequence.add(next);

	    if (search(b, sequence)) {
		return true;
	    }

	    sequence.remove(sequence.size() - 1);
	}

	return false;
    }
}
