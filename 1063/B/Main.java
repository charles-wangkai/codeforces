import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int startR = sc.nextInt();
    int startC = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    char[][] cells = new char[n][m];
    for (int r = 0; r < n; ++r) {
      String line = sc.next();
      for (int c = 0; c < m; ++c) {
        cells[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(cells, startR, startC, x, y));

    sc.close();
  }

  static int solve(char[][] cells, int startR, int startC, int x, int y) {
    int n = cells.length;
    int m = cells[0].length;

    int[][] rightRests = new int[n][m];
    for (int r = 0; r < n; ++r) {
      Arrays.fill(rightRests[r], -1);
    }

    Deque<Element> deque = new ArrayDeque<>();
    deque.offerLast(new Element(startR - 1, startC - 1, x, y));

    while (!deque.isEmpty()) {
      Element head = deque.pollFirst();
      if (head.rightRest() > rightRests[head.r()][head.c()]) {
        rightRests[head.r()][head.c()] = head.rightRest();

        moveLeft(cells, head, deque);
        moveRight(cells, head, deque);
        moveUp(cells, head, deque);
        moveDown(cells, head, deque);
      }
    }

    int result = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (rightRests[r][c] != -1) {
          ++result;
        }
      }
    }

    return result;
  }

  static void moveLeft(char[][] cells, Element head, Deque<Element> deque) {
    int r = head.r();
    int c = head.c() - 1;
    int leftRest = head.leftRest() - 1;
    int rightRest = head.rightRest();
    if (c >= 0 && cells[r][c] == '.' && leftRest >= 0) {
      deque.offerLast(new Element(r, c, leftRest, rightRest));
    }
  }

  static void moveRight(char[][] cells, Element head, Deque<Element> deque) {
    int r = head.r();
    int c = head.c() + 1;
    int leftRest = head.leftRest();
    int rightRest = head.rightRest() - 1;
    if (c < cells[r].length && cells[r][c] == '.' && rightRest >= 0) {
      deque.offerFirst(new Element(r, c, leftRest, rightRest));
    }
  }

  static void moveUp(char[][] cells, Element head, Deque<Element> deque) {
    int r = head.r() - 1;
    int c = head.c();
    int leftRest = head.leftRest();
    int rightRest = head.rightRest();
    if (r >= 0 && cells[r][c] == '.') {
      deque.offerFirst(new Element(r, c, leftRest, rightRest));
    }
  }

  static void moveDown(char[][] cells, Element head, Deque<Element> deque) {
    int r = head.r() + 1;
    int c = head.c();
    int leftRest = head.leftRest();
    int rightRest = head.rightRest();
    if (r < cells.length && cells[r][c] == '.') {
      deque.offerFirst(new Element(r, c, leftRest, rightRest));
    }
  }
}

record Element(int r, int c, int leftRest, int rightRest) {}
