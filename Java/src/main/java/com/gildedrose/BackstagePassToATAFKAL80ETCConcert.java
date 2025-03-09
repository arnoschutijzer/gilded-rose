package com.gildedrose;

public class BackstagePassToATAFKAL80ETCConcert extends RegularItem implements Depreciable {
    BackstagePassToATAFKAL80ETCConcert(int quality, int sellIn) {
        super("Backstage passes to a TAFKAL80ETC concert", quality, sellIn);
    }

    @Override
    public int depreciationValue() {
        int sellIn = this.getSellIn();
        int quality = getQuality();

        if (quality == 50) {
            return 0;
        }
        if (sellIn <= 0) {
            return quality;
        }
        if (sellIn < 5) {
            return -3;
        }
        if (sellIn < 10) {
            return -2;
        }
        return -1;
    }
}
