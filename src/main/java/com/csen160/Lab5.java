package com.csen160;

import java.util.*;

public class Lab5 {

    // 1. Base class
    static class RecyclableItem {
        protected String type;
        protected double weight;
        protected int score;

        // Constructors
        public RecyclableItem() {
            this("Unknown", 0.0, 0);
        }

        public RecyclableItem(String type, double weight) {
            this(type, weight, 0);
        }

        public RecyclableItem(String type, double weight, int score) {
            this.type = type;
            this.weight = weight;
            this.score = score;
        }

        // TODO: return score * weight
        public double getImpact() {
            return 0; // TODO: implement
        }

        // Helper toString
        public String toString() {
            return type + " (" + weight + "kg, score=" + score + ")";
        }
    }

    // 2. PlasticItem
    static class PlasticItem extends RecyclableItem {
        boolean biodegradable;

        public PlasticItem() {
            this("Plastic", 0.0, 0, false);
        }

        public PlasticItem(String type, double weight, int score, boolean biodegradable) {
            super(type, weight, score);
            this.biodegradable = biodegradable;
        }

        // TODO: add +10 if biodegradable
        public double getImpact() {
            // Example: use super.getImpact() as base
            double base = super.getImpact();
            // TODO: if biodegradable, add 10
            return base;
        }

        public String toString() {
            return super.toString() + " | Biodegradable=" + biodegradable;
        }
    }

    // 3. MetalItem
    static class MetalItem extends RecyclableItem {
        String alloyType;

        public MetalItem() {
            this("Metal", 0.0, 0, "Unknown");
        }

        public MetalItem(String type, double weight, int score, String alloyType) {
            super(type, weight, score);
            this.alloyType = alloyType;
        }

        // TODO: refine getImpact by adding +5
        public double getImpact() {
            // Example: use super.getImpact() as base
            double base = super.getImpact();
            // TODO: add +5 to base
            return base;
        }

        public String toString() {
            return super.toString() + " | Alloy=" + alloyType;
        }
    }

    // 4. Final class with overloading
    public final static class RecyclingStation {
        private String location;
        private double maxCapacity;

        public RecyclingStation() {
            this("Unknown", 0.0);
        }

        public RecyclingStation(String location, double maxCapacity) {
            this.location = location;
            this.maxCapacity = maxCapacity;
        }

        public final void printStationInfo() {
            System.out.println("Station[" + location + ", Capacity=" + maxCapacity + "]");
        }

        // TODO: adjust last formula
        public double calculateProcessingTime(double weight) {
            return weight * 0.5;
        }

        public double calculateProcessingTime(double weight, int workers) {
            return (weight * 0.5) / Math.max(1, workers);
        }

        public double calculateProcessingTime(double weight, int workers, double efficiency) {
            // TODO: use same formula but include efficiency
            return 0; // TODO
        }
    }

    // 5. Bin using ListIterator
    static class Bin {
        private ArrayList<RecyclableItem> items = new ArrayList<>();

        public void addItem(RecyclableItem item) {
            items.add(item);
        }

        public void removeItem(RecyclableItem item) {
            items.remove(item);
        }

        // TODO: calculate total impact
        public double totalImpact() {
            double total = 0;
            // TODO: loop through all items and sum getImpact()
            return total;
        }

        // TODO: use ListIterator to print forward and backward
        public void printItems() {
            ListIterator<RecyclableItem> it = items.listIterator();
            System.out.println("Forward:");
            // TODO: print all items forward
            System.out.println("Backward:");
            // TODO: print all items backward
        }
    }

    // 6. Comparators
    static class WeightComparator implements Comparator<RecyclableItem> {
        public int compare(RecyclableItem a, RecyclableItem b) {
            // TODO: return ascending order by weight
            return 0;
        }
    }

    static class ScoreComparator implements Comparator<RecyclableItem> {
        public int compare(RecyclableItem a, RecyclableItem b) {
            // TODO: return descending order by score
            return 0;
        }
    }

    // 7. Generic method
    public static <E> void printGenericList(List<E> list) {
        // TODO: print each element on a new line
    }
}
