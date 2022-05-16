package trash;

public class Skobki {
    private static int counter = 0;

    public static void generate(String cur, int open, int closed, int n) {
        if (cur.length() == 2*n) {
            counter++;
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
        System.out.println(counter);
    }
}
