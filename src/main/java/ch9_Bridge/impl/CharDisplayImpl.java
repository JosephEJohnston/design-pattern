package ch9_Bridge.impl;

public class CharDisplayImpl extends DisplayImpl {
    private char start;
    private char end;
    private String dec;

    public CharDisplayImpl(char start, char end, String dec) {
        this.start = start;
        this.end = end;
        this.dec = dec;
    }

    @Override
    public void rawOpen() {
        System.out.print(start);
    }

    @Override
    public void rawPrint() {
        System.out.print(dec);
    }

    @Override
    public void rawClose() {
        System.out.println(end);
    }
}
