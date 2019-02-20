import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Student[] students = new Student[n];
		for (int i = 0; i < students.length; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

			students[i] = new Student(i + 1, a, b, c, d);
		}
		System.out.println(solve(students));

		sc.close();
	}

	static int solve(Student[] students) {
		Arrays.sort(students,
				(student1, student2) -> (student1.getSum() != student2.getSum())
						? Integer.compare(student2.getSum(), student1.getSum())
						: Integer.compare(student1.id, student2.id));

		for (int i = 0;; i++) {
			if (students[i].id == 1) {
				return i + 1;
			}
		}
	}
}

class Student {
	int id;
	int a;
	int b;
	int c;
	int d;

	Student(int id, int a, int b, int c, int d) {
		this.id = id;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	int getSum() {
		return a + b + c + d;
	}
}