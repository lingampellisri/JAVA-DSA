package Arrays;
import java.util.Scanner;
public class Recursion {
	public static int sum(int val)
	{
		if(val==0)
		{
			return 0;
		}else
		{		
						return val+sum(val-1);
	
			
		}
	}

	public static void main(String[] args) {
	
	System.out.print("Enter the n value : ");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println(sum(n));
	}

}
