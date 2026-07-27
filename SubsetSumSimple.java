public class SubsetSumSimple {

    static boolean isFound = false;

    static void find(int arr[], int i, int currentSum, int target, String output) {

        // If required sum is achieved
        if (currentSum == target) {

            System.out.println(output);
            isFound = true;
            return;

        }

        // Stop condition
        if (i == arr.length || currentSum > target) {

            return;
        }

        // Take the element
        find(arr, i + 1, currentSum + arr[i], target, output + arr[i] + " ");

        // Skip the element
        find(arr, i + 1, currentSum, target, output);

    }

    public static void main(String[] args) {

        int arr[] = {3, 6, 4, 8, 5};
        int target = 11;

        find(arr, 0, 0, target, "");

        if (!isFound) {

            System.out.println("No valid subset found");

        }
    }
}
