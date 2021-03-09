package ch20_Flyweight;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 01110100");
            System.exit(0);
        }

        Runtime.getRuntime().gc();
        BigString bs1 = new BigString(args[0]);
        long used = Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
        bs1.print();
        System.out.println("使用内存 = " + used);


        Runtime.getRuntime().gc();
        BigString bs2 = new BigString(args[0], false);
        used = Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory();
        bs2.print();
        System.out.println("使用内存 = " + used);

    }
}
