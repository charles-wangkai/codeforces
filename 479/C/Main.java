import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Exam[] exams = new Exam[n];
		for (int i = 0; i < exams.length; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			exams[i] = new Exam(a, b);
		}
		System.out.println(solve(exams));

		sc.close();
	}

	static int solve(Exam[] exams) {
		Arrays.sort(exams, (exam1, exam2) -> (exam1.a != exam2.a) ? Integer.compare(exam1.a, exam2.a)
				: Integer.compare(exam1.b, exam2.b));

		int minDay = -1;
		for (Exam exam : exams) {
			minDay = (exam.b >= minDay) ? exam.b : exam.a;
		}
		return minDay;
	}
}

class Exam {
	int a;
	int b;

	Exam(int a, int b) {
		this.a = a;
		this.b = b;
	}
}