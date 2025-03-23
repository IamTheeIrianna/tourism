package com.example.tourism.model;

public class TouristTag {
    private int attractionID;
    private int tagID;

    public TouristTag(int attractionID, int tagID) {
        this.attractionID = attractionID;
        this.tagID = tagID;
    }

    public int getAttractionID() {
        return attractionID;
    }

    public int getTagID() {
        return tagID;
    }

    @Override
    public String toString() {
        return "TouristTag{attractionID=" + attractionID + ", tagID=" + tagID + "}";
    }
}

