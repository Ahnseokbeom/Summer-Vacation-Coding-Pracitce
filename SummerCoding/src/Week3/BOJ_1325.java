package Week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
	static int n,m;
	static boolean visited[];
	static int[] arr;
	static ArrayList<Integer> array[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		array = new ArrayList[n+1];
		arr = new int[n+1];
		for(int i = 1;i<=n;i++) array[i] = new ArrayList<>();
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			array[u].add(v);
		}
		for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];
            bfs(i);
        }
		int max = Integer.MIN_VALUE;
		for(int i : arr) max = Math.max(max, arr[i]);
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=n;i++) {
			if(arr[i]==max) sb.append(i+" ");
		}
		System.out.println(sb);
	}
    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(idx);
        visited[idx] = true;
        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i=0; i<array[num].size(); i++) {
                int v = array[num].get(i);
                if(!visited[v]){
                    visited[v] = true;
                    arr[v]+=1;
                    q.add(v);
                }
            }
        }
    }

}
