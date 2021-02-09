package ch7_Builder;

public class TextBuilder implements Builder {
    private StringBuffer buffer = new StringBuffer();
    @Override
    public void makeTitle(String title) {
        buffer.append("========================\n");
        buffer.append("[").append(title).append("]\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append('#').append(str).append("\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            buffer.append("·").append(item).append("\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("========================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
