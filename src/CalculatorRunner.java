
public class CalculatorRunner {

    public static void main(String[] args) throws Exception {
    	System.out.println("-----------------\n [Stack Calculator] -Postfix notation- \n-----------------");
        Calculator calc = new Calculator();

        char c;
        while ((c = (char) System.in.read()) != 0) {
            calc.getToken(c);
        }
    }

}
