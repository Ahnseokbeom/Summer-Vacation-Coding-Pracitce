import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3584_1 {
	static int[] 부모와자식관계;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			부모와자식관계 = new int[n+1];
			StringTokenizer st;
			for(int j = 0;j<n-1;j++) {
				st = new StringTokenizer(br.readLine());
				int 부모 = Integer.parseInt(st.nextToken());
				int 자식 = Integer.parseInt(st.nextToken());
				부모와자식관계[자식] = 부모;
			}
			st = new StringTokenizer(br.readLine());
			int 첫번째자식  = Integer.parseInt(st.nextToken());
			int 두번째자식 = Integer.parseInt(st.nextToken());
			공통조상찾기(첫번째자식, 두번째자식);
		}
	}
	public static void 공통조상찾기(int 첫번째자식, int 두번째자식) {
		ArrayList<Integer> answer = new ArrayList<>();
		int 조상 = 첫번째자식;
		while(조상 != 0) {
			answer.add(조상);
			조상 = 부모와자식관계[조상];
		}
		조상 = 두번째자식;
		while(조상!=0) {
			if(answer.contains(조상)) {
				System.out.println(조상);
				return;
			}
			조상 = 부모와자식관계[조상];
		}
	}
}
