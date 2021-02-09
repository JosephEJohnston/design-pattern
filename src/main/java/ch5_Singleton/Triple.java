package ch5_Singleton;

public class Triple {
    private static Triple[] triples = new Triple[3];
    private Triple() {

    }

    public synchronized static Triple getInstance(int id) {
        if (id < 3) {
            if (triples[id] == null)
                triples[id] = new Triple();
            return triples[id];
        } else {
            throw new IndexOutOfBoundsException("id 超过了索引范围");
        }
    }

    public static void main(String[] args) {
        System.out.println(Triple.getInstance(0));
        System.out.println(Triple.getInstance(1));
        System.out.println(Triple.getInstance(2));
        System.out.println(Triple.getInstance(0));
        System.out.println(Triple.getInstance(1));
        System.out.println(Triple.getInstance(2));
    }
}
