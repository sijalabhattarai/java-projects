import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        printCalender(month, year);

        scanner.close();
    }

    public static void printCalender(int month, int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.MONTH, month - 1);
        cal.set(java.util.Calendar.YEAR, year);
        cal.set(java.util.Calendar.DATE, 1); // first day of month

        System.out.println("\n" + cal.getDisplayName(java.util.Calendar.MONTH, java.util.Calendar.LONG, java.util.Locale.US) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);

        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);

            // start new line after Saturday
            if (cal.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY && day != daysInMonth) {
                System.out.println();
            }
            cal.add(java.util.Calendar.DATE, 1);
        }
        System.out.println();
    }
}
