package randomTasks;

public class c1t6 {
    public static String solution(String s1) {
        String s2 = "";
        char last = s1.charAt(0);
        int count = 1;
        char cur;
        for (int i = 1; i < s1.length(); i++) {
            cur = s1.charAt(i);

            if (i != s1.length() - 1) {
                if (cur == last) {
                    count++;
                } else {
                    s2 += last + "" + count;
                    last = cur;
                    count = 1;
                }
            } else {
                if (cur == last) {
                    count++;
                    s2 += last + "" + count;
                } else {
                    count = 1;
                    s2 += last + "" + count;
                }
            }
        }
        if (s2.length() >= s1.length()) {
            return s1;
        } else {
            return s2;
        }
    }

    public static void main(String[] args) {
        String s = "ааbсссссааа";
        System.out.println(solution(s));
    }
}
