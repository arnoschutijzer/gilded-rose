package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateQualityForBackstagePassesToATAFKAL80ETCConcert(Item item) {
        item.quality = item.quality + 1;
        if (item.sellIn < 11) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 6) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;
        if (item.sellIn <= 0) {
            item.quality = 0;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }

        capQualityTo50(item);
    }

    private void updateQualityForAgedBrie(Item item) {
        item.quality = item.quality + 1;
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }

        capQualityTo50(item);
    }

    private void updateQualityForANormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void capQualityTo50(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    return;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateQualityForBackstagePassesToATAFKAL80ETCConcert(items[i]);
                    return;
                case "Aged Brie":
                    updateQualityForAgedBrie(items[i]);
                    return;
                default:
                    updateQualityForANormalItem(items[i]);
                    return;
            }

        }
    }
}
