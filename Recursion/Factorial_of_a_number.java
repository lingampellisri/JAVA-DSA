package Arrays;
import java.util.Scanner;
public class Recursion {
	public static int factorial(int val)
	{
		if(val==0)
		{
			return 1;
		}else
		{		
						return val*factorial(val-1);
	
			
		}
	}

	public static void main(String[] args) {
	
	System.out.print("Enter the n value : ");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println(factorial(n));
	}

}
