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

    private void capQualityTo50(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateQualityForBackstagePassesToATAFKAL80ETCConcert(items[i]);
                return;
            }

            if (items[i].name.equals("Aged Brie")) {
                updateQualityForAgedBrie(items[i]);
                return;
            }

            if (items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }

            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].sellIn < 0 && items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }
}
