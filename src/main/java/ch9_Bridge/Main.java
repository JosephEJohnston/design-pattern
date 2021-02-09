package ch9_Bridge;

import ch9_Bridge.impl.CharDisplayImpl;
import ch9_Bridge.impl.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        /*Display d1 = new Display(new StringDisplayImpl("Hello, China."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);*/

        TowerDisplay d = new TowerDisplay(new CharDisplayImpl('|', '-', "##"));
        d.towerDisplay(6);
    }
}
