package Week3;

public class PRO_2_GroupPhoto {
	static int answer;
	static boolean[] visited;
	static String[] arr = {"A","C","F","J","M","N","R","T"};
	public static void main(String[] args) {
		String[] data = {"N~F=0", "R~T>2"};
		answer = 0;
		visited = new boolean[8];
		count(0,"",data);
		System.out.println(answer);
	}
	static void count(int idx, String names,String[] data){
		if(idx == 8){
			if(check(names,data)) {
				answer++;
			}
			return;
		}
		for(int i = 0; i< 8; i++){
			if(!visited[i]){
				visited[i] = true;
				String name = names+arr[i];
				count(idx + 1,name,data);
				visited[i] = false;
			}
		}
	}
	static boolean check(String name,String[] data){
		for(String str : data){
			int name1 = name.indexOf(str.charAt(0));
			int name2 = name.indexOf(str.charAt(2));
			char rule = str.charAt(3);
			int standard = str.charAt(4) - '0';

			switch (rule){
				case '=' :
					if(!(Math.abs(name1 - name2) == standard + 1)){
						return false;
					}
					break;
				case '>' :
					if(!(Math.abs(name1 - name2) > standard + 1)){
						return false;
					}
					break;
				case '<' :
					if(!(Math.abs(name1 - name2) < standard + 1)){
						return false;
					}
					break;
			}
		}
		return true;
	}

}
