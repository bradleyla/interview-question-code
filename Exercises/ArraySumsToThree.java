package InterviewPrep2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySumsToThree {
    public static void main(String[] args) {
        double[] array = {1.01, 1.01, 3.0, 2.7, 1.99, 2.3, 1.7};
        System.out.println(sumsToThree(array));
    }

    public static List<List<Double>> sumsToThree(double[] array) {
        // collect all array elements into list so that we don't use elements twice later
        List<Double> arrayAsList = new ArrayList<>(Arrays.stream(array).boxed().toList());

        // returned list of lists of all sums of three groups
        List<List<Double>> doubleList = new ArrayList<>();

        double currValue;
        double maxValue;

        // use up each element in list so that elements are not used twice
        while(!arrayAsList.isEmpty()) {

            // contains the current sum of three group that we add to doubleList at the end of the loop
            List<Double> currentGroup = new ArrayList<>();

            // currValue = currently examined value from array
            // maxValue = the combined value of currValue and pointerValue that is closest to 3
            // pointerValue = the current array value that comes closest to 3 when added to currValue
            currValue = arrayAsList.get(0);
            maxValue = -1.0;
            double pointerValue = 0.0;

            // add first value immediately to the sum of three group
            currentGroup.add(currValue);

            // iterate through all remaining values in array that haven't yet been grouped and add each
            // to currValue; if the combined value is closer to 3 than the previous max combined value
            // but doesn't surpass 3, then it becomes the new max combined value and value added to
            // currValue becomes the new pointerValue
            for(int j = 1; j < arrayAsList.size(); j++) {
                double newValue = currValue + arrayAsList.get(j);
                if(newValue <= 3.0 && newValue > maxValue) {
                    maxValue = newValue;
                    pointerValue = arrayAsList.get(j);
                }
            }

            // if there is a pointerValue at the end of the second loop, it is added to the current sum of three group
            // and removed from the initial array
            if(pointerValue > 0.0) {
                currentGroup.add(pointerValue);
                arrayAsList.remove(pointerValue);
            }

            // finally, the current sum of three group is added to the full sum of three list and currValue is
            // removed from initial array
            doubleList.add(currentGroup);
            arrayAsList.remove(currValue);
        }
        return doubleList;
    }


}
