package ch12_Decorator.border;

import ch12_Decorator.display.Display;

public abstract class Border extends Display {
    protected Display display;
    protected Border(Display display) {
        this.display = display;
    }
}
