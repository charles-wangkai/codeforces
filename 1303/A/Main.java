import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(String s) {
        int leftIndex = s.indexOf('1');
        if (leftIndex == -1) {
            return 0;
        }

        return (int) s.substring(leftIndex, s.lastIndexOf('1') + 1).chars().filter(ch -> ch == '0').count();
    }
}