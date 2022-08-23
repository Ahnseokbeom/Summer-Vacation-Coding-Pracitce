package Week7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3584 {
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n+1];
			StringTokenizer st;
			for(int j = 0;j<n-1;j++) {
				st = new StringTokenizer(br.readLine());
				int par = Integer.parseInt(st.nextToken());
				int chd = Integer.parseInt(st.nextToken());
				parent[chd] = par;
			}
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			find(a,b);
		}
	}
	public static void find(int a, int b) {
		ArrayList<Integer> answer = new ArrayList<>();
		int num = a;
		while(num != 0) {
			answer.add(num);
			num = parent[num];
		}
		num = b;
		while(num!=0) {
			if(answer.contains(num)) {
				System.out.println(num);
				return;
			}
			num = parent[num];
		}
	}

}
