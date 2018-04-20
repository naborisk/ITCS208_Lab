// Tussoun Jitpanyoyos #6088030 Section 1

public class ToH3 {

    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();
    private static Stack<Integer> s3 = new Stack<>();
    private static int numRounds = 1;

    public static void main(String[] args){

        s1.push(3);
        s1.push(2);
        s1.push(1);

        printToH();

        s3.push(s1.pop());

        printToH();

        s2.push(s1.pop());

        printToH();

        s2.push(s3.pop());

        printToH();

        s3.push(s1.pop());

        printToH();

        s1.push(s2.pop());

        printToH();

        s3.push(s2.pop());

        printToH();

       s3.push(s1.pop());

        printToH();

        System.out.println("Total Steps: " + (numRounds - 2 ));

    }

    private static void printToH(){

        System.out.println("==== " + numRounds + " ====");


        for(int i = 2; i>=0; i--) {
            if(i>s1.size()-1) {
                System.out.print("| "+"| ");
            }
            else System.out.print("|"+s1.get(i)+"| ");
            if(i>s2.size()-1) {
                System.out.print("| "+"| ");
            }
            else System.out.print("|"+s2.get(i)+"| ");
            if(i>s3.size()-1) {
                System.out.print("| "+"| ");
            }
            else System.out.print("|"+s3.get(i)+"| ");
            System.out.println();
        }

        System.out.println("===========");
        numRounds++;

    }
}
