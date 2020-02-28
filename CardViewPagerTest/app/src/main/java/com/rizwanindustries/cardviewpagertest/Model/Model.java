package com.rizwanindustries.cardviewpagertest.Model;

import android.widget.ImageView;

public class Model {

    private int image;
    private String tittle;
    private String desc;

    public Model(int image, String tittle, String desc) {
        this.image = image;
        this.tittle = tittle;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
