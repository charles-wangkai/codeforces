import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String x = sc.next();

            System.out.println(solve(x));
        }

        sc.close();
    }

    static String solve(String x) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        boolean same = true;
        for (char ch : x.toCharArray()) {
            if (ch == '0') {
                a.append('0');
                b.append('0');
            } else if (ch == '1') {
                if (same) {
                    a.append('1');
                    b.append('0');

                    same = false;
                } else {
                    a.append('0');
                    b.append('1');
                }
            } else if (same) {
                a.append('1');
                b.append('1');
            } else {
                a.append('0');
                b.append('2');
            }
        }

        return String.format("%s\n%s", a.toString(), b.toString());
    }
}