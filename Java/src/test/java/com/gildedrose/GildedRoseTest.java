package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItemDegradesInQualityAndSellIn() {
        Depreciable[] items = new Depreciable[]{new RegularItem("A normal item", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new RegularItem("A normal item", 9, 9), app.items[0]);
    }

    @Test
    void normalItemDegradesTwiceAsFastInQualityWhenSellInIsNegative() {
        Depreciable[] items = new Depreciable[]{new RegularItem("A normal item", 9, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new RegularItem("A normal item", 7, -1), app.items[0]);
    }

    @Test
    void normalItemQualityCanNeverBeNegative() {
        Depreciable[] items = new Depreciable[]{new RegularItem("A normal item", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new RegularItem("A normal item", 0, -1), app.items[0]);
        app.updateQuality();
        assertItemsAreEqual(new RegularItem("A normal item", 0, -2), app.items[0]);
    }

    @Test
    void agedBrieDepreciatesInSellInAndGoesUpInQuality() {
        Depreciable[] items = new Depreciable[]{new AgedBrie(0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new AgedBrie(2, -1), app.items[0]);
    }

    @Test
    void agedBrieAfterSellInGoesUpInQuality() {
        Depreciable[] items = new Depreciable[]{new AgedBrie(2, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new AgedBrie(4, -2), app.items[0]);
    }

    @Test
    void agedBrieAfterSellInGoesUpInQualityUntil50() {
        Depreciable[] items = new Depreciable[]{new AgedBrie(2, -1)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertItemsAreEqual(new AgedBrie(50, -51), app.items[0]);
    }

    @Test
    void sulfurasHandOfRagnarosRemainsUnchanged() {
        Depreciable[] items = new Depreciable[]{new SulfurasHandOfRagnaros(80, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new SulfurasHandOfRagnaros(80, 2), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy1IfSellInIsLargerThan10() {
        Depreciable[] items = new Depreciable[]{new BackstagePassToATAFKAL80ETCConcert(0, 11)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(1, 10), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy2IfSellInIsLessThanOrEqualTo10AndLargerThan5() {
        Depreciable[] items = new Depreciable[]{new BackstagePassToATAFKAL80ETCConcert(0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(2, 9), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertIncreasesQualityBy3IfSellInIsLessThanOrEqualTo5() {
        Depreciable[] items = new Depreciable[]{new BackstagePassToATAFKAL80ETCConcert(0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(3, 4), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertQualityRemains0AfterConcert() {
        Depreciable[] items = new Depreciable[]{new BackstagePassToATAFKAL80ETCConcert(0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(0, 0), app.items[0]);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(0, -1), app.items[0]);
    }

    @Test
    void backstagePassesToTAFKAL80ETCConcertQualityCannotBeGreaterThan50() {
        Depreciable[] items = new Depreciable[]{new BackstagePassToATAFKAL80ETCConcert(48, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(50, 4), app.items[0]);
        app.updateQuality();
        assertItemsAreEqual(new BackstagePassToATAFKAL80ETCConcert(50, 3), app.items[0]);
    }

    @Test
    void conjuredItemDepreciatesTwiceAsFastAsARegularItem() {
        Depreciable[] items = new Depreciable[]{new ConjuredItem("Conjured Blade", 10, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemsAreEqual(new ConjuredItem("Conjured Blade", 8, 1), app.items[0]);
        app.updateQuality();
        assertItemsAreEqual(new ConjuredItem("Conjured Blade", 6, 0), app.items[0]);
        app.updateQuality();
        assertItemsAreEqual(new ConjuredItem("Conjured Blade", 2, -1), app.items[0]);
    }

    private void assertItemsAreEqual(Depreciable item1, Depreciable item2) {
        assertEquals(item1.getName(), item2.getName());
        assertEquals(item1.getQuality(), item2.getQuality());
        assertEquals(item1.getSellIn(), item2.getSellIn());
    }

}
