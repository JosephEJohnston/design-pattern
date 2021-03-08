package ch17_Observer.generator;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int current;
    private final int end;
    private final int step;

    public IncrementalNumberGenerator(int start, int end, int step) {
        this.current = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return current;
    }

    @Override
    public void execute() {
        while (current < end) {
            notifyObservers();
            current += step;
        }
    }
}
