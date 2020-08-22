package World;//its a package which is create by me for storing the .class file and use code directly in program
import java.util.*; //its a predefined package which is used for import Scanner class and Stack
class ConversionPostfix //Creation of class
{ 
	public static String InfixToPostfix(String exp)//its a static member function 
    { 
        String result = new String(""); //create or initialize the empty string
        Stack<Character> stack = new Stack<>(); // using collection framework
        for (int i = 0; i<exp.length(); ++i) //using logic for conversion of infix expression to postfix expression
        { 
            char c = exp.charAt(i); 
            if (Character.isLetterOrDigit(c)) //in this line we have to check input char iis letter or digit or not menas other
			{
				result += c; 
				System.out.println(result);
            }
            else if (c == '(') 
			{
				System.out.println("result");
                stack.push(c); 
			}
             
            else if (c == ')') 
            { 
				System.out.println("resultkigz");
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
				System.out.println("result xrgf"+Prec(c));
                    if(stack.peek() == '(') 
                        return "Invalid Expression"; 
                    result += stack.pop(); 
				} 
                stack.push(c); 
			} 
       
        } //end of for loop
       
        
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
    } //end of function
    public static int Prec(char ch)//static member function 
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
    } //end of function    
    public static void main(String[] args)//its a main function  
    { 
		Scanner buf = new Scanner(System.in);//its a predefined class which is used for taking input from user
        String exp = buf.nextLine(); 
        System.out.println(InfixToPostfix(exp)); //function calling and printing
    } 
} //end of main function