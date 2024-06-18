package InterviewPrep2;

public class ArrayMinJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = arr.length;
        int[] arr2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
        int n2 = arr.length;
        System.out.println(arrayMinJumps(arr, n));
        System.out.println(arrayMinJumps(arr2, n2));
    }

    public static int arrayMinJumps(int[] arr, int n) {
        int minJumps = 0;
        minJumps = jump(arr, arr[0], 0, n, minJumps);
        return minJumps;
    }

    // Dynamic programming solution - break problem down into individual jumps
    private static int jump(int[] arr, int steps, int pointer, int n, int minJumps) {

        // If index value is 0, we cannot jump and thus cannot reach end of array
        if(arr[pointer] == 0) {
            return -1;
        }
        // If current pointer + number of steps from previous iteration reaches the
        // end of the array or beyond, add one last jump and return it
        if(pointer + steps >= n) {
            minJumps++;
            return minJumps;
        }

        // Otherwise, we increment pointer by the index value of the current pointer index
        // from the array to traverse it
        pointer += steps;

        // Call next recursive iteration with the new steps, pointer, and minJumps value
        return jump(arr, arr[pointer], pointer, n, ++minJumps);
    }
}
