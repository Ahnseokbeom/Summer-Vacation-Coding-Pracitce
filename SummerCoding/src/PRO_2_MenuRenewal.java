import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PRO_2_MenuRenewal {
	static HashSet<String> set = new HashSet<>();
	static HashSet<String> set2 = new HashSet<>();
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();

		String[] orders = {"XYZ", "XWY", "WXA"};
//		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,4};
		comb(orders);
		String[] s = set.toArray(new String[0]);
		System.out.println(Arrays.toString(s));
		int min = 0;
		for(int i = 0;i<orders.length;i++) {
			min = Math.min(orders[i].length(), course[course.length-1]);
		}
		comb2(s,min);
		List<String> checks = new ArrayList<>(set2);
		System.out.println(checks);
		check(orders,checks);
		System.out.println(map);
//		for(int i = 0;i<course.length;i++) {
//			if()
//		}
	}
	static void comb(String[] orders) {
		for(int i = 0;i<orders.length;i++) {
			for(int j = 0;j<orders[i].length();j++) {
				set.add(orders[i].charAt(j)+"");
			}
		}
	}
	static void comb2(String[] s, int min) {
		for(int i = 0;i<s.length;i++) {
			String str = s[i];
			for(int j = i+1;j<s.length;j++) {
				str+=s[j];
				if(str.length()>min) continue;
				else set2.add(str);
			}
		}
		for(int i = s.length-1;i>=0;i--) {
			String str = s[i];
			for(int j = i-1;j>=0;j--) {
				str+=s[j];
				if(str.length()>min) continue;
				else set2.add(str);
			}
		}
	}
	static void check(String[] orders, List<String> checks) {
		for(int i = 0;i<orders.length;i++) {
			for(int j = 0;j<orders[i].length();j++) {
				String str = orders[i].charAt(j)+"";
				for(int k = j+1;k<orders[i].length();k++) {
					str+=orders[i].charAt(k)+"";
					if(checks.contains(str)) map.put(str,map.getOrDefault(str,0)+1);
				}
			}
		}
		for(int i = 0;i<orders.length;i++) {
			for(int j = orders[i].length()-1;j>=0;j--) {
				String str = orders[i].charAt(j)+"";
				for(int k = j-1;k>=0;k--) {
					str+=orders[i].charAt(k)+"";
					if(checks.contains(str)) map.put(str,map.getOrDefault(str,0)+1);
				}
			}
		}
	}

}