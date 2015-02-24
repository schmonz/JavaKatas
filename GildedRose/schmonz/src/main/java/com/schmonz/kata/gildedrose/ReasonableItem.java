package com.schmonz.kata.gildedrose;

public class ReasonableItem extends Item {
    public ReasonableItem(String name, int sellIn, int quality) {
    	super(name, sellIn, quality);
    }
    
    public ReasonableItem(Item unreasonableItem) {
    	super(unreasonableItem.name, unreasonableItem.sellIn, unreasonableItem.quality);
    }
}