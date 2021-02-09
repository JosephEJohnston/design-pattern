package ch10_Strategy.strategy;

import ch10_Strategy.Hand;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(Hand.hand.length));
    }

    @Override
    public void study(boolean win) {

    }
}
