package trash;

public class Coins {
    private static int[] coins;
    private static int[] dp;
    private static int[] path;
    private static int money;

    public static int solve(int x) {
        if (x >= 0 && x <= 4) return dp[x];
        for (int i = 5; i <= x; i++) {
            if (dp[i-1] <= dp[i-3] && dp[i-1] <= dp[i-4]) {
                dp[i] = dp[i-1] + 1;
                path[i] = 1;
            } else if (dp[i-3] <= dp[i-1] && dp[i-3] <= dp[i-4]) {
                dp[i] = dp[i-3] + 1;
                path[i] = 3;
            } else if (dp[i-4] <= dp[i-1] && dp[i-4] <= dp[i-1]) {
                dp[i] = dp[i-4] + 1;
                path[i] = 4;
            }
        }
        return dp[x];
    }

    public static void main(String[] args) {
        coins = new int[3];
        coins[0] = 1;
        coins[1] = 3;
        coins[2] = 4;

        money = 121;
        dp = new int[money+1];
        path = new int[money+1];
        dp[0] = 0; path[0] = 0;
        dp[1] = 1; path[1] = 1;
        dp[2] = 2; path[2] = 1;
        dp[3] = 1; path[3] = 3;
        dp[4] = 1; path[4] = 4;

        int result = solve(money);
        System.out.println("Number of coins: " + result);

        System.out.print("Coins: ");
        for (int i = money; i > 0; i = i - path[i]) {
            System.out.print(path[i] + " ");
        }
    }
}
