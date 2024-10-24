package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Terence {
    private Texture image;
    public Terence(){
        this.image = new Texture("birds/terence.png");
    }
    public Texture getImage() {
        return image;
    }
}
