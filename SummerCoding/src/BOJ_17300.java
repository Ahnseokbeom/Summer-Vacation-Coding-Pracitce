import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17300 {
	public static void main(String[] args) throws IOException{
		// x,y 중간 값
		int[][] check = new int[10][10];
		check[1][3] = 2; check[1][7] = 4; check[1][9] = 5;
		check[2][8] = 5; check[3][1] = 2; check[3][7] = 5; check[3][9] = 6;
		check[4][6] = 5; check[6][4] = 5; check[7][1] = 4; check[7][3] = 5; check[7][9] = 8;
		check[8][2] = 5; check[9][1] = 5; check[9][3] = 6; check[9][7] = 8;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[l+1];
		boolean flag = true;
		Set<Integer> set = new HashSet<>();
		for(int i = 1;i<=l;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(i==1) {
				arr[i] = a;
				set.add(a);
			}
			else {
				arr[i] = a;
				set.add(a);
				int x = arr[i-1];
				int y = arr[i];
				switch(x) {
				// 1 -> 2 4 5 6 8 / 2 -> 1 3 4 5 6 7 8 / 3 -> 2 4 5 6 8 / 4 -> 1 2 3 5 7 8 9
				// 5 -> 다 / 6 -> 1 2 3 5 7 8 9 / 7 -> 2 4 5 6 8 / 8 -> 1 3 4 5 6 7 9 / 9 -> 2 4 5 6 8
				case 1: if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==2 || y==4 || y==5 || y==6 || y==8) {
							break;
						}else flag = false;
				case 2: if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==1 || y==3 || y==4 || y==5 || y==6 || y==7 || y==8) {
							break;
						}else flag = false;
				case 3: if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==2 || y==4 || y==5 || y==6 || y==8) {
							break;
						}else flag = false;
				case 4 : if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==1 || y==2 || y==3 || y==5 || y==7 || y==8 || y==9) {
							break;
						}else flag = false;
				case 5 : if(y==5 && set.contains(check[x][y])) {
					flag = false; break;
					}else break;
				case 6 : if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==1 ||y==2 || y==3 || y==5 || y==7 || y==8 || y==9) {
							break;
						}else flag = false;
				case 7 : if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==2 || y==4 || y==5 || y==6 ||y==8) {
							break;
						}else flag = false;
				case 8 : if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==1 || y==3 || y==4 || y==5 || y==6 || y==7 || y==9) {
							break;
						}else flag = false;
				case 9 : if(check[x][y]!=0) {
							if(!set.contains(check[x][y])) {
								flag = false; break;
							}else break;
						}else if(y==2 || y==4 || y==5 || y==6 || y==8) {
							break;
						}else flag = false;
					}
				}
//			System.out.println("i : "+i+" flag : "+flag);
			if(!flag) break;
		}
//		System.out.println("arr : "+Arrays.toString(arr));
//		System.out.println("set : "+set);
		if(set.size()!=l) System.out.println("NO");
		else if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

}
