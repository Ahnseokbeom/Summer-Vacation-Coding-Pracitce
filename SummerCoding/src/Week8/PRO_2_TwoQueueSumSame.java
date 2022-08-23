package Week8;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_2_TwoQueueSumSame {
	class Solution {
	    public int solution(int[] queue1, int[] queue2) {
	        int answer = -1;
	        Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			long sum1 = 0;
			long sum2 = 0;
	        if((sum1+sum2)%2!=0) answer = -1;
	        else{
			for(int i = 0;i<queue1.length;i++) {
				q1.offer(queue1[i]);
				sum1+=queue1[i];
				q2.offer(queue2[i]);
				sum2+=queue2[i];
			}
			for(int i = 0;i<=300000;i++) {
				if(sum1==sum2) {
					answer = i;
					break;
				}
				if(sum1 > sum2) {
					int num = q1.poll();
					q2.add(num);
					sum1-=num;
					sum2+=num;
				}else if(sum1 < sum2){
					int num = q2.poll();
					q1.add(num);
					sum1+=num;
					sum2-=num;
	                }
	            }
	        }
	        return answer;
	    }
	}
}
