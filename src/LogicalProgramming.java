import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.Duration;

public class LogicalProgramming {
    static final int FIBONACCI_SERIES = 1;
    static final int PERFECT_NUMBER = 2;
    static final int PRIME_NUMBER = 3;
    static final int REVERSE_A_NUMBER = 4;
    static final int COUPON_NUMBERS = 5;
    static final int SIMULATE_STOPWATCH = 6;
    static final int FEWEST_NOTES = 7;
    static final int DAYS_OF_WEEK = 8;
    static final int TEMPERATURE_CONVERSION = 9;
    static final int MONTHLY_PAYMENT = 10;
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
                6. Simulate Stopwatch
                7. Fewest Notes
                8. Days of Week
                9. Temperature Conversion
                10. Monthly Payment""");
        System.out.print("Enter which function you want to call : " );
        int userOption = scnr.nextInt();

        switch (userOption) {
            case FIBONACCI_SERIES -> lpObj.fibonacciSeries();
            case PERFECT_NUMBER -> lpObj.findPerfectNumber();
            case PRIME_NUMBER -> lpObj.findPrimeNumber();
            case REVERSE_A_NUMBER -> lpObj.reverseANumber();
            case COUPON_NUMBERS -> lpObj.findCouponNumbers();
            case SIMULATE_STOPWATCH -> lpObj.simulateStopwatch();
            case FEWEST_NOTES -> lpObj.findFewestNotes();
            case DAYS_OF_WEEK -> lpObj.findDaysOfWeek();
            case TEMPERATURE_CONVERSION -> lpObj.temperatureConversion();
            case MONTHLY_PAYMENT -> lpObj.calculateMonthlyPayment();
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
            int randomNumber = (int) (Math.floor(Math.random() * (9999 - 100) + 1) + 10);
            if (!couponNumbersArray.contains(randomNumber)) {
                couponNumbersArray.add(randomNumber);
                count += 1;
            }
            loopCount+=1;
        }
        System.out.println("Total random number needed to hava all distinct numbers is : " + loopCount);
        System.out.println("Distinct Coupons is : " + couponNumbersArray);
        System.out.println("Size of distinct coupons is : " + couponNumbersArray.size());
    }

    public void simulateStopwatch () {
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nYou are in Simulate Stopwatch function\n");
        System.out.print("Enter 1 to Start : ");
        int userStart = scnr.nextInt();
         LocalTime startTime = null;
         LocalTime stopTime = null;
        if (userStart == 1) {
            startTime = java.time.LocalTime.now();
            System.out.println("Start Time : " + startTime);
        }
        System.out.print("Enter 2 to Stop : ");
        int userStop = scnr.nextInt();
        if (userStop == 2) {
            stopTime = java.time.LocalTime.now();
            System.out.println("Stop Time : " + stopTime);
        }
        assert startTime != null;
        Duration timesDiff = Duration.between(startTime, stopTime);
        int seconds = timesDiff.toSecondsPart();
        int millis = timesDiff.toMillisPart();
        int nanos = timesDiff.toNanosPart();
        System.out.println("Stopwatch time is : " + seconds + ":Second " + millis + ":Millisecond " + nanos + ":Nanosecond");
    }

    public void findFewestNotes () {
        System.out.println("\nYou are in Find Fewest Notes");
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter Amount to get change of it : ");
        int userInput = scnr.nextInt();
        int[] notesArray = {1, 2, 5, 10, 50, 100, 500, 1000};
        ArrayList<Integer> changeNotesArray = new ArrayList<>();

        for (int i = (notesArray.length - 1); i >= 0 ; i--) {
            int quotient;
            int count = 0;
            if (userInput >= notesArray[i]) {
                quotient = userInput / notesArray[i];
                userInput  = userInput % notesArray[i];
                while (count != quotient) {
                    changeNotesArray.add(notesArray[i]);
                    count++;
                }
            }
        }
        System.out.println("Minimum number of notes to be give : " + changeNotesArray.size());
        System.out.println("Rs Notes to be give : " + changeNotesArray);
    }

    public void findDaysOfWeek () {
        final int SUNDAY = 0;
        final int MONDAY = 1;
        final int TUESDAY = 2;
        final int WEDNESDAY = 3;
        final int THURSDAY = 4;
        final int FRIDAY = 5;
        final int SATURDAY = 6;
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

    public void temperatureConversion () {
        final int CELSIUS = 1;
        final int FAHRENHEIT = 2;
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nYou are in Temperature Conversion");
        System.out.println("""
                1. Fahrenheit to Celsius
                2. Celsius to Fahrenheit""");
        System.out.print("Enter your choice : ");
        int userInput = scnr.nextInt();

        switch (userInput) {
            case CELSIUS -> {
                System.out.print("Enter temperature in Fahrenheit (°F) : ");
                float tempInFahrenheit = scnr.nextInt();
                float cel = ((tempInFahrenheit - 32) * 5 / 9);
                System.out.println("Temperature in Celsius is : " + cel + "°C");
            }
            case FAHRENHEIT -> {
                System.out.print("Enter temperature in Celsius (°C) : ");
                int tempInCelsius = scnr.nextInt();
                int fah = ((tempInCelsius * 9 / 5) + 32);
                System.out.println("Temperature in Fahrenheit is : " + fah + "°F");
            }
        }
    }

    public void calculateMonthlyPayment () {
        System.out.print("\nYou are in Get Monthly Function");
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nEnter Principle Amount : ");
        int P = scnr.nextInt();
        System.out.print("How many years do you want to pay a loan amount : ");
        int Y = scnr.nextInt();
        System.out.print("Enter what percentage : ");
        double R = scnr.nextInt();
        double r = R / (12 * 100);
        double n = 12 * Y;

        double payment = Math.ceil((P * r) / (1 - Math.pow(1 + r, -n)));
        System.out.println("Monthly payment is : " + payment);
    }
}