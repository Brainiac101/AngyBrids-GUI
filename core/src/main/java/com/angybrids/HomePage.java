package com.angybrids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class HomePage implements Screen {
    final Main game;
    private Texture playButton;
    private Texture background;
    private FitViewport viewport;

    OrthographicCamera camera;

    public HomePage(final Main game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        viewport = new FitViewport(1280, 720, camera);
        background = new Texture(Gdx.files.internal("loading/titleBG.jpeg"));
        playButton = new Texture("play_button.png");
    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
//        Gdx.graphics.setCursor(Cursor.SystemCursor.Arrow);
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float width = viewport.getWorldWidth();
        float height = viewport.getWorldHeight();

        Button play = new Button(playButton, (Gdx.graphics.getWidth() / 2) - (playButton.getWidth() / 2) + 25,
            Gdx.graphics.getHeight() / 2 - playButton.getHeight() / 2 - 150, 0.6f);

        game.batch.begin();
        game.batch.draw(background, 0, 0, width, height);
        // Draw the Play button at the center of the screen
        play.getButtonSprite().draw(game.batch);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            // Convert to OpenGL coordinates
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();
            Rectangle temp = play.getButtonSprite().getBoundingRectangle();
            if (temp.contains(touchX, touchY)) {
                game.setScreen(new Map(game));
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        game.batch.dispose();
        playButton.dispose();
        background.dispose();
    }
}
