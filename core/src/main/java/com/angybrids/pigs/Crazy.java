package com.angybrids.pigs;

import com.badlogic.gdx.graphics.Texture;

public class Crazy {
    private Texture image;
    public Crazy(){
        this.image = new Texture("pigs/crazyPig.png");
    }
    public Texture getImage() {
        return image;
    }
}
