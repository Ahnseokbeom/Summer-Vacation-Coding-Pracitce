package Week7;

public class PRO_2_VowelDictionary {
	static String[] arr = {"A","E","I","O","U"};
	static int count = 0;
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}
	public static int solution(String word) {
		count = 0;
		dic(0, "", word);
        return answer;
	}
	public static void dic(int idx, String s, String word) {
		if(idx==5) return;
		for(int i = 0;i<arr.length;i++) {
			String str = s+arr[i];
			count++;
			if(str.equals(word)) {
				answer = count;
				return;
			}
			dic(idx+1,str,word);
		}
	}
}
