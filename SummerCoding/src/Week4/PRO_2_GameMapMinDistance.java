package Week4;

public class PRO_2_GameMapMinDistance {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean visited[][];
	static int min;
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int min = Integer.MAX_VALUE;
		visited = new boolean[maps.length][maps[0].length];
		dfs(0,0,maps,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}


	}
	public static void dfs(int x, int y, int[][] maps, int count) {
		count++;
		if(x==maps.length-1 && y==maps[0].length-1) {
			min = Math.min(min, count);
			return;
		}
		for(int i = 0;i<4;i++) {
			int x1 = x+dx[i];
			int y1 = y+dy[i];
			if(x1<0 || y1<0 || x1>=maps.length || y1>=maps[0].length) continue;
			if(!visited[x1][y1] && maps[x1][y1]==1) {
				visited[x1][y1] = true;
				dfs(x1,y1,maps,count);
				visited[x1][y1] = false;
			}
		}
	}

}
