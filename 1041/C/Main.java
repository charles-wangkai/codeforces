import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();
	int m = sc.nextInt();
	int d = sc.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < a.length; i++) {
	    a[i] = sc.nextInt();
	}
	System.out.println(solve(a, m, d));

	sc.close();
    }

    static String solve(int[] a, int m, int d) {
	int n = a.length;

	NavigableMap<Integer, List<Integer>> minuteToIndices = new TreeMap<>();
	for (int i = 0; i < a.length; i++) {
	    if (!minuteToIndices.containsKey(a[i])) {
		minuteToIndices.put(a[i], new ArrayList<>());
	    }

	    minuteToIndices.get(a[i]).add(i);
	}

	int[] days = new int[n];
	int lowerMinute = Integer.MIN_VALUE;
	int day = 1;
	for (int i = 0; i < n; i++) {
	    Integer minute = minuteToIndices.ceilingKey(lowerMinute);
	    if (minute == null) {
		minute = minuteToIndices.firstKey();
		day++;
	    }

	    List<Integer> indices = minuteToIndices.get(minute);
	    int index = indices.remove(indices.size() - 1);
	    days[index] = day;
	    if (indices.isEmpty()) {
		minuteToIndices.remove(minute);
	    }

	    lowerMinute = minute + d + 1;
	}

	return String.format("%d\n%s", Arrays.stream(days).max().getAsInt(),
		Arrays.stream(days).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
