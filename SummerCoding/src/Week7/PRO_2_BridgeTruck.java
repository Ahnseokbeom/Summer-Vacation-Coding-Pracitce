package Week7;
import java.util.LinkedList;
import java.util.Queue;
public class PRO_2_BridgeTruck {
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7,4,5,6}));
		System.out.println(solution(100, 100, new int[] {10}));
		System.out.println(solution(100, 100,new int[] {10,10,10,10,10,10,10,10,10,10}));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q= new LinkedList<Integer>();
        for (var i = 0; i < bridge_length; i++) {
            q.add(-1);
        }
        int index = 0;
        while (!q.isEmpty()) {
            if (index == truck_weights.length) {
                while (!q.isEmpty()) {
                    q.remove();
                    answer++;
                }
                break;
            }

            int truck = truck_weights[index];
            int now = q.remove();
            if (now != -1) {
                weight += now;
            }
            //트럭이 다리 위로 올라갈 수 있을 때
            if (weight - truck >= 0) {
                index++;
                q.add(truck);
                weight -= truck;
            //트럭이 올라가지 못 할 때
            } else {
                q.add(-1);
            }
            answer++;
        }
        return answer;
    }
}
