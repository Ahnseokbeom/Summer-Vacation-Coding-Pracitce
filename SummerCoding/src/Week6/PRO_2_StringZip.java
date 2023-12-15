package Week6;

public class PRO_2_StringZip {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
	public static int solution(String s) {
        int answer = 0;
        if(s.length()==1) answer = 1;
        for (int i = 1; i < s.length() / 2 + 1; i++) {
			 // pattern
            String pattern = s.substring(0, i);
            // 압축 끝난 문자열
            String end = "";
            // 현재 비교되는 대상
            String current = "";
            // 반복 횟수
            int count = 1;

            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    end += s.substring(j, s.length());
                }
                else {
                    current = s.substring(j, j + i);
                    if (current.equals(pattern)) {
                        count++;
                    } else {
                        end += ((count == 1 ? "" : count + "") + pattern);
                        pattern = s.substring(j, j + i);
                        count = 1;
                    }
                }
            }
            String result = (count == 1 ? "" : count + "") + pattern + end;
            if (answer == 0) answer = result.length();
            if(result.length() < answer) answer = result.length();
		}
        return answer;
    }
}
