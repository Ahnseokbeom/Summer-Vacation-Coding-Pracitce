package Week6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PRO_2_OpenChat {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234"
				,"Enter uid1234 Prodo","Change uid4567 Ryan"})));
	}
	 public static String[] solution(String[] record) {
    	ArrayList<String> list = new ArrayList<String>();
    	Map<String, String> name = new HashMap<>();
    	for(int i = 0;i<record.length;i++) { // arr배열을 공백 기준으로 구분
    		String[] arr = record[i].split(" ");
    		if(arr[0].equals("Enter")) { // 0번째 인덱스가 enter이면(입장)
    			name.put(arr[1], arr[2]); // id와 username을 map에 넣는다.
    			list.add(arr[1]+"님이 들어왔습니다."); // list의 id를 넣은 결과 추가
    		}else if(arr[0].equals("Leave")) { // 0번째 인덱스가 leave이면(퇴장)
    			list.add(arr[1]+"님이 나갔습니다."); // list의 id를 넣고 결과 추가
    		}else if(arr[0].equals("Change")) { // 0번째 인덱스가 change이면(바꿈)
    			name.replace(arr[1], arr[2]); // id와 username의 값을 바꿔준다.
    		}
    	}
    	String[] answer = new String[list.size()];
    	for(int i = 0;i<answer.length;i++) {
    		int idx = list.get(i).indexOf("님");
    		String str = list.get(i).substring(0,idx);
    		answer[i] = name.get(str)+list.get(i).substring(idx);
     }
        return answer;
	 }
}
