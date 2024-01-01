package trash;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    private static List<String> parentheses = new ArrayList<>();

    public static void generate(String cur, int open, int closed, int n) {
        if (cur.length() == 2*n) {
            parentheses.add(cur);
            return;
        }
        if (open < n) {
            generate(cur + "(", open + 1, closed, n);
        }

        if (closed < n && open > closed) {
            generate(cur + ")", open, closed + 1, n);
        }
    }

    public static void main(String[] args) {
        generate("", 0, 0, 4);

        for (String parenthesis : parentheses) {
            System.out.println(parenthesis);
        }
    }
}
