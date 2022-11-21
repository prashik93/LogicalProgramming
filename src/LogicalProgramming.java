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
    static final int PERFECT_NUMBER = 2;
    static final int PRIME_NUMBER = 3;
    static final int REVERSE_A_NUMBER = 4;
    static final int COUPON_NUMBERS = 5;
    static final int DAYS_OF_WEEK = 8;
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Logical Programming!");
        LogicalProgramming lpObj = new LogicalProgramming();
        System.out.println("""
                1. Fibonacci Series
                2. Perfect Number
                3. Prime Number
                4. Reverse a Number
                5. Coupon Numbers
                8. Days of Week""");
        System.out.print("Enter which function you want to call : " );
        int userOption = scnr.nextInt();

        switch (userOption) {
            case FIBONACCI_SERIES -> lpObj.fibonacciSeries();
            case PERFECT_NUMBER -> lpObj.findPerfectNumber();
            case PRIME_NUMBER -> lpObj.findPrimeNumber();
            case REVERSE_A_NUMBER -> lpObj.reverseANumber();
            case COUPON_NUMBERS -> lpObj.findCouponNumbers();
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

    public void findPerfectNumber () {
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nEnter number to find it is a Perfect Number or Not :");
        int userInput = scnr.nextInt();
        int add = 0;

        for (int i = 1; i <= (userInput/2); i++) {
            if (userInput % i == 0) {
                System.out.print(i + " ");
                add = add + i;
            }
        }
        if (add == userInput) {
            System.out.println("\n" + userInput + " Is a Perfect Number : ");
        } else
            System.out.println("\n" + userInput + " Is not a Perfect Number : ");
    }

    public void findPrimeNumber () {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nEnter number to find Prime or not :");
        int userInput = scnr.nextInt();
        int count = 0;
        int i = 1;

        while (userInput >= i) {
            if (userInput % i ==0) {
                count+=1;
            }
            i+=1;
        }
        if (count == 2) {
            System.out.println("Prime Number");
        } else
            System.out.println("Not a prime number");
    }

    public void reverseANumber () {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nEnter a number which you want to reverse it : ");
        int userInput = scnr.nextInt();
        int temp = userInput;
        int rev = 0;

        while (userInput > 0) {
            int rem = (userInput % 10);
            rev = (rev * 10) + rem;
            userInput = userInput / 10;
        }
        System.out.println("Reverse of " + temp + " is => " + rev);
    }

    public void findCouponNumbers () {
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nEnter Distinct Coupon Number do you want to generate : ");
        int userInput = scnr.nextInt();
        ArrayList <Integer> couponNumbersArray = new ArrayList<>();
        int count = 0;
        int loopCount = 0;

        while (count < userInput) {
            int randomNumber = (int) (Math.floor(Math.random() * userInput));
            if (couponNumbersArray.contains(randomNumber)) {
                System.out.print("");
            } else {
                couponNumbersArray.add(randomNumber);
                count += 1;
            }
            loopCount+=1;
        }
        System.out.println("Total random number needed to hava all distinct numbers is : " + loopCount);
        System.out.println("Distinct Coupons is : " + couponNumbersArray);
        System.out.println("Size of distinct coupons is : " + couponNumbersArray.size());
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