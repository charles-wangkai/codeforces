import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int[] values = s.chars().map(c -> c - '0').toArray();

    @SuppressWarnings("unchecked")
    List<Integer>[] indexLists = new List[3];
    for (int i = 0; i < indexLists.length; ++i) {
      indexLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < values.length; ++i) {
      indexLists[values[i]].add(i);
    }

    int unit = values.length / 3;

    if (indexLists[0].size() < unit
        && indexLists[1].size() >= unit
        && indexLists[2].size() >= unit) {
      setValues(values, first(indexLists[1], indexLists[1].size() - unit), 0);
      setValues(values, first(indexLists[2], indexLists[2].size() - unit), 0);
    } else if (indexLists[0].size() >= unit
        && indexLists[1].size() < unit
        && indexLists[2].size() >= unit) {
      setValues(values, last(indexLists[0], indexLists[0].size() - unit), 1);
      setValues(values, first(indexLists[2], indexLists[2].size() - unit), 1);
    } else if (indexLists[0].size() >= unit
        && indexLists[1].size() >= unit
        && indexLists[2].size() < unit) {
      setValues(values, last(indexLists[0], indexLists[0].size() - unit), 2);
      setValues(values, last(indexLists[1], indexLists[1].size() - unit), 2);
    } else if (indexLists[0].size() > unit
        && indexLists[1].size() <= unit
        && indexLists[2].size() <= unit) {
      setValues(values, last(indexLists[0], unit - indexLists[2].size()), 2);
      setValues(
          values,
          last(
              excludeLast(indexLists[0], unit - indexLists[2].size()), unit - indexLists[1].size()),
          1);
    } else if (indexLists[0].size() <= unit
        && indexLists[1].size() > unit
        && indexLists[2].size() <= unit) {
      setValues(values, first(indexLists[1], unit - indexLists[0].size()), 0);
      setValues(values, last(indexLists[1], unit - indexLists[2].size()), 2);
    } else if (indexLists[0].size() <= unit
        && indexLists[1].size() <= unit
        && indexLists[2].size() > unit) {
      setValues(values, first(indexLists[2], unit - indexLists[0].size()), 0);
      setValues(
          values,
          first(
              excludeFirst(indexLists[2], unit - indexLists[0].size()),
              unit - indexLists[1].size()),
          1);
    }

    return Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining());
  }

  static List<Integer> first(List<Integer> indices, int k) {
    return indices.subList(0, k);
  }

  static List<Integer> excludeFirst(List<Integer> indices, int k) {
    return indices.subList(k, indices.size());
  }

  static List<Integer> last(List<Integer> indices, int k) {
    return indices.subList(indices.size() - k, indices.size());
  }

  static List<Integer> excludeLast(List<Integer> indices, int k) {
    return indices.subList(0, indices.size() - k);
  }

  static void setValues(int[] values, List<Integer> indices, int value) {
    for (int index : indices) {
      values[index] = value;
    }
  }
}