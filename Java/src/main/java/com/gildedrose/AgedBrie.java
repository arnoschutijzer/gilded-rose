package com.gildedrose;

public class AgedBrie extends RegularItem implements Depreciable {
    AgedBrie(int quality, int sellIn) {
        super("Aged Brie", quality, sellIn);
    }

    @Override
    public int depreciationValue() {
        if (super.getQuality() == 50) {
            return 0;
        }
        if (super.getSellIn() < 0) {
            return -2;
        }
        return -1;
    }
}
