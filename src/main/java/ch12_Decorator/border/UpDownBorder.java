package ch12_Decorator.border;

import ch12_Decorator.display.Display;

public class UpDownBorder extends Border {
    private char borderChar;

    public UpDownBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1) {
            return makeLine(borderChar, display.getColumns());
        } else {
            return display.getRowText(row - 1);
        }
    }

    private String makeLine(char borderChar, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(borderChar);
        }
        return builder.toString();
    }
}
