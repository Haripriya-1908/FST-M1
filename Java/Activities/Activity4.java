package Activity;

import java.util.Arrays;

public class Activity4 {

    static void ascendingSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        
    
    int[] numArr = {3,6,2,7,4,1,8,9,5};
    
    System.out.println("Number Array before Sorting: " + Arrays.toString(numArr));

    ascendingSort(numArr);

    System.out.println("Number Array After Sorting: " + Arrays.toString(numArr));
    
   
}



}
