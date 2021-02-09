package ch12_Decorator.test;

import ch12_Decorator.border.FullBorder;
import ch12_Decorator.border.SideBorder;
import ch12_Decorator.display.Display;
import ch12_Decorator.display.MultiStringDisplay;

public class MainSecond {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("早上好。");
        md.add("下午好。");
        md.add("晚安，明天见");
        md.show();

        Display d1 = new SideBorder(md, '#');
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }
}
