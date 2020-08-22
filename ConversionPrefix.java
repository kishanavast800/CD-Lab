package World;// its a package which is create for use this program in other program
import java.util.*;// its a predefined package of java which is used for implement Scanner class  
public class ConversionPrefix   //its a public class
{ 
	public static String InfixToPrefix(String exp)   //its a static member function 
    { 
        String result = new String("");   //its intialize a empty string
        Stack<Character> stack = new Stack<>(); //It a collection framework used for implement stack
        for (int i = 0; i<exp.length(); ++i)/*in this loop we divide string into character*/ 
        { 
            char c = exp.charAt(i); 
            if (Character.isLetterOrDigit(c)) /*in this loop we have checked given character is Degit or 
												letter using predefined keyword Character.isLetterOrDigit if its letter or digit its return true and add into result*/
			{
				result += c; 
			}
            else if (c == '(') //oterwise if ( comes then put in stack
			{
		        stack.push(c); 
			}
             
            else if (c == ')') //Similarly as above statements
            { 
					while (!stack.isEmpty() && stack.peek() != '(')//here we check if closing bracket come then pop the stack 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression";                  
                else
                    stack.pop(); 
            } 
            else //this statement works on comming matimatical symbol inside this its call Prec function and perform operation
            { 
				
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))   
				{ 
                    if(stack.peek() == '(') 
                        return "Invalid Expression"; 
                    result += stack.pop(); 
				} 
                stack.push(c); 
			} 
       
        } // ending of for loop
       
        
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
    }// end of function 
    public static int Prec(char ch)// Static member function 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return 0; 
    } // end of function
       
    
    public static void main(String[] args)//its a main function  
    { 
		Scanner buf = new Scanner(System.in);//its a scanner class which is used to take input from user
        String exp = buf.nextLine();//using this statement enter a string
		String str1 = new String("");
		String str = new StringBuilder(exp).reverse().toString();//using stringBuilder its reverse string
		char ch[] = str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			if(ch[i] == ')')
			{
				ch[i] = '(';
				str1 += ch[i];
			}
			else if(ch[i] =='(')
			{
				ch[i] = ')';
				str1 += ch[i];
			}
			else
			{
				str1 += ch[i];
			}
		}
        String str2 = InfixToPrefix(str1);//method calling
		String str3 = new StringBuilder(str2).reverse().toString();
		System.out.println("Conversion of prifix to prefix:"+str3); //final output convert infix to prefix
    }// ending of main function 
} // ending of class