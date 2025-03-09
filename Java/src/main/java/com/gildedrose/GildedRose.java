package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Depreciable[] items;

    public GildedRose(Depreciable[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .filter(item -> !item.getName().equals("Sulfuras, Hand of Ragnaros"))
            .forEach(Depreciable::adjustQuality);
    }
}
