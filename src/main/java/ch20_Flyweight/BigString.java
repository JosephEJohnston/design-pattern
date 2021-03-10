package ch20_Flyweight;

public class BigString {
    private final BigChar[] bigChars;

    public BigString(String string) {
        this(string, true);
    }

    public BigString(String string, boolean shared) {
        bigChars = new BigChar[string.length()];
        if (shared) {
            BigCharFactory factory = BigCharFactory.getInstance();
            for (int i = 0; i < bigChars.length; i++) {
                bigChars[i] = factory.getBigChar(string.charAt(i));
            }
        } else {
            for (int i = 0; i < bigChars.length; i++) {
                bigChars[i] = new BigChar(string.charAt(i));
            }
        }
    }

    public void print() {
        for (BigChar bigChar : bigChars) {
            bigChar.print();
        }
    }
}
