package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Matilda {
    private Texture image;
    public Matilda(){
        this.image = new Texture("birds/matilda.png");
    }
    public Texture getImage() {
        return image;
    }
}
