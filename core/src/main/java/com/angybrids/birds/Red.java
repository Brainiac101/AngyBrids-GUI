package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Red {
    private Texture image;
    public Red(){
        this.image = new Texture("birds/red.png");
    }
    public Texture getImage() {
        return image;
    }
}
