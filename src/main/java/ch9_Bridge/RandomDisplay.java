package ch9_Bridge;

import ch9_Bridge.impl.DisplayImpl;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    private Random random;

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
        this.random = new Random();
    }

    public void randomDisplay(int times) {
        multiDisplay(random.nextInt(times));
    }
}
