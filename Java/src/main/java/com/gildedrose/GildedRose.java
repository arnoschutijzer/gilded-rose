package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .filter(item -> !item.name.equals("Sulfuras, Hand of Ragnaros"))
            .forEach(item -> {
                item.sellIn = item.sellIn - 1;

                int depreciationValueForItem = getDepreciationValueForItem(item);
                item.quality = Math.max(0, Math.min(50, item.quality - depreciationValueForItem));
            });
    }

    private int getDepreciationValueForItem(Item item) {
        if (item.name.contains("Conjured")) {
            return ConjuredItem.depreciationValue(item);
        }

        switch (item.name) {
            case "Backstage passes to a TAFKAL80ETC concert":
                return BackstagePassToATAFKAL80ETCConcert.depreciationValue(item);
            case "Aged Brie":
                return AgedBrie.depreciationValue(item);
            default:
                return RegularItem.depreciationValue(item);
        }
    }
}
