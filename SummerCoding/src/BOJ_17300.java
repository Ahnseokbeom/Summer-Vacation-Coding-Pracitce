import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17300 {
	// 1 -> 2 4 5 / 2 -> 1 3 4 5 6 / 3 -> 2 5 6 / 4 -> 1 2 5 7 8
	// 5 -> 다 / 6 -> 2 3 5 8 9 / 7 -> 4 5 8 / 8 -> 4 5 6 7 9 / 9 -> 5 6 8

	// 1,3 -> 2 / 1,7 -> 4 / 1,9 -> 5 / 2,8 -> 5 / 3,1 -> 2 / 3,9 -> 6 / 3,7 -> 5
	// 4,6 -> 5 / 6,4 -> 5 / 7,1 -> 4 / 7,3 -> 5 / 7,9 -> 8
	// 8,2 -> 5 / 9,3 -> 6 / 9,1 -> 5 / 9,7 -> 8
	public static void main(String[] args) throws IOException{
		int[][] check = new int[10][10];
		check[1][3] = 2; check[1][7] = 4; check[1][9] = 5;
		check[2][8] = 5; check[3][1] = 2; check[3][7] = 5; check[3][9] = 6;
		check[4][6] = 5; check[6][4] = 5; check[7][1] = 4; check[7][3] = 5; check[7][9] = 8;
		check[8][2] = 5; check[9][1] = 5; check[9][3] = 6; check[9][7] = 8;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[l+1];
		Set<Integer> set = new HashSet<>();
		for(int i = 1;i<=l;i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			set.add(a);
		}
		System.out.println("arr : "+Arrays.toString(arr));
		System.out.println("set : "+set);
		boolean flag = true;
		for(int i = 1;i<l;i++) {
			int a = arr[i];
			int b = arr[i+1];
			switch(arr[i]) {
			case 1: if(b==2 || b==4 || b==5) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false; break;
			case 2: if(b==1 || b==3 || b==4 || b==5 || b==6) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false; break;
			case 3: if(b==2 || b==5 || b==6) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false; break;
			case 4 : if(b==1 || b==2 || b==5 || b==7 || b==8) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false; break;
			case 5 : if(b==5 && set.contains(b)) {
				flag = false; break;
				}else break;
			case 6 : if(b==2 || b==3 || b==5 || b==8 || b==9) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false;
			case 7 : if(b==4 || b==5 || b==8) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false;
			case 8 : if(b==4 || b==5 || b==6 || b==7 ||b==9) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false;
			case 9 : if(b==5 || b==6 || b==8) {
				break;
				}else if(check[a][b]!=0) {
					if(!set.contains(check[a][b])) {
						flag = false; break;
					}else break;
				}else flag = false;
			}
			System.out.println("check[a][b] : "+check[a][b]);
			System.out.println("flag : "+flag);
		}
		if(set.size()!=l) System.out.println("NO");
		else if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

}
