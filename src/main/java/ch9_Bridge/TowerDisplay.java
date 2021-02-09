package ch9_Bridge;

import ch9_Bridge.impl.DisplayImpl;

public class TowerDisplay extends Display {
    public TowerDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void towerDisplay(int row) {
        for (int i = 0; i < row; i++) {
            open();
            for (int j = 0; j < i; j++) {
                print();
            }
            close();
        }
    }
}
