package com.angybrids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class BirdPage implements Screen {
    final Main game;
    private FitViewport viewport;
    private boolean visibility;

    private Texture background;
    private Texture title;

    private Texture mapImage;
    private Texture homeImage;
    private Texture settingImage;
    private Texture shopImage;
    private Texture quitImage;
    private Texture saveImage;

    private Texture red;
    private Texture chuck;
    private Texture bomb;
    private Texture matilda;
    private Texture blue;
    private Texture hal;
    private Texture terence;

    public BirdPage(Main game) {
        this.game = game;
        this.viewport = new FitViewport(1280, 720);

        this.background = new Texture("birdPage/birdBG.png");
        this.title = new Texture("birdPage/title.png");
        this.mapImage = new Texture("icons/mapIcon.png");
        this.homeImage = new Texture("icons/homeIcon.png");
        this.settingImage = new Texture("icons/settingIcon.png");
        this.shopImage = new Texture("icons/shopIcon.png");
        this.quitImage = new Texture("icons/exitIcon.png");
        this.saveImage = new Texture("icons/saveIcon.png");

        this.red = new Texture("birds/red.png");
        this.chuck = new Texture("birds/chuck.png");
        this.bomb = new Texture("birds/bomb.png");
        this.terence = new Texture("birds/terence.png");
        this.blue = new Texture("birds/blue.png");
        this.hal = new Texture("birds/hal.png");
        this.matilda = new Texture("birds/matilda.png");
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

        Button homeButton = new Button(homeImage, homeImage.getWidth() / 2 + 25,
            Gdx.graphics.getHeight() - homeImage.getHeight() / 2 - 65, 1.6f);
        Button mapButton = new Button(mapImage, mapImage.getWidth() / 2 + 25,
            mapImage.getHeight() / 2, 1.6f);
        Button settingButton = new Button(settingImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 - 65,
            Gdx.graphics.getHeight() - settingImage.getHeight() / 2 - 60, 0.7f);
        Button shopButton = new Button(shopImage, Gdx.graphics.getWidth() - (shopImage.getWidth() / 2) - 75,
            shopImage.getHeight() / 2, 1.5f);
        Button quitButton = new Button(quitImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 -35 ,
            Gdx.graphics.getHeight() - 3 * settingImage.getHeight() / 2 -5, 1.2f);
        Button saveButton = new Button(saveImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 -35,
            Gdx.graphics.getHeight() - 3 * settingImage.getHeight() / 2 - 25 - quitImage.getHeight(), 1.2f);
        game.batch.begin();
        game.batch.draw(background, 0, 0, width, height);
        //Home Icon
        homeButton.getButtonSprite().draw(game.batch);
        //Map Icon
        mapButton.getButtonSprite().draw(game.batch);
        //Setting Icon
        settingButton.getButtonSprite().draw(game.batch);
        //Shop Icon
        shopButton.getButtonSprite().draw(game.batch);
        game.batch.draw(title, Gdx.graphics.getWidth() / 2 - 180, 590, 3 * title.getWidth() / 2, 3 * title.getHeight() / 2);
        game.batch.draw(red, 200, 320);
        game.batch.draw(chuck, 450, 320);
        game.batch.draw(bomb, 700, 320);
        game.batch.draw(blue, 950, 320);
        game.batch.draw(terence, 225, 50, 7 * terence.getWidth() / 5, 7 * terence.getHeight() / 5);
//        game.batch.draw(matilda, 570, 50, 4 * matilda.getWidth() / 5, 4 * matilda.getHeight() / 5);
        game.batch.draw(matilda, 550, 50, matilda.getWidth(), matilda.getHeight());
        game.batch.draw(hal, 800, 50, 3 * hal.getWidth() / 2, 3 * hal.getHeight() / 2);
        if(visibility){
            quitButton.getButtonSprite().draw(game.batch);
            saveButton.getButtonSprite().draw(game.batch);
        }
        game.batch.end();

        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(settingButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                if(visibility){
                    visibility=false;
                }
                else{
                    visibility=true;
                }
            }
            if (homeButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                game.setScreen(new HomePage(game));
            } else if (mapButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                game.setScreen(new Map(game));
            } else if (shopButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                game.setScreen(new ShopPage(game));
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

    }
}
