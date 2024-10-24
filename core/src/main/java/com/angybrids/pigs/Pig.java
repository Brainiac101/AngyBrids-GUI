package com.angybrids.pigs;

import com.badlogic.gdx.graphics.Texture;

public class Pig {
    private Texture image;
    public Pig(){
        this.image = new Texture("pigs/pig.png");
    }
    public Texture getImage() {
        return image;
    }
}
