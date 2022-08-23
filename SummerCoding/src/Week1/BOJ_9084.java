package Week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < n; i++) {
            	coin[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = coin[i]; j <= m; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}
