import java.util.Stack;

public class Calculator {

     Stack<Double> stack;
    public Calculator() {
     stack = new Stack<>();
    }

    public void getToken(char c) {
    	//CODE HERE
        switch (c){
            case '+':
                newPlus();
                break;
            case '-':
                newMinus();
                break;
            case '*':
                newMultiply();
                break;
            case '/':
                newDivide();
                break;
            case '=':
                evaluate();
                break;
            default:
                if(c >= '0' && c <= '9'){
                    newValueToken(((int) c) - 48);
                }
                break;
        }

        if(c == '+' || c == '-' || c == '*' || c == '/'){
            System.out.println("Op " + c);
        }else if(c != '=' && c != '\n'){
            System.out.println("Digit " + c);
        }

    }

    public void newValueToken(double d) {
    	//CODE HERE
        stack.push(d);
    }

    public void newPlus() {
    	//CODE HERE
        double stackTop = stack.pop();
        newValueToken(stack.pop() + stackTop);
    }

    public void newMinus() {
    	//CODE HERE
        double stackTop = stack.pop();
        newValueToken(stack.pop() - stackTop);
    }

    public void newDivide() {
    	//CODE HERE
        double stackTop = stack.pop();
        newValueToken(stack.pop() / stackTop);
    }

    public void newMultiply() {
    	//CODE HERE
        double stackTop = stack.pop();
        newValueToken(stack.pop() * stackTop);
    }

    // evaluate and reset the calculator
    public void evaluate() {
    	//CODE HERE
        System.out.println("Value = " + stack.pop());
        stack.clear();
    }

}
