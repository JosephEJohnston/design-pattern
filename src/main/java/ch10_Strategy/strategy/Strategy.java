package ch10_Strategy.strategy;

import ch10_Strategy.Hand;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
