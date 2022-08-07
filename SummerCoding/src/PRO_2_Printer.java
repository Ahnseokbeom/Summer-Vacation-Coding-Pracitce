import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class PRO_2_Printer {
	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
//		int[] priorities = {1,1,9,1,1,1};
		int location = 2;
//		int location = 0;
		int answer = 0;
		// 1~9값 중 있는 값들을 1씩 더해줄 배열
        int[] arr = new int[10];
        Queue<Integer> q = new LinkedList<>();

        for(int pri : priorities){
            arr[pri]++;
            q.add(pri);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(q);
        while(!q.isEmpty()){
            int n = q.poll();
            System.out.println("n : "+ n);
            boolean flag = true;
            location--;
            System.out.println("location : "+location);
            // 현재 n값보다 우선 순위가 높은 값이 있는지 체크
            for(int i = n+1;i<10;i++){
                if(arr[i] > 0){
                    flag = false; break;
                }
            }
            //없을 시
            if(flag){
                arr[n]--;
                answer++;
                if(location == -1) break;
            // 있을 시
            }else{
                q.add(n);
                if(location == -1) location = q.size()-1;
            }
            System.out.println("q : "+q);
        }
        System.out.println(answer);
	}


}
