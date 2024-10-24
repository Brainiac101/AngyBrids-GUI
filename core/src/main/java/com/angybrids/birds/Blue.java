package com.angybrids.birds;

import com.badlogic.gdx.graphics.Texture;

public class Blue {
    private Texture image;

    public Blue() {
        this.image = new Texture("birds/blue.png");
    }

    public Texture getImage() {
        return image;
    }
}
