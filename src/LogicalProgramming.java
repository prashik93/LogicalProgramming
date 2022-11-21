import java.util.Scanner;
import java.util.ArrayList;
public class LogicalProgramming {
    static final int SUNDAY = 0;
    static final int MONDAY = 1;
    static final int TUESDAY = 2;
    static final int WEDNESDAY = 3;
    static final int THURSDAY = 4;
    static final int FRIDAY = 5;
    static final int SATURDAY = 6;

    static final int FIBONACCI_SERIES = 1;
    static final int DAYS_OF_WEEK = 8;
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Logical Programming!");
        LogicalProgramming lpObj = new LogicalProgramming();
        System.out.println("""
                1. Fibonacci Series
                8. Days of Week""");
        System.out.print("Enter which function you want to call : " );
        int userOption = scnr.nextInt();

        switch (userOption) {
            case FIBONACCI_SERIES -> lpObj.fibonacciSeries();
            case DAYS_OF_WEEK -> lpObj.findDaysOfWeek();
        }

    }

    public void fibonacciSeries () {
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nEnter a number for Fibonacci series : ");
        int userInput = scnr.nextInt();
        int num1 = 0;
        int num2 = 1;
        int count = 2;
        System.out.print("Fibonacci series upto " + userInput + " is : " + num1 + " " + num2);

        while (count < userInput) {
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            System.out.print(" " + num3);
            count+=1;
        }
    }

    public void findDaysOfWeek () {
        Scanner scnr = new Scanner(System.in);
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