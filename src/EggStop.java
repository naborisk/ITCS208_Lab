public class EggStop {
    public static void main(String[] args){
        printEgg();
        printEgg();
        printLine();
        printEggWithStop();
        printLine();
    }

    public static void printEgg() {
        printEggTop();
        printEggBottom();
    }

    public static void printEggTop(){
        System.out.println("  ______");
        System.out.println(" /      \\");
        System.out.println("/        \\");
    }

    public static void printEggBottom(){
        System.out.println("\\        /");
        System.out.println(" \\______/");

    }

    public static void printLine(){
        System.out.println("+--------+");
    }

    public static void printEggWithStop(){
        printEggTop();
        System.out.println("|  STOP  |");
        printEggBottom();
    }
}
