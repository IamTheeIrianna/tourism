package com.example.tourism.model;

public class Tag {
    private int tagID;
    private String tagName;

    public Tag(){}

    public Tag(int tagID, String tagName) {
        this.tagID = tagID;
        this.tagName = tagName;
    }

    public int getTagID() {
        return tagID;
    }
    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{tagID=" + tagID + ", tagName='" + tagName + "'}";
    }
}
