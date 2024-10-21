package com.angybrids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class ShopPage implements Screen {
    final Main game;
    private FitViewport viewport;
    private Texture background;
    private Texture title;
    private boolean visibility;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    
    private Texture mapImage;
    private Texture homeImage;
    private Texture birdImage;
    private Texture settingImage;
    private Texture quitImage;
    private Texture saveImage;

    private Texture eagleImage;
    private Texture powershotImage;
    private Texture superchargeImage;
    private Texture birdquakeImage;
    private Texture potionImage;
    private int coins;

    public ShopPage(Main game) {
        this.game = game;
        viewport = new FitViewport(1280, 720);
        this.background = new Texture("shop.jpeg");
        this.title = new Texture("shopTitle.png");
        shapeRenderer = new ShapeRenderer();
        this.font = new BitmapFont();
        font.getData().setScale(1.5f);
        this.mapImage = new Texture("icons/mapIcon.png");
        this.settingImage = new Texture("icons/settingIcon.png");
        this.homeImage = new Texture("icons/homeIcon.png");
        this.birdImage = new Texture("icons/birdIcon.png");
        this.quitImage = new Texture("icons/exitIcon.png");
        this.saveImage = new Texture("icons/saveIcon.png");
        this.eagleImage = new Texture("powerUp/eagle.png");
        this.powershotImage = new Texture("powerUp/powerShot.png");
        this.superchargeImage = new Texture("powerUp/supercharge.png");
        this.birdquakeImage = new Texture("powerUp/birdquake.png");
        this.potionImage = new Texture("powerUp/potion.png");
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
        Button birdButton = new Button(birdImage, birdImage.getWidth() / 2 + 25,
            birdImage.getHeight() / 2, 1.6f);
        Button mapButton = new Button(mapImage, Gdx.graphics.getWidth() - (mapImage.getWidth() / 2) - 75,
            mapImage.getHeight() / 2, 1.5f);
        Button settingButton = new Button(settingImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 - 65,
            Gdx.graphics.getHeight() - settingImage.getHeight() / 2 - 60, 0.7f);
        Button quitButton = new Button(quitImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 - 35,
            Gdx.graphics.getHeight() - 3 * settingImage.getHeight() / 2 - 5, 1.2f);
        Button saveButton = new Button(saveImage, Gdx.graphics.getWidth() - settingImage.getWidth() / 2 - 35,
            Gdx.graphics.getHeight() - 3 * settingImage.getHeight() / 2 - 25 - quitImage.getHeight(), 1.2f);

        Button eagleButton = new Button(eagleImage, 200, 400, 1.2f);
        Button powershotButton = new Button(powershotImage, 900, 350, 1f);
        Button superchargeButton = new Button(superchargeImage, 200, 75, 1.2f);
        Button birdquakeButton = new Button(birdquakeImage, 550, 75, 1.2f);
        Button potionButton = new Button(potionImage, 900, 75, 1.2f);

        game.batch.begin();
        game.batch.draw(background, 0, 0, width, height);
        game.batch.draw(title, Gdx.graphics.getWidth() / 2 - 85, 590,
            3 * title.getWidth() / 2, 3 * title.getHeight() / 2);
        //Home Icon
        homeButton.getButtonSprite().draw(game.batch);
        //Map Icon
        mapButton.getButtonSprite().draw(game.batch);
        //Bird Icon
        birdButton.getButtonSprite().draw(game.batch);
        //Setting Icon
        settingButton.getButtonSprite().draw(game.batch);

        eagleButton.getButtonSprite().draw(game.batch);
        powershotButton.getButtonSprite().draw(game.batch);
        superchargeButton.getButtonSprite().draw(game.batch);
        birdquakeButton.getButtonSprite().draw(game.batch);
        potionButton.getButtonSprite().draw(game.batch);

        if (visibility) {
            quitButton.getButtonSprite().draw(game.batch);
            saveButton.getButtonSprite().draw(game.batch);
        }

        game.batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.PINK);
        shapeRenderer.rect(1000, Gdx.graphics.getHeight() - homeImage.getHeight() / 2 - 40, 70, 25);
        shapeRenderer.end();


        coins = 1500; //dummy value
        game.batch.begin();
        font.draw(game.batch, Integer.toString(coins), 1020, Gdx.graphics.getHeight() - homeImage.getHeight() / 2 - 20);

        game.batch.end();

        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if (settingButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                if (visibility) {
                    visibility = false;
                } else {
                    visibility = true;
                }
            }
            if (homeButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                game.setScreen(new HomePage(game));
            } else if (mapButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                game.setScreen(new Map(game));
            } else if (birdButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                game.setScreen(new BirdPage(game));
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
