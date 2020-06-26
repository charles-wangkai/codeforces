import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String s = sc.next();

            System.out.println(solve(s) ? "DA" : "NET");
        }

        sc.close();
    }

    static boolean solve(String s) {
        int count0 = (int) s.chars().filter(ch -> ch == '0').count();
        int count1 = s.length() - count0;

        return Math.min(count0, count1) % 2 != 0;
    }
}