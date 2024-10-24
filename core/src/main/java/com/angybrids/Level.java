package com.angybrids;

import com.angybrids.Button;
import com.angybrids.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Level implements Screen {
    final Main game;
    private int level;
    private Texture background;
    private FitViewport viewport;

    public Level(int level,Main game) {
        viewport = new FitViewport(1280, 720);
        if(level%3==1){
            background = new Texture("levelAssets/bg3.jpeg");
        }
        else if(level%3==0){
            background = new Texture("levelAssets/bg2.jpeg");
        }
        else{
            background = new Texture("levelAssets/bg1.jpeg");
        }
        this.game=game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float width = viewport.getWorldWidth();
        float height = viewport.getWorldHeight();

        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
