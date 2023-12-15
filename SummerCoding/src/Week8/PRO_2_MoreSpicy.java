package Week8;
import java.util.PriorityQueue;

public class PRO_2_MoreSpicy {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i<scoville.length;i++) {
			pq.add(scoville[i]);
		}
        while(pq.peek()<=K && pq.size()!=1) {
			int s1 = pq.poll();
			int s2 = pq.poll();
			pq.add(s1+(s2*2));
			answer++;
		}
        if(pq.peek()<K) answer = -1;
        return answer;
    }
}
