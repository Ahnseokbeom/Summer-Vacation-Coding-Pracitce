package Week8;
public class PRO_3_CodingTestStudy {
	public static void main(String[] args) {
		// 1 3 alp / 2 4 cop / 5 count
		int alp = 10;
		int cop = 10;
		int answer = 0;
		int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};
//		int[][] problems = {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
		int maxalp = 0;
		int maxcop = 0;
		int minalp = Integer.MAX_VALUE;
		int mincop = Integer.MAX_VALUE;
		for(int i = 0;i<problems.length;i++) {
			maxalp = Math.max(maxalp, problems[i][0]);
			maxcop = Math.max(maxcop, problems[i][1]);
			minalp = Math.min(minalp, problems[i][0]);
			mincop = Math.min(mincop, problems[i][1]);
		}
		System.out.println("max : "+maxalp+" "+maxcop);
		System.out.println("min : "+minalp+" "+mincop);
		System.out.println(alp+" "+cop);
		if(alp<minalp) {
			answer += minalp-alp;
			alp = minalp;
		}else if(cop<mincop) {
			answer += mincop - cop;
			cop = mincop;
		}

		System.out.println("update : "+alp+" "+cop+" "+answer);
	}

}
