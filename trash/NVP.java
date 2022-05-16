package trash;

public class NVP {
    public static void main(String[] args) {
        int[] arr = {6,2,5,1,7,4,8,3};
        int[] length = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }

        System.out.println(length[arr.length - 1]);
    }
}
