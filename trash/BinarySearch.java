package trash;

public class BinarySearch {
    public static void main(String[] args) {
        String s = "00100001101";
        int left = 0;
        int right = s.length() - 1;
        int middle;
        while(right - left > 1) {
            middle = (right + left) / 2;
            if (s.charAt(middle) == '1') {
                right = middle;
            } else if (s.charAt(middle) == '0') {
                left = middle;
            }
        }

        System.out.println(s.charAt(left) + "" + s.charAt(right));
    }
}
