package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Bomb {
    private Texture image;
    public Bomb(){
        this.image = new Texture("birds/bomb.png");
    }
    public Texture getImage() {
        return image;
    }
}
