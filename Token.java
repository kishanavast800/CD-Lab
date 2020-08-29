//calculate number of token genrate in given equation
package World;//its my package which is used for storing .class files
import java.util.*;//its a predefined package of java which is used for importing methods and classes
public class Token//its a public class
{
	public static void CalculateNoOfToken(String str)//its a static member function
	{
		int n = str.length();
		int a=0,b=0,c=0,temp =0;
		char ch[] = str.toCharArray();//use toCharArray method for break string into character
		for(int i=0;i<n;i++)//its a logic for calculation number of digit and operator
		{
			if(Character.isLetter(ch[i]))
			{
				a++;
			}
			else if(Character.isDigit(ch[i]))
			{
				continue;
			}
			else if(ch[i] == ' ')
			{
				continue;
			}
			else 
			{
				c++;
			}
		}//end of first for loop
		for(int i=0;i<n;i++)//its a second loop for counting the digits
		{
			if(Character.isDigit(ch[i]) && i+1<n)
			{
			int x = 0;
			for(int j=i+1;j<n;j++)
			{
				if(Character.isDigit(ch[i])&&Character.isDigit(ch[j]))
				{
					x++;
				}
				else if(Character.isDigit(ch[i])&&Character.isDigit(ch[j])!= true)
				{
					x++;
					i=j;
					break;
				}
				else
				{
					i=j;
					break;
				}
			}
			
			if(x>=1)
			{
				b++;
			}
			}
		}//end of 2nd for loop
		System.out.println("number of letter : "+a);
		System.out.println("number of digit : "+b);
		System.out.println("number of operators : "+c);
		System.out.println("Total number of tokens : "+(a+b+c));
	}//end of function
	public static void main(String[] args)//its a main function
	{
		Scanner buf = new Scanner(System.in);//its a predefined class which is used for taking input
		System.out.println("Enter the string which include number operater and oparands : ");
		String str1 = buf.nextLine();
		String str = str1+" ";
		CalculateNoOfToken(str);//function calling
	}//end of main function
}//end of Token class