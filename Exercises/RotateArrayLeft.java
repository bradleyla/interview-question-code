package InterviewPrep2;

import java.util.Arrays;

public class RotateArrayLeft {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int steps = 2;
        System.out.println(Arrays.toString(rotateArrayLeft(array, steps)));
    }

    public static int[] rotateArrayLeft(int[] array, int steps) {
        int[] temp = new int[array.length];
        int pointer = array.length - steps;
        for(int i = 0; i < steps; i++) {
            temp[pointer] = array[i];
            pointer++;
        }
        pointer = 0;
        for(int i = steps; i < array.length; i++) {
            temp[pointer] = array[i];
            pointer++;
        }
        return temp;
    }
}
