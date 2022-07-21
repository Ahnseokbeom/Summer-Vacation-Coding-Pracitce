
public class PRO_2_StringZip {
	public static void main(String[] args) {
		String s = "ababcdcdababcdcd";
//		String s = "abcabcdede";
//		String s = "abcabcabcabcdededededede";
//		String s = "xababcdcdababcdcd";
//		String s = "aabbaccc";
		int answer = 0;
		if(s.length()==1) answer = 1;
		// s 길이/2+1보다 작으면 반복되지 않음
		for (int i = 1; i < s.length() / 2 + 1; i++) {
			 // pattern
            String pattern = s.substring(0, i);
            // 압축 끝난 문자열
            String end = "";
            // 현재 비교되는 대상
            String curr = "";
            // 반복 횟수
            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) end += s.substring(j, s.length());
                else {
                    curr = s.substring(j, j + i);
                    if (curr.equals(pattern)) {
                        count++;
                    } else {
                        end += ((count == 1 ? "" : count + "") + pattern);
                        pattern = s.substring(j, j + i);
                        count = 1;
                    }
                }
            }
            String result = (count == 1 ? "" : count + "") + pattern + end;
            if (answer == 0) {
                answer = result.length();
            }
            if(result.length() < answer) answer = result.length();
		}
		System.out.println(answer);
	}

}
