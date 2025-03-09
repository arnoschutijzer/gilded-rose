package com.gildedrose;

public class ConjuredItem {
    ConjuredItem() {
    }

    public static int depreciationValue(Item item) {
        return RegularItem.depreciationValue(item) * 2;
    }
}
