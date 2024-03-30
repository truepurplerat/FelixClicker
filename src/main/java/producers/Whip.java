package producers;

public class Whip extends Producer {
    @Override
    public int getfactor() {
        return 10;
    }

    @Override
    public long getprice() {
        return 5;
    }
}
