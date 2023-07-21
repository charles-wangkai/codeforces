import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    Record[] records = new Record[n];
    for (int i = 0; i < records.length; i++) {
      char sign = sc.next().charAt(0);
      int amount = sc.nextInt();

      records[i] = new Record(sign, amount);
    }
    System.out.println(solve(records, x));

    sc.close();
  }

  static String solve(Record[] records, int x) {
    long balance = x;
    int distressNum = 0;
    for (Record r : records) {
      if (r.sign == '+' || balance >= r.amount) {
        if (r.sign == '+') {
          balance += r.amount;
        } else {
          balance -= r.amount;
        }
      } else {
        distressNum++;
      }
    }
    return String.format("%d %d", balance, distressNum);
  }
}

class Record {
  char sign;
  int amount;

  Record(char sign, int amount) {
    this.sign = sign;
    this.amount = amount;
  }
}
