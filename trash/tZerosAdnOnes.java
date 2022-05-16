package trash;

public class tZerosAdnOnes {
    public static int rightBinarySearch(int[] arr, int number) {
        int l = 0;
        int r = arr.length;

        int count = 0;

        while (r - l > 1) {
            int m = (l + r) / 2;
            if (arr[m] > number) {
                r = m;
            } else {
                l = m;
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,1,1,1,1};
        System.out.println(rightBinarySearch(arr, 0));
    }
}
