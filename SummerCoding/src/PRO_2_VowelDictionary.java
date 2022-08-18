
public class PRO_2_VowelDictionary {
	static String[] arr = {"A","E","I","O","U"};
	static int count = 0;
	static int answer = 0;
	public static void main(String[] args) {
		String word = "AAAAE";
//		String word = "AAAE";
//		String word = "I";
//		String word = "EIO";
		dic(0,"",word);
//		System.out.println(answer);

	}
	public static void dic(int idx, String s, String word) {
		if(idx==5) return;
		for(int i = 0;i<arr.length;i++) {
			String str = s+arr[i];
//			System.out.println(i+" "+str+" "+arr[i]+" "+idx);
			count++;
			if(str.equals(word)) {
				answer = count;
				return;
			}
			dic(idx+1,str,word);
		}
	}
}
