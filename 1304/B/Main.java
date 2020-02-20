import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < strings.length; ++i) {
            strings[i] = sc.next();
        }
        System.out.println(solve(strings));

        sc.close();
    }

    static String solve(String[] strings) {
        StringBuilder left = new StringBuilder();
        String center = "";
        Set<String> rest = Arrays.stream(strings).collect(Collectors.toSet());
        while (!rest.isEmpty()) {
            String s = rest.iterator().next();
            rest.remove(s);

            String reversed = new StringBuilder(s).reverse().toString();
            if (rest.contains(reversed)) {
                left.append(s);
            } else if (reversed.equals(s)) {
                center = s;
            }
        }

        return String.format("%d\n%s%s%s", left.length() * 2 + center.length(), left, center,
                new StringBuilder(left).reverse().toString());
    }
}