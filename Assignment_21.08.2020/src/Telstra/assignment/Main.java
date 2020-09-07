package Telstra.assignment;
import java.lang.Math;
public class Main {
	
	public static int reverse(int n) {
		int res = 0, sign =1;
		int digit = 0;
		if(n<0) {
			sign = -1;
			n *= -1;
		}
		while(n>0) {
			digit = n % 10;
			res = res * 10 + digit;
			n /= 10;
		}
		if(sign==-1)
			res *= -1;
		return res;
	}
	
	public static boolean isArmstrongNumber(int n) {
		int n_copy = n, sum = 0;
		while(n>0) {
			sum += Math.pow(n % 10,3);
			n /= 10;
		}
		return (n_copy==sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-1000));
		System.out.println(isArmstrongNumber(371));
	}

}
