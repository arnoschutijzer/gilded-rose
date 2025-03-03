package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItemDegradesInQualityAndSellIn() {
        Item[] items = new Item[]{new Item("A normal item", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("A normal item", 9, 9), app.items[0]);
    }

    @Test
    void normalItemDegradesTwiceAsFastInQualityWhenSellInIsNegative() {
        Item[] items = new Item[]{new Item("A normal item", 0, 9)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("A normal item", -1, 7), app.items[0]);
    }

    @Test
    void agedBrieDepreciatesInSellInAndGoesUpInQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Aged Brie", -1, 2), app.items[0]);
    }

    @Test
    void agedBrieAfterSellInGoesUpInQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Aged Brie", -2, 4), app.items[0]);
    }

    @Test
    void agedBrieAfterSellInGoesUpInQualityUntil50() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 2)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertItemsAreEqual(new Item("Aged Brie", -51, 50), app.items[0]);
    }

    @Test
    void sulfurasHandOfRagnarosRemainsUnchanged() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Sulfuras, Hand of Ragnaros", 2, 80), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy1IfSellInIsLargerThan10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy2IfSellInIsLessThanOrEqualTo10AndLargerThan5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy3IfSellInIsLessThanOrEqualTo5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 3), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertQualityRemains0AfterConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0), app.items[0]);
        app.updateQuality();
        assertItemsAreEqual(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0), app.items[0]);
    }

    private void assertItemsAreEqual(Item item1, Item item2) {
        assertEquals(item1.name, item2.name);
        assertEquals(item1.quality, item2.quality);
        assertEquals(item1.sellIn, item2.sellIn);
    }

}
