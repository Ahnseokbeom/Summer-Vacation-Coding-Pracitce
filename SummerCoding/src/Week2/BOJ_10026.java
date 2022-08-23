package Week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
	static int count1 = 0;
	static int count2 = 0;
	static int n = 0;
	static char[][] map1;
	static char[][] map2;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
   public static void main(String[] args) throws IOException{
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   n = Integer.parseInt(br.readLine());
	   map1 = new char[n][n];
	   map2 = new char[n][n];
	   // 입력 받으면서 적록색약인 사람 구분하여 2개의 테이블에 넣기
	   for(int i = 0;i<n;i++) {
		   String s = br.readLine();
		   for(int j = 0;j<s.length();j++) {
			   map1[i][j] = s.charAt(j);
			   if(s.charAt(j)=='G') map2[i][j] = 'R';
			   else map2[i][j] = s.charAt(j);
		   }
	   }
	   for(int i = 0;i<n;i++) {
		   for(int j = 0;j<n;j++) {
			   if(map1[i][j]!='c') {
				   count1++;
				   dfs1(i,j,map1[i][j]);
			   }
		   }
	   }
	   for(int i = 0;i<n;i++) {
		   for(int j = 0;j<n;j++) {
			   if(map2[i][j]!='c') {
				   count2++;
				   dfs2(i,j,map2[i][j]);
			   }
		   }
	   }
	   System.out.println(count1+" "+count2);
   }
   public static void dfs1(int x, int y, char c) {
	   if(x<0 || x>=n || y<0 || y>=n || map1[x][y] == 'c') return;
	   if((c=='R' && map1[x][y]=='R') || (c=='G' && map1[x][y]=='G') || (c=='B' && map1[x][y]=='B')) {
		   // c로 변수를 바꿔줌으로 체크한 곳이라는 것을 표시
		   map1[x][y] = 'c';
		   for(int i = 0;i<4;i++) {
			   dfs1(x+dx[i],y+dy[i],c);
		   }
	   }
   }
   public static void dfs2(int x, int y, char c) {
	   if(x<0 || x>=n || y<0 || y>=n || map2[x][y] == 'c') return;
	   if((c=='R' && map2[x][y]=='R') || (c=='B' && map2[x][y]=='B')) {
		   map2[x][y] = 'c';
		   for(int i = 0;i<4;i++) {
			   dfs2(x+dx[i],y+dy[i],c);
		   }
	   }
   }
}
