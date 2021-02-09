package ch12_Decorator.display;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    private List<String> list;

    public MultiStringDisplay() {
        this.list = new ArrayList<>();
    }

    @Override
    public int getColumns() {
        return list.stream()
                .map(s -> s.getBytes(StandardCharsets.UTF_8).length)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Override
    public int getRows() {
        return list.size();
    }

    @Override
    public String getRowText(int row) {
        if (row < list.size())
            return list.get(row);
        return null;
    }

    public void add(String str) {
        list.add(str);
    }
}
