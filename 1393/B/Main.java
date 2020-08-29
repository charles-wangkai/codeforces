import java.util.Scanner;

public class Main {
    static final int LIMIT = 100000;

    static boolean[] singles = new boolean[LIMIT + 1];
    static int[] pairCounts = new int[LIMIT + 1];
    static int pairTotal = 0;
    static int squareTotal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        Event[] events = new Event[q];
        for (int i = 0; i < events.length; ++i) {
            char type = sc.next().charAt(0);
            int x = sc.nextInt();

            events[i] = new Event(type, x);
        }

        System.out.println(solve(a, events));

        sc.close();
    }

    static String solve(int[] a, Event[] events) {
        for (int ai : a) {
            increase(ai);
        }

        String[] result = new String[events.length];
        for (int i = 0; i < result.length; ++i) {
            if (events[i].type == '+') {
                increase(events[i].x);
            } else {
                decrease(events[i].x);
            }

            result[i] = check() ? "YES" : "NO";
        }

        return String.join("\n", result);
    }

    static void increase(int x) {
        if (singles[x]) {
            singles[x] = false;
            ++pairCounts[x];
            ++pairTotal;
            if (pairCounts[x] == 2) {
                ++squareTotal;
            }
        } else {
            singles[x] = true;
        }
    }

    static void decrease(int x) {
        if (singles[x]) {
            singles[x] = false;
        } else {
            singles[x] = true;
            --pairCounts[x];
            --pairTotal;
            if (pairCounts[x] == 1) {
                --squareTotal;
            }
        }
    }

    static boolean check() {
        return squareTotal != 0 && pairTotal >= 4;
    }
}

class Event {
    char type;
    int x;

    Event(char type, int x) {
        this.type = type;
        this.x = x;
    }
}