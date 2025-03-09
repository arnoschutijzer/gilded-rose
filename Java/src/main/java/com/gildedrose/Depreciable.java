package com.gildedrose;

public interface Depreciable {
    void adjustQuality();

    void adjustSellIn();

    int depreciationValue();

    int getSellIn();

    int getQuality();

    String getName();
}
