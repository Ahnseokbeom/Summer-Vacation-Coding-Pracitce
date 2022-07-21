import java.util.ArrayList;
import java.util.HashMap;

public class PRO_2_OpenChat {
	class Solution {
	    public String[] solution(String[] record) {
	    	ArrayList<String> list = new ArrayList<String>();
	    	HashMap<String, String> name = new HashMap<>();
	    	for(int i = 0;i<record.length;i++) {
	    		String[] arr = record[i].split(" ");
	    		// 입장
	    		if(arr[0].equals("Enter")) {
	    			name.put(arr[1], arr[2]); // id와 username을 map에 넣는다.
	    			list.add(arr[1]+"님이 들어왔습니다.");
	    			// 퇴장
	    		}else if(arr[0].equals("Leave")) {
	    			list.add(arr[1]+"님이 나갔습니다.");
	    			// 변경
	    		}else if(arr[0].equals("Change")) {
	    			name.replace(arr[1], arr[2]); // id와 username의 값을 바꿔준다.
	    		}
	    	}
	    	String[] answer = new String[list.size()];
	    	for(int i = 0;i<answer.length;i++) {
	    		int Nidx = list.get(i).indexOf("님");
	    		String str = list.get(i).substring(0,Nidx);
	    		answer[i] = name.get(str)+list.get(i).substring(Nidx);
	    	}

	        return answer;
	    }
	}
}
