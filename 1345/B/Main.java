import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();

            System.out.println(solve(n));
        }

        sc.close();
    }

    static int solve(int n) {
        List<Integer> cards = new ArrayList<>();
        int sum = 0;
        for (int i = 1;; ++i) {
            sum += i;
            int card = sum * 3 - i;
            if (card > n) {
                break;
            }

            cards.add(card);
        }

        int result = 0;
        for (int i = cards.size() - 1; i >= 0; --i) {
            while (n >= cards.get(i)) {
                n -= cards.get(i);
                ++result;
            }
        }

        return result;
    }
}