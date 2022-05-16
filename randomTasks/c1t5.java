package randomTasks;

public class c1t5 {
    public static void main(String[] args) {
        String s1 = "palec";
        String s2 = "pal";

        boolean res = false;
        if (s1.length() == s2.length()) {
            res = oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            res = oneAddReplace(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            res = oneAddReplace(s2, s1);
        }

        System.out.println(res);
    }

    public static boolean oneAddReplace(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
