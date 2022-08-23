package Week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2631 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		dp[0] = 1;

		int max = Integer.MIN_VALUE;
		for(int i = 1;i<n;i++) {
			dp[i] = 1;
			for(int j = 0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(n-max);
	}
}
