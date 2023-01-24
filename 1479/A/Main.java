import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int leftIndex = 0;
    int rightIndex = n + 1;
    int middleIndex = (1 + n) / 2;
    int middleValue = query(sc, middleIndex);
    while (middleIndex != leftIndex + 1 || middleIndex != rightIndex - 1) {
      if (middleIndex - leftIndex > rightIndex - middleIndex) {
        int index = (leftIndex + middleIndex) / 2;
        int value = query(sc, index);
        if (value > middleValue) {
          leftIndex = index;
        } else {
          rightIndex = middleIndex;
          middleIndex = index;
          middleValue = value;
        }
      } else {
        int index = (middleIndex + rightIndex) / 2;
        int value = query(sc, index);
        if (value > middleValue) {
          rightIndex = index;
        } else {
          leftIndex = middleIndex;
          middleIndex = index;
          middleValue = value;
        }
      }
    }

    System.out.println(String.format("! %d", middleIndex));
    System.out.flush();

    sc.close();
  }

  static int query(Scanner sc, int index) {
    System.out.println(String.format("? %d", index));
    System.out.flush();

    return sc.nextInt();
  }
}
