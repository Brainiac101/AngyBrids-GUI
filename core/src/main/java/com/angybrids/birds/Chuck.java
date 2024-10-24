package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Chuck {
    private Texture image;
    public Chuck(){
        this.image = new Texture("birds/chuck.png");
    }
    public Texture getImage() {
        return image;
    }
}
