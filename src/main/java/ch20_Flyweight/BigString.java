package ch20_Flyweight;

public class BigString {
    private final BigChar[] bigChars;

    public BigString(String string, boolean shared) {
        bigChars = new BigChar[string.length()];
        if (shared) {
            updateSharedBigChars(bigChars, string);
        } else {
            for (int i = 0; i < bigChars.length; i++) {
                bigChars[i] = new BigChar(string.charAt(i));
            }
        }
    }

    public BigString(String string) {
        bigChars = new BigChar[string.length()];
        updateSharedBigChars(bigChars, string);
    }

    public void print() {
        for (BigChar bigChar : bigChars) {
            bigChar.print();
        }
    }

    private void updateSharedBigChars(BigChar[] bigChars, String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }
}
