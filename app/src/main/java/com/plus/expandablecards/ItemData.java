package com.plus.expandablecards;

public class ItemData {

    private String title;
    private String desc;
    private boolean expanded;

    public ItemData(String title, String desc) {
        this.title = title;
        this.desc = desc;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
