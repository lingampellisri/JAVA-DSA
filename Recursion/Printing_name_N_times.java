package Arrays;
import java.util.Scanner;
public class Recursion {
	public static void print(int num)
	{
		if(num==0)
		{
			return ;
		}else
		{
						
						
						System.out.println("Recursion "+num);
						print(num-1);

			
		}
	}

	public static void main(String[] args) {
	
	System.out.println("Enter the n value : ");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	print(n);
	}

}
