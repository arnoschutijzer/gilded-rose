package com.gildedrose;

public class RegularItem implements Depreciable {
    private final String name;
    private int quality;
    private int sellIn;

    RegularItem(String name, int quality, int sellIn) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    @Override
    public void adjustQuality() {
        adjustSellIn();
        this.quality = Math.max(0, Math.min(50, quality - depreciationValue()));
    }

    @Override
    public void adjustSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    public int depreciationValue() {
        if (sellIn < 0 && quality > 0) {
            return 2;
        }

        return 1;
    }
}
