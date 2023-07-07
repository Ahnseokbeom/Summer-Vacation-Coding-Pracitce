package Week4;

public class PRO_2_GameMapMinDistance {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean check[][];
	static int answer;
	public static void main(String[] args) {
		int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps1));
		int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(maps2));
	}
	public static int solution(int[][] maps){
        answer = Integer.MAX_VALUE;
        check = new boolean[maps.length][maps[0].length];
        dfs(0,0,0,maps);

        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
	public static void dfs(int x, int y,int count,int[][] maps) {
		count++;
		if(x==maps.length-1 && y==maps[0].length-1) {
			answer = Math.min(answer, count);
			return;
		}
		for(int i = 0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length) continue;
			if(!check[nx][ny] && maps[nx][ny]==1) {
				check[nx][ny] = true;
				dfs(nx,ny,count,maps);
				check[nx][ny] = false;
			}
		}
	}
}
