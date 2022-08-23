package Week5;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PRO_2_EnglishEndToEnd {
	public static void main(String[] args) {
//		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		Deque<String> q = new LinkedList<>();
//		int n = 3;
//		int n = 5;
		int n = 2;
		// 현재 진행된 수
		int count = 0;
		// n = 2일 때, 1,3,5,7,9...
		// n = 3일 때, 1,4,7,10...
		// n = 5일 때, 1,6,11,16...
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
			if(!q.isEmpty() && q.getLast().charAt(q.getLast().length()-1)!=words[i].charAt(0)) {
				break;
			}else if(!q.isEmpty() && q.contains(words[i])) {
				break;
			}else {
				q.addLast(words[i]);
			}
		}
		System.out.println(arr.get(i)+" "+count);
	}
}
