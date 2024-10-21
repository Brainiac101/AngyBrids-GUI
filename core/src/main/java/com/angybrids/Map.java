package com.angybrids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

public class Map implements Screen {
    final Main game;

    private Texture settingImage;
    private Texture shopImage;
    private Texture birdImage;
    private Texture backImage;
    private Texture quitImage;
    private Texture saveImage;

    private Texture mapTitle;
    private Texture background;

    private ShapeRenderer shapeRenderer;
    private FitViewport viewport;
    private BitmapFont font;
    private boolean visibility;

    public Map(Main game) {
        this.game = game;
        viewport = new FitViewport(1280, 720);

        settingImage = new Texture("icons/settingIcon.png");
        birdImage = new Texture("icons/birdIcon.png");
        shopImage = new Texture("icons/shopIcon.png");
        backImage = new Texture("icons/homeIcon.png");
        mapTitle = new Texture("map/mapTitle.png");
        background = new Texture("map/mapBG.jpg");
        quitImage = new Texture("icons/exitIcon.png");
        saveImage = new Texture("icons/saveIcon.png");

        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        font.getData().setScale(3.5f);
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

        Button settingButton = new Button(settingImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 - 65,
            Gdx.graphics.getHeight() - settingImage.getHeight() / 2 - 60, 0.7f);
        Button shopButton = new Button(shopImage, Gdx.graphics.getWidth() - (shopImage.getWidth() / 2) - 75,
            shopImage.getHeight() / 2, 1.5f);
        Button birdButton = new Button(birdImage, birdImage.getWidth() / 2 + 25,
            birdImage.getHeight() / 2, 1.6f);
        Button backButton = new Button(backImage, backImage.getWidth() / 2 + 25,
            Gdx.graphics.getHeight() - backImage.getHeight() / 2 - 65, 1.6f);
        Button quitButton = new Button(quitImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 -35 ,
            Gdx.graphics.getHeight() - 3 * settingImage.getHeight() / 2 -5, 1.2f);
        Button saveButton = new Button(saveImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 -35,
            Gdx.graphics.getHeight() - 3 * settingImage.getHeight() / 2 - 25 - quitImage.getHeight(), 1.2f);
        game.batch.begin();

        //Map background
        game.batch.draw(background, 0, 0, width, height);
        //Map title
        game.batch.draw(mapTitle, Gdx.graphics.getWidth() / 2 - 115, Gdx.graphics.getHeight() - 125, 7 * mapTitle.getWidth() / 5, 7 * mapTitle.getHeight() / 5);
        //Setting Icon
        settingButton.getButtonSprite().draw(game.batch);
        //Shop Icon
        shopButton.getButtonSprite().draw(game.batch);
        //Bird Icon
        birdButton.getButtonSprite().draw(game.batch);
        //Back Icon
        backButton.getButtonSprite().draw(game.batch);
        if (visibility) {
            quitButton.getButtonSprite().draw(game.batch);
            saveButton.getButtonSprite().draw(game.batch);
        }
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        font.setColor(Color.WHITE);
        int x = 240;
        int y = 375;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                shapeRenderer.rect(x, y, 200, 150);
                x += 300;
            }
            x = 240;
            y -= 250;
        }
        game.batch.end();
        shapeRenderer.end();
        game.batch.begin();
        x = 230;
        y = 400;
        int level = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                font.draw(game.batch, Integer.toString(level), x + 100, y + 75);
                x += 300;
                level++;
            }
            x = 230;
            y -= 250;
        }
        game.batch.end();
        if (Gdx.input.justTouched()) {
            // Convert to OpenGL coordinates
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if (settingButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                if (visibility) {
                    visibility = false;
                } else {
                    visibility = true;
                }
            } else {
                visibility = false;
                if (backButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    game.setScreen(new HomePage(game));
                } else if (birdButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    game.setScreen(new BirdPage(game));
                } else if (shopButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    game.setScreen(new ShopPage(game));
                }
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
        game.batch.dispose();
        settingImage.dispose();
        birdImage.dispose();
        shopImage.dispose();
        backImage.dispose();
        mapTitle.dispose();
        background.dispose();
        font.dispose();
    }
}
