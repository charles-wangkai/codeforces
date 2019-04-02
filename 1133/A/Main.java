import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Time startTime = new Time(sc.next());
		Time endTime = new Time(sc.next());
		System.out.println(solve(startTime, endTime));

		sc.close();
	}

	static Time solve(Time startTime, Time endTime) {
		return new Time((startTime.getTotalMinute() + endTime.getTotalMinute()) / 2);
	}
}

class Time {
	int hour;
	int minute;

	Time(String s) {
		hour = Integer.parseInt(s.substring(0, 2));
		minute = Integer.parseInt(s.substring(3));
	}

	Time(int totalMinute) {
		hour = totalMinute / 60;
		minute = totalMinute % 60;
	}

	int getTotalMinute() {
		return hour * 60 + minute;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d", hour, minute);
	}
}