
public class InfixToPostfix {
	public static String inToPost(String infix) {
		if(infix.equals(null))
			return infix;
		
		ArrayStack temp = new ArrayStack();
		String postfix = "";
		
		for(int i = 0; i < infix.length(); i++) {
			//checks if it is a number and adds it to the output. otherwise run the rest of the code
			if(Character.isLetterOrDigit(infix.charAt(i))) {
				postfix += infix.charAt(i);
			}
				
			//checks for order of operations and prints based off of that
			if(!temp.isEmpty()) {
				if(temp.peek().equals('*') || temp.peek().equals('/')) {
					if(infix.charAt(i) == '*' || infix.charAt(i) == '/' || infix.charAt(i) == '+' || infix.charAt(i) == '-') {
						postfix += temp.pop();		
					}
				}
			}
			if(!temp.isEmpty()) {
				if(temp.peek().equals('+') || temp.peek().equals('-')) {
					if(infix.charAt(i) == '+' || infix.charAt(i) == '-') {
						postfix += temp.pop();
					}
				}
			}
				
			//checks for a operator and adds it to the stack
			if(infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '*' || infix.charAt(i) == '/' || infix.charAt(i) == '(') {
				temp.push(infix.charAt(i));
			}
			
			//if it detects a close parenthesis then it will go through 
			//and add everything from the stack to the output except the opening parenthesis
			if(infix.charAt(i) == ')') {
				while(!temp.isEmpty()) {
					if(temp.peek().equals('(')) {
						temp.pop();
						break;
					}
					else
						postfix += temp.pop();
				}
			}
		}
		
		//makes sure all the operators are out of the stack at the end
		while(!temp.isEmpty()) {
			postfix += temp.pop();
		}
		
		//return output
		return postfix;
	}
	
	
	public static void main(String[] args) {
		String tester = "A+B*C+D";
		
		System.out.println(inToPost(tester));
	}

}
