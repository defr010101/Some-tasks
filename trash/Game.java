package trash;

public class Game {
    public static boolean checkPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static int maxConsecutiveElements1(String s) {
        int max = 1;
        char last = s.charAt(0);

        char cur;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            if (cur == last || i == s.length() - 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                last = cur;
            }
        }
        return max;
    }

    public static int maxConsecutiveElements2(String s) {
        int result = 0;
        int currentIndex = 0;
        while (currentIndex < s.length()) {
            int nextIndex = currentIndex;
            while (nextIndex < s.length() && s.charAt(nextIndex) == s.charAt(currentIndex)) {
                nextIndex++;
            }
            result = Math.max(result, nextIndex - currentIndex);
            currentIndex = nextIndex;
        }
        return result;
    }

    public static boolean checkExistSubarray(int[] arr, int x) {
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < arr.length) {
            if (sum < x) {
                sum += arr[r];
                r++;
            } else if (sum > x) {
                sum -= arr[l];
                l++;
            }
        }

        if (sum == x) {
            System.out.println("Borders: " + l + "-" + (r-1));
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 8, 2, 3};

        System.out.println(checkExistSubarray(arr, 14));
    }
}
