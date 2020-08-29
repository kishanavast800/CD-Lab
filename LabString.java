//ab*c(a+b) grammer
package World;//its my pacakge which store .class file
import java.util.*;//its a predefined pacakge of java which is used for importing predefined method and classes
public class LabString//its a public class
{
	public static void main(String[] args)//its a main method
	{
		Scanner buf = new Scanner(System.in);//its a predefined class for taking input from user
		String s1 = buf.nextLine();//taking input string by user
		int n=s1.length();
		char ch[] = s1.toCharArray();//convert string in to char array
		if( ch[0]=='a' && (ch[n-1]=='a' || ch[n-1]=='b') && ch[n-2] == 'c')//logic for checking grammer is valid or not
		{
			int temp = 3;
			for(int i=1;i<n-2;i++)//for loop 1
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
			}//end of for loop 1
			if(temp == n)
			{
			System.out.println("string is valid");
			}
		}//end of if condition
		else
		{
			System.out.println("Sorry string is not valid");
		}
	}//end of main function
}//end of class