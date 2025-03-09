package com.gildedrose;

public class SulfurasHandOfRagnaros implements Depreciable {
    private final int quality;
    private final int sellIn;

    SulfurasHandOfRagnaros(int quality, int sellIn) {
        this.quality = quality;
        this.sellIn = sellIn;
    }

    @Override
    public void adjustQuality() {
        // Sulfuras does not degrade.
    }

    @Override
    public void adjustSellIn() {
        // Sulfuras does not expire.
    }

    @Override
    public int depreciationValue() {
        return 0;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public String getName() {
        return "Sulfuras, Hand of Ragnaros";
    }
}
