package InterviewPrep2;

import java.util.Scanner;

public class PrimeNumbersDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum;
        System.out.println("Enter the starting number: ");
        startNum = scanner.nextInt();
        findPrimes(startNum);
    }

    public static void findPrimes(int startNum) {
        int primeCounter = 0;
        boolean isPrime = true;
        while(primeCounter < 100) {
            // only need to iterate up to square root of startNum; everything above that will
            // not return evenly
            for(int j = 2; j <= Math.sqrt(startNum); j++) {
                // if any number and startNum are evenly divisible, then startNum is not prime;
                // move on to the next number
                if((startNum % j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            // if end of inner loop is reached and startNum is not evenly divisible, it's prime
            // and should be printed
            if(isPrime) {
                System.out.println(startNum);
                primeCounter++;
            }
            // move to the next number in sequence
            isPrime = true;
            startNum++;
        }
    }

}
