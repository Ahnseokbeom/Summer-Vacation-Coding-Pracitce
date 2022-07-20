public class PRO_2_ColoringBook {
	class Solution {
	    public int[] solution(int m, int n, int[][] picture) {
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        boolean[][] check = new boolean[m][n];
	        int[] answer = new int[2];
	        for(int i = 0;i<m;i++){
	            for(int j = 0;j<n;j++){
	                if(!check[i][j] && picture[i][j] != 0){
	                    int count = dfs(i,j,picture,check);
	                    if(maxSizeOfOneArea < count){
	                        maxSizeOfOneArea = count;
	                    }
	                    numberOfArea++;
	                }
	            }
	        }
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	}
	static int dfs(int x, int y, int[][] picture, boolean[][] check) {
		check[x][y] = true;
		int count = 1;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		for(int z = 0; z<4;z++) {
			int cX = x+dx[z];
			int cY = y+dy[z];
			if(cX >= 0 && cX < picture.length && cY >= 0 && cY < picture[0].length) {
				if(check[cX][cY]) continue;
				if(picture[cX][cY] == picture[x][y]) {
					count+= dfs(cX,cY,picture,check);
				}
			}
		}
		return count;
	}
}

