package Week5;
import java.util.LinkedList;
import java.util.Queue;
public class PRO_2_Process {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,1,3,2}, 2));
		System.out.println(solution(new int[] {1,1,9,1,1,1}, 0));
	}
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int[] arr = new int[10];
        Queue<Integer> q = new LinkedList<>();

        for(int pri : priorities){
            arr[pri]++;
            q.add(pri);
        }
        while(!q.isEmpty()){
            int n = q.poll();
            boolean flag = true;
            location--;
            for(int i = n+1;i<10;i++){
                if(arr[i] > 0){
                    flag = false; break;
                }
            }
            if(flag){
                arr[n]--;
                answer++;
                if(location == -1) break;
            }else{
                q.add(n);
                if(location == -1) location = q.size()-1;
            }
        }
        return answer;
    }
}
