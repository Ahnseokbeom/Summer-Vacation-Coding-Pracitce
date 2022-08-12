import java.util.LinkedList;
import java.util.Queue;
public class PRO_2_BridgeTruck {
	class Solution {
		    public int solution(int bridge_length, int weight, int[] truck_weights){
		        int answer = 0; // 시간
		        int truck = 0;
		        Queue<Integer> q = new LinkedList<>();
		        for(int i = 0;i<truck_weights.length;i++) {
		        	while(true) {
		        		if(q.isEmpty()) {
		        			q.offer(truck_weights[i]);
		        			answer++;
		        			truck+=truck_weights[i];
		        			break;
		        		}else if(q.size()==bridge_length) {
		        			truck-=q.poll();
		        		}else {
		        			if(truck+truck_weights[i]<=weight) {
		        				q.offer(truck_weights[i]);
		        				truck+=truck_weights[i];
		        				answer++;
		        				break;
		        			}else {
		        				q.offer(0);
		        				answer++;
		        			}
		        		}
		        	}
		        }
		        return answer+bridge_length;
		    }
		}

}
