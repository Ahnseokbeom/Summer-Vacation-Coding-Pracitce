package Week5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PRO_2_EnglishEndToEnd {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3,
				new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
		System.out.println(Arrays.toString(solution(5,
				new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
		System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));

	}
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Deque<String> q = new LinkedList<>();
        int count = 0;
		int minus = n-1;
		// 1~n까지의 수를 담은 배열
        int[] numbers = new int[n];
		for(int j = 1;j<=n;j++) {
			numbers[j-1] = j;
		}
		// 각 자릿수에 1~n까지 계속 반복(words.length와 같을 때까지)
		ArrayList<Integer> arr =new ArrayList<>();
		while(arr.size()!=words.length) {
			for(int k = 1;k<=n;k++) {
				arr.add(k);
				if(arr.size()==words.length) break;
			}
		}
		int i = 0;
		for(;i<words.length;i++) {
			if(((i+minus)+1)%n==0) count++;
			if(!q.isEmpty() &&
               q.getLast().charAt(q.getLast().length()-1)!=words[i].charAt(0)) {
				break;
			}else if(!q.isEmpty() && q.contains(words[i])) {
				break;
			}else {
				q.addLast(words[i]);
			}
		}
        if(q.size()==words.length){
            answer[0] = answer[1] = 0;
        }else{
            answer[0] = arr.get(i);
            answer[1] = count;
        }
        return answer;
    }
}
