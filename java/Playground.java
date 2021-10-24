import java.util.stream.*;
import java.util.*;

public class Playground {

    public static void main(String[] args){

        int n = 10;
        int[] oneArray = IntStream.rangeClosed(0, n).map(x -> x+3).toArray();
        System.out.println(oneArray);//[I@30f39991
        System.out.println(Arrays.toString(oneArray));//[3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]

        int[] arrTwo = new int[] {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(oneArray.equals(arrTwo));//false
        System.out.println(oneArray == arrTwo);//false
        System.out.println(Arrays.equals(oneArray, arrTwo));//true
        int[] arr3 = oneArray.clone();
        System.out.println(oneArray.equals(arr3));//false
        System.out.println(oneArray == arr3);//false
        System.out.println(Arrays.equals(oneArray, arr3));//true


    }
}
