package test;

public class Test32 {

	
	
	private static int numOfBetween1AndN(int n){
		int num=0;
		for(int i=1;i<=n;i++){
			num+=numOf1(i);
		}
		return num;
		
	}

	private static int numOf1(int i) {
		int num=0;
		boolean b=i>0?true:false;
		while(b){
			if (i%10==1) {
				num++;
			}
			i/=10;
			
			if (i<=0) {
				break;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(numOfBetween1AndN(12));
	}
}
