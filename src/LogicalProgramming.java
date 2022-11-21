import java.util.Scanner;
public class LogicalProgramming {
    static final int SUNDAY = 0;
    static final int MONDAY = 1;
    static final int TUESDAY = 2;
    static final int WEDNESDAY = 3;
    static final int THURSDAY = 4;
    static final int FRIDAY = 5;
    static final int SATURDAY = 6;
    Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Logical Programming!");
        LogicalProgramming lpObj = new LogicalProgramming();
        lpObj.findDaysOfWeek();
    }

    public void findDaysOfWeek () {
        System.out.print("Enter Month : ");
        int m = scnr.nextInt();
        System.out.print("Enter Date : ");
        int d = scnr.nextInt();
        System.out.print("Enter Year : ");
        int y = scnr.nextInt();

        int Y = y - (14 -m) / 12;
        int X = Y + (Y / 4) - (Y / 100) + (Y / 400);
        int M = m + 12 * ((14 - m) / 12) - 2;
        int D = (d + X + ((31 * M) / 12)) % 7;

        switch (D) {
            case SUNDAY -> System.out.println("\nDay of the week is Sunday");
            case MONDAY -> System.out.println("\nDay of the week is Monday");
            case TUESDAY -> System.out.println("\nDay of the week is Tuesday");
            case WEDNESDAY -> System.out.println("\nDay of the week is Wednesday");
            case THURSDAY -> System.out.println("\nDay of the week is Thursday");
            case FRIDAY -> System.out.println("\nDay of the week is Friday");
            case SATURDAY -> System.out.println("\nDay of the week is Saturday");
        }

    }
}