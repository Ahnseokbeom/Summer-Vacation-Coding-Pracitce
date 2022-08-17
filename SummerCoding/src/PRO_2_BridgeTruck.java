import java.util.LinkedList;
import java.util.Queue;
public class PRO_2_BridgeTruck {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int answer = 0;
		int[] truck_weights = {7,4,5,6};
		Queue<Integer> queue = new LinkedList<Integer>();
        for (var i = 0; i < bridge_length; i++) {
            queue.add(-1);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            //모든 트럭이 다 올라가면 다리가 빌 때까지 시간++.
            if (index == truck_weights.length) {
                while (!queue.isEmpty()) {
                    queue.remove();
                    answer++;
                }
                break;
            }

            int truck = truck_weights[index];
            int now = queue.remove();
            //트럭이 다리에서 제거되면 무게 반환.
            if (now != -1) {
                weight += now;
            }
            //트럭이 다리 위로 올라갈 수 있을 때
            if (weight - truck >= 0) {
                index++;
                queue.add(truck);
                weight -= truck;
            //트럭이 올라가지 못 할 때
            } else {
                queue.add(-1);
            }
            answer++;
        }
        System.out.println(answer);
	}
}
