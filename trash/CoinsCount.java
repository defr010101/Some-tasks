package trash;

public class CoinsCount {
    public static void main(String[] args) {
        int money = 5;
        int[] dp = new int[money + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = dp[2] + dp[0];
        dp[4] = dp[3] + dp[1] + dp[0];

        for (int i = 5; i <= money; i++) {
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        System.out.println(dp[money]);
    }
}
