package Week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class PRO_3_CodingTestStudy {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {{"korean", "11:40", "30"},{"english", "12:10", "20"},{"math", "12:30", "40"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"science", "12:40", "50"},{"music", "12:20", "40"},
			{"history", "14:00", "30"},{"computer", "12:30", "100"}})));
		System.out.println(Arrays.toString(solution(new String[][] {{"aaa", "12:00", "20"},{"bbb", "12:10", "30"},{"ccc", "12:40", "10"}})));
	}
	public static String[] solution(String[][] plans) {
		ArrayList<String> result = new ArrayList<>();
        ArrayList<homeWork> homework = new ArrayList<>();
        Stack<homeWork> stack = new Stack<>();
        HashMap<Integer, homeWork> map = new HashMap<>();

        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            int playTime = Integer.parseInt(plan[2]);
            int start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            map.put(start, new homeWork(plan[0], start, playTime));
            homework.add(new homeWork(plan[0], start, playTime));
        }

        homework.sort((s1, s2) -> s1.start != s2.start ? s1.start - s2.start : s1.playTime - s2.playTime);

        int time = homework.get(0).start;
        int cnt = 0;

        while (cnt < plans.length) {
            if (!stack.isEmpty()) {
                stack.peek().playTime -= 1;
                if (stack.peek().playTime == 0) {
                    result.add(stack.peek().name);
                    stack.pop();
                    cnt++;
                }
            }

            if (map.containsKey(time))stack.add(map.get(time));
            time++;
        }
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }

    static class homeWork {
        String name;
        int start;
        int playTime;

        public homeWork(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

}
