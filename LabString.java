//ab*c(a+b) grammer
package World;
import java.util.*;
public class LabString
{
	public static void main(String[] args)
	{
		Scanner buf = new Scanner(System.in);
		String s1 = buf.nextLine();
		int n=s1.length();
		char ch[] = s1.toCharArray();
		for(int i=0;i<n;i++)
		{ 
			System.out.println(ch[i]);
		}
		if( ch[0]=='a' && (ch[n-1]=='a' || ch[n-1]=='b') && ch[n-2] == 'c')
		{
			int temp = 3;
			for(int i=1;i<n-2;i++)
			{
				if(ch[i] != 'b')
				{
					System.out.println("Sorry string is not valid");
					break;
				}
				else
				{
					temp++;
					
				}
			}
			if(temp == n)
			{
			System.out.println("string is  valid");
			}
		}
		else{
			System.out.println("Sorry string is not valid");
		}
			
	}
}