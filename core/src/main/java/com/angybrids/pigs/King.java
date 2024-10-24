package com.angybrids.pigs;

import com.badlogic.gdx.graphics.Texture;

public class King {
    private Texture image;
    public King(){
        this.image = new Texture("pigs/kingpig.png");
    }
    public Texture getImage() {
        return image;
    }
}
