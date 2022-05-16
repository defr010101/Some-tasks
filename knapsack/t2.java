package knapsack;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int N = scanner.nextInt();

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }

        int[][] dp = new int[N+1][S+1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= S; j++) {
                if (j - weights[i-1] >= 0) {
                    dp[i][j] = (dp[i-1][j] == 1) ? dp[i-1][j] : dp[i-1][j-weights[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (int i = S; i >= 0; i--) {
            if (dp[N][i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
