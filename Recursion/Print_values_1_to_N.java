package Arrays;
import java.util.Scanner;
public class Recursion {
	public static void print(int val,int num)
	{
		if(val>num)
		{
			return ;
		}else
		{
						
						
						System.out.println(val);
						print(val+1,num);

			
		}
	}

	public static void main(String[] args) {
	
	System.out.println("Enter the n value : ");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	print(1,n);
	}

}
