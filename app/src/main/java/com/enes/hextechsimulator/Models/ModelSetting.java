package com.enes.hextechsimulator.Models;

public class ModelSetting {
    private String title;
    private String desc;
    private boolean switchEnabled;
    private int iconRef;
    private int iconColorRef;

    public ModelSetting(String title, String desc, boolean switchEnabled, int iconRef, int iconColorRef) {
        this.title = title;
        this.desc = desc;
        this.switchEnabled = switchEnabled;
        this.iconRef = iconRef;
        this.iconColorRef = iconColorRef;
    }

    public ModelSetting(String title, String desc, boolean switchEnabled, int iconRef) {
        this.title = title;
        this.desc = desc;
        this.switchEnabled = switchEnabled;
        this.iconRef = iconRef;
        this.iconColorRef = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isSwitchEnabled() {
        return switchEnabled;
    }

    public int getIconRef() {
        return iconRef;
    }

    public int getIconColorRef() {
        return iconColorRef;
    }
}
