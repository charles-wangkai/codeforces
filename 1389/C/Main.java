import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        @SuppressWarnings("unchecked")
        List<Integer>[] indexLists = new List[10];
        for (int i = 0; i < indexLists.length; ++i) {
            indexLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); ++i) {
            indexLists[s.charAt(i) - '0'].add(i);
        }

        int maxLength = Arrays.stream(indexLists).mapToInt(List::size).max().getAsInt();

        for (int d1 = 0; d1 <= 9; ++d1) {
            for (int d2 = 0; d2 <= 9; ++d2) {
                if (d1 != d2) {
                    maxLength = Math.max(maxLength, computeLength(indexLists[d1], indexLists[d2]));
                }
            }
        }

        return s.length() - maxLength;
    }

    static int computeLength(List<Integer> indexList1, List<Integer> indexList2) {
        int result = 0;
        int index1 = 0;
        int index2 = 0;
        int lowerIndex = -1;
        while (true) {
            while (index1 != indexList1.size() && indexList1.get(index1) < lowerIndex) {
                ++index1;
            }
            if (index1 == indexList1.size()) {
                break;
            }
            lowerIndex = indexList1.get(index1);
            ++index1;

            while (index2 != indexList2.size() && indexList2.get(index2) < lowerIndex) {
                ++index2;
            }
            if (index2 == indexList2.size()) {
                break;
            }
            lowerIndex = indexList2.get(index2);
            ++index2;

            result += 2;
        }

        return result;
    }
}