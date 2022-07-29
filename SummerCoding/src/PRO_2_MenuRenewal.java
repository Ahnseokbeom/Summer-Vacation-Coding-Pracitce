import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class PRO_2_MenuRenewal {
	static HashMap<String, Integer> map = new HashMap<>();
	static HashSet<Integer> set = new HashSet<>();
	static HashSet<String> set2 = new HashSet<>();
	public static void main(String[] args) {
		// 실패
		ArrayList<String> ans = new ArrayList<>();
//		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		String[] orders = {"XYZ", "XWY", "WXA"};
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,4};

		for(int cLength : course) {
			for(String order : orders) {
				comb("",order,cLength);
			}
		}
		ArrayList<Integer> arr = new ArrayList<>(map.values());
		for(int i = 0;i<arr.size();i++) {
			if(arr.get(i)==1) continue;
			set.add(arr.get(i));
		}
		System.out.println(map);
		// [AB, AC, ACD, AD, ADE, AE, CD, DE, XY, XYZ, XZ, YZ]
		Integer[] max = set.toArray(new Integer[0]);
		System.out.println(Arrays.toString(max));
		System.out.println(arr);
		for(int i = 0;i<max.length;i++) {
			for(String value : map.keySet()) {
				if(max[i]==map.get(value)) set2.add(value);
			}
		}
		ans.addAll(set2);
		System.out.println(ans);
		// [DE, ADE, CE, AC, BCF, CDE, BCG, ACDE, BCFG]
		for(int i = 0;i<ans.size();i++) System.out.print(map.get(ans.get(i))+" ");
		System.out.println();

		for(int i = 0;i<ans.size();i++) {
			for(int j = ans.size()-1;j>=i+1;j--) {
				System.out.println(ans.get(i)+" "+ans.get(j));
				if(ans.get(i).length()==ans.get(j).length()) {
					if(map.get(ans.get(i))>map.get(ans.get(j))) {
						ans.remove(j); j++;
					}else if(map.get(ans.get(i))<map.get(ans.get(j))) {
						ans.remove(i);i = 0;
					}
				}
			}
		}
		System.out.println(ans);
		Collections.sort(ans);
		String[] answer = new String[ans.size()];
		for(int i = 0;i<answer.length;i++) {
			answer[i] = ans.get(i);
		}
		System.out.println(Arrays.toString(answer));
	}
    public static void comb(String order, String s, int count) {
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            comb(order + s.charAt(i), s.substring(i + 1), count - 1);
        }
    }
}