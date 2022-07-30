import java.util.Stack;

public class PRO_2_BracketRotation {
	public static void main(String[] args) {
		String s = "[](){}";
//		String s = "}]()[{";
//		String s = "[)(]";
//		String s = "}}}";
		int ans = 0;
		for(int i = 0;i<s.length();i++) {
			if(check(s)) ans++;
			System.out.println(s+" check : "+check(s));
			s = s.substring(1,s.length())+s.charAt(0);
		}
		System.out.println(ans);
	}
	static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
           switch(c) {
           case '(': stack.add(c); break;
           case '{': stack.add(c); break;
           case '[': stack.add(c); break;
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
