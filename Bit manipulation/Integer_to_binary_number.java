package Arrays;
import java.util.Scanner;


public class bitManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number : ");
		int num=sc.nextInt();
		int num2=num;
		if(num<0)
		{
			System.out.println("please enter a positive number");
			
		}
		else if(num==0)
		{
			System.out.println(num +" its binary equivalent is : 0");
		}
		else
		{
			StringBuilder sb=new StringBuilder();
			
			while(num>0)
			{
				if(num%2==0)
				{
					sb.insert(0,'0');
				}
				else
				{
					sb.insert(0,'1');
				}
				
				num=num/2;
			}
			
			System.out.println("Integer :"+num2+" to it Binary Equivalent :"+sb);
			
		}

	}

}
