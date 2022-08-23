package Week4;
import java.util.Arrays;

public class PRO_2_ProcessionRotate {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        int n = 1;
        for(int i = 1 ; i <= rows; i++) {
            for(int j = 1;  j <= columns; j++) {
                arr[i][j] = n++;
            }
        }

		for(int i = 0 ; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            System.out.println(x1+" "+y1+" "+x2+" "+y2);

            int temp = arr[x1][y1];

            int min = temp;

            // 좌측
            for(int j = x1; j < x2; j++) {
                arr[j][y1] = arr[j+1][y1];
                min = Math.min(min, arr[j][y1]);
            }

            // 하단
            for(int j = y1; j < y2; j++) {
                arr[x2][j] = arr[x2][j+1];
                min = Math.min(min, arr[x2][j]);
            }

            // 우측
            for(int j = x2; j > x1; j--) {
                arr[j][y2] = arr[j-1][y2];
                min = Math.min(min, arr[j][y2]);
            }

            // 상단
            for(int j = y2; j > y1; j--) {
                arr[x1][j] = arr[x1][j-1];
                min = Math.min(min, arr[x1][j]);
            }
            arr[x1][y1+1] = temp;

            answer[i] = min;
        }
		System.out.println(Arrays.toString(answer));
	}
}
