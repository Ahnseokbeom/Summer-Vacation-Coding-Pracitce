package Week8;

public class AtoB {
	static int sum1 = 0;
	public static void main(String[] args) {
		int A = 1;
		int B = 10;
		sum(A,B);
	}
	public static int sum(int A, int B) {
		sum1+=A;
		A++;
		if(A>B) {
			System.out.println("합계 : "+sum1);
			return 0;
		}
		return sum(A,B);
	}

}
