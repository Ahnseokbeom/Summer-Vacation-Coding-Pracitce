package Week4;
import java.util.Stack;

public class PRO_2_BracketRotation {
	public static void main(String[] args) {
		String s1 = "[](){}";
		System.out.println(solution(s1));

		String s2 = "}]()[{";
		System.out.println(solution(s2));

		String s3 = "[)(]";
		System.out.println(solution(s3));

		String s4 = "}}}";
		System.out.println(solution(s4));
	}
	public static int solution(String s) {
        int answer = 0;
        for(int i = 0;i<s.length();i++) {
			if(check(s)) answer++;
			s = s.substring(1,s.length())+s.charAt(0);
		}
        return answer;
    }
	public static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
           switch(c) {
           case '(': stack.push(c); break;
           case '{': stack.push(c); break;
           case '[': stack.push(c); break;
           case ')':
        	   if(stack.isEmpty() || stack.peek()!='(') return false;
        	   stack.pop();
        	   break;
           case '}' :
        	   if(stack.isEmpty() || stack.peek()!='{') return false;
        	   stack.pop();
        	   break;
           case ']' :
        	   if(stack.isEmpty() || stack.peek()!='[') return false;
        	   stack.pop();
        	   break;
           }
        }
        return stack.isEmpty() ? true : false;
    }

}
