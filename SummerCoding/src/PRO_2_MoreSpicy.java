import java.util.PriorityQueue;

public class PRO_2_MoreSpicy {
	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0;i<scoville.length;i++) {
				pq.add(scoville[i]);
			}
	        while(pq.peek()<=K && pq.size()!=1) {
				int s1 = pq.poll();
				int s2 = pq.poll();
	            int mul = s1+(s2*2);
				pq.add(mul);
				answer++;
			}
	        if(pq.peek()<K) answer = -1;
	        return answer;
	    }
	}
}