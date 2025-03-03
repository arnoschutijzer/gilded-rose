package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void agedBrieDepreciatesInSellInAndGoesUpInQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(areItemsEqual(new Item("Aged Brie", -1, 2), app.items[0]));
    }

    @Test
    void agedBrieAfterSellInGoesUpInQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(areItemsEqual(new Item("Aged Brie", -2, 4), app.items[0]));
    }

    @Test
    void agedBrieAfterSellInGoesUpInQualityUntil50() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 2)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertTrue(areItemsEqual(new Item("Aged Brie", -51, 50), app.items[0]));
    }

    @Test
    void sulfurasHandOfRagnarosRemainsUnchanged() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(areItemsEqual(new Item("Sulfuras, Hand of Ragnaros", 2, 80), app.items[0]));
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy1IfSellInIsLargerThan10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(areItemsEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1), app.items[0]));
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy2IfSellInIsLessThanOrEqualTo10AndLargerThan5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(areItemsEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2), app.items[0]));
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy3IfSellInIsLessThanOrEqualTo5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(areItemsEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 3), app.items[0]));
    }

    // Since we can't add an Equals/Hashcode to the Item class
    private boolean areItemsEqual(Item item1, Item item2) {
        return
            Objects.equals(item1.name, item2.name) &&
                item1.quality == item2.quality &&
                item1.sellIn == item2.sellIn;
    }

}
