package MinimizingPermutations;
import java.util.*;
// Add any extra import statements you may need here

// my solution, a bit too much code and could have used shortcuts like:
//Arrays. (equals, toString, clone). Comments at the bottom from playgournd
class MinimizingPermutationsFB {

    // Add any helper functions you may need here
    class Perm {
        int[] arr;
        int level;
        Perm(int[] arr, int level) {
            this.arr = arr;
            this.level = level;
        }
    }
    int[] reverse(int[] arr, int from, int to) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        int mid = (from + to)/2;
        for(int i = from; i<=mid; i++){
            int temp = res[i];
            int withIdx = to+from-i;
            res[i] = res[withIdx];
            res[withIdx] = temp;
        }
        return res;
    }
    boolean isTarget(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
    String arrStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ", ");
        }
        return sb.toString();
    }

    int minOperations(int[] arr) {
        // Write your code here
        Queue<Perm> q = new ArrayDeque<>();
        int n = arr.length;
        int level = 0;
        q.add(new Perm(arr, level));
        int queueIters = 0;
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Perm perm = q.remove();
            level = perm.level;
            int[] currArr = perm.arr;
            if (isTarget(currArr)) {
                System.out.println("Completed with nr of iterations = "+queueIters);
                return level;
            }
            visited.add(arrStr(currArr));
            queueIters += 1;
            for (int i = 0; i < n - 1; i++) {//TODO: validate this
                for (int j = i; j < n; j++) {
                    int[] revArr = reverse(currArr, i, j);
                    String revArrStr = arrStr(revArr);
//                    System.out.println("i,j=[" + i + "," + j + "] level = " + level + " arr=" + arrStr(arr) + "rev=" + revArrStr);

                    if (!visited.contains(revArrStr)) {
                        q.add(new Perm(revArr, level + 1));
                        visited.add(revArrStr);
                    }
                }
            }
        }
        System.out.println("Return 0 with nr of iterations = "+queueIters);
        return 0;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);


        int[] arr_3 = {9,5,1,4,3,6,2,7,8};
        int output_3 = minOperations(arr_3);
        int expected_3 = 5;
        check(expected_3, output_3);
        // Add your own test cases here
    }

    public static void main(String[] args) {
        new MinimizingPermutationsFB().run();
    }
}

/*

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

* */