import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static long solve(int[] a) {
        Map<Integer, List<Integer>> primeToExponents = new HashMap<>();
        for (int ai : a) {
            for (int divisor = 2; divisor * divisor <= ai; ++divisor) {
                int exponent = 0;
                while (ai % divisor == 0) {
                    ++exponent;
                    ai /= divisor;
                }

                if (exponent != 0) {
                    update(primeToExponents, divisor, exponent);
                }
            }

            if (ai != 1) {
                update(primeToExponents, ai, 1);
            }
        }

        long result = 1;
        for (int prime : primeToExponents.keySet()) {
            List<Integer> exponents = primeToExponents.get(prime);
            Collections.sort(exponents);

            int e;
            if (exponents.size() == a.length) {
                e = exponents.get(1);
            } else if (exponents.size() == a.length - 1) {
                e = exponents.get(0);
            } else {
                e = 0;
            }

            for (int i = 0; i < e; ++i) {
                result *= prime;
            }
        }

        return result;
    }

    static void update(Map<Integer, List<Integer>> primeToExponents, int prime, int exponent) {
        if (!primeToExponents.containsKey(prime)) {
            primeToExponents.put(prime, new ArrayList<>());
        }

        primeToExponents.get(prime).add(exponent);
    }
}