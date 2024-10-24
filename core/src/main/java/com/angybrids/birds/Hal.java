package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Hal {
    private Texture image;
    public Hal(){
        this.image = new Texture("birds/hal.png");
    }
    public Texture getImage() {
        return image;
    }
}
