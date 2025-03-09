package com.gildedrose;

public class ConjuredItem extends RegularItem implements Depreciable {
    ConjuredItem(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    public int depreciationValue() {
        return super.depreciationValue() * 2;
    }
}
