package com.csen160;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTest {

    @Test
    void testRecyclableItem() {
        // Test constructor chaining and getImpact()
        Lab5.RecyclableItem r = new Lab5.RecyclableItem("Glass", 2.0, 50);
        System.out.println("Testing RecyclableItem: " + r);
        double result = r.getImpact();
        assertTrue(result == 100.0);  // 50 * 2 = 100
    }

    @Test
    void testPlasticItemImpact() {
        Lab5.PlasticItem bio = new Lab5.PlasticItem("Plastic", 2.0, 40, true);
        Lab5.PlasticItem non = new Lab5.PlasticItem("Plastic", 2.0, 40, false);

        System.out.println("Biodegradable Impact: " + bio.getImpact());
        System.out.println("Non-biodegradable Impact: " + non.getImpact());

        // biodegradable item should have higher impact
        assertTrue(bio.getImpact() > non.getImpact());
    }

    @Test
    void testMetalItemImpact() {
        Lab5.MetalItem m = new Lab5.MetalItem("Metal", 2.0, 30, "Steel");
        System.out.println("Metal item impact: " + m.getImpact());
        // It should be base impact (60) + 5 = 65
        assertTrue(m.getImpact() == 65.0);
    }

    @Test
    void testRecyclingStationOverloads() {
        Lab5.RecyclingStation s = new Lab5.RecyclingStation("Central", 500);
        s.printStationInfo();

        double t1 = s.calculateProcessingTime(100);
        double t2 = s.calculateProcessingTime(100, 2);
        double t3 = s.calculateProcessingTime(100, 2, 2);

        System.out.println("Times: " + t1 + " / " + t2 + " / " + t3);
        assertTrue(t1 > t2 && t2 > t3);
    }

    @Test
    void testBinAndListIterator() {
        Lab5.Bin bin = new Lab5.Bin();
        bin.addItem(new Lab5.RecyclableItem("Paper", 2.0, 30));
        bin.addItem(new Lab5.RecyclableItem("Metal", 1.0, 50));

        System.out.println("Printing Bin items with ListIterator:");
        bin.printItems();

        double total = bin.totalImpact();
        System.out.println("Total impact = " + total);
        assertTrue(total > 0);
    }

    @Test
    void testWeightComparator() {
        ArrayList<Lab5.RecyclableItem> list = new ArrayList<>();
        list.add(new Lab5.RecyclableItem("Heavy", 5.0, 10));
        list.add(new Lab5.RecyclableItem("Light", 1.0, 10));

        list.sort(new Lab5.WeightComparator());
        System.out.println("After sorting by weight:");
        for (Lab5.RecyclableItem r : list) {
            System.out.println(r);
        }

        assertEquals("Light", list.get(0).type);
    }

    @Test
    void testScoreComparator() {
        ArrayList<Lab5.RecyclableItem> list = new ArrayList<>();
        list.add(new Lab5.RecyclableItem("Low", 2.0, 10));
        list.add(new Lab5.RecyclableItem("High", 2.0, 90));

        list.sort(new Lab5.ScoreComparator());
        System.out.println("After sorting by score:");
        for (Lab5.RecyclableItem r : list) {
            System.out.println(r);
        }

        assertEquals("High", list.get(0).type);
    }

    @Test
    void testGenericPrintMethod() {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Fish");

        System.out.println("Testing printGenericList with String list:");
        Lab5.printGenericList(animals);

        // It should not throw an error
        assertDoesNotThrow(() -> Lab5.printGenericList(animals));
    }
}
