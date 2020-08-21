package World;
import java.util.*; 
public class ConversionPrefix
{ 
	public static String InfixToPrefix(String exp) 
    { 
        String result = new String(""); 
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
            if (Character.isLetterOrDigit(c)) 
			{
				result += c; 
		   }
            else if (c == '(') 
			{
		        stack.push(c); 
			}
             
            else if (c == ')') 
            { 
					while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression";                  
                else
                    stack.pop(); 
            } 
            else 
            { 
				
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
				{ 
                    if(stack.peek() == '(') 
                        return "Invalid Expression"; 
                    result += stack.pop(); 
				} 
                stack.push(c); 
			} 
       
        } 
       
        
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
    } 
    public static int Prec(char ch) 
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
    } 
       
    
    public static void main(String[] args)  
    { 
		Scanner buf = new Scanner(System.in);
        String exp = buf.nextLine();
		String str1 = new String("");
		String str = new StringBuilder(exp).reverse().toString();
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
        String str2 = InfixToPrefix(str1);
		String str3 = new StringBuilder(str2).reverse().toString();
		System.out.println("Conversion of prifix to prefix:"str3); 
    } 
} 