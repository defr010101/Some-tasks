package randomTasks;

public class Main {
    public static void main(String[] args) {
        int N = 4;
        int M = 4;
        int[][] field = {
                {9, 8, 6, 2},
                {10, 11, 13, 11},
                {3, 7, 12, 8},
                {5, 9, 13, 9}
        };
        int[][] dp = new int[N][M];
        int[][] opt = new int[N][M]; // 0 - начало; 1 - сверху; 2 - слева

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = field[i][j];
                    opt[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + field[i][j];
                    opt[i][j] = 2;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + field[i][j];
                    opt[i][j] = 1;
                } else {
                    if (dp[i-1][j] >= dp[i][j-1]) {
                        dp[i][j] = dp[i-1][j] + field[i][j];
                        opt[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j-1] + field[i][j];
                        opt[i][j] = 2;
                    }
                }
            }
        }

        int i = N-1;
        int j = M-1;

        while (true) {
            System.out.print(field[i][j] + " ");
            if (opt[i][j] == 1) {
                i = i - 1;
            } else if (opt[i][j] == 2) {
                j = j - 1;
            } else if (opt[i][j] == 0) {
                break;
            }
        }
    }

}
