package com.angybrids;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

import com.angybrids.pages.LoseScreen;
import com.angybrids.pages.Map;
import com.angybrids.pages.WinScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.angybrids.blocks.*;
import com.angybrids.pigs.*;
import com.angybrids.birds.*;


@SuppressWarnings("ALL")
public class Level implements Screen {
    final Main game;
    private int level;
    private Texture background;
    private Texture pause;
    private Texture quit;
    private Texture resume;
    private Texture retry;
    private Texture catapult;
    private FitViewport viewport;
    private Texture stonebarhorizontal;
    private Texture woodbarvertical;
    private Texture scoreTitle;
    private Texture winImage;
    private Texture loseImage;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    private boolean visibility;
    private ArrayList<Texture> blocks = new ArrayList<>();
    private ArrayList<Sprite> birds = new ArrayList<>();
    private List<Sprite> selectedBirds;
    private int score = 0;

    public Level(int level, Main game, List<Sprite> selectedBirds) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        viewport = new FitViewport(1280, 720);
        stonebarhorizontal = new StoneHorizontal().getBlock();
        woodbarvertical = new WoodVertical().getBlock();
        this.shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        Texture stonebarvertical = new StoneVertical().getBlock();
        Texture glassbarvertical = new GlassVertical().getBlock();
        Texture glassbarhorizontal = new GlassHorizontal().getBlock();
        Texture tnt = new Texture("blocks/tnt.png");
        Random random = new Random();
        StoneBlock s = new StoneBlock();
        blocks.add(s.getBlock());
        blocks.add(s.getBlock());
        blocks.add(s.getBlock());
        GlassBlock g = new GlassBlock();
        blocks.add(g.getBlock());
        blocks.add(g.getBlock());
        blocks.add(g.getBlock());
        WoodBlock w = new WoodBlock();
        blocks.add(w.getBlock());
        blocks.add(w.getBlock());
        blocks.add(w.getBlock());
        if (level % 3 == 1) {
            background = new Texture("levelAssets/bg3.png");
        } else if (level % 3 == 0) {
            background = new Texture("levelAssets/bg2.png");
        } else {
            background = new Texture("levelAssets/bg1.png");
        }
        this.selectedBirds = selectedBirds;

        this.level = level;
        this.game = game;
        pause = new Texture("icons/pauseIcon.png");
        quit = new Texture("icons/exitIcon.png");
        resume = new Texture("icons/resumeIcon.png");
        retry = new Texture("icons/retryIcon.png");
        catapult = new Texture("catapult.png");
        winImage = new Texture("icons/winIcon.png");
        loseImage = new Texture("icons/loseIcon.png");
        scoreTitle = new Texture("levelAssets/scoreTitle.png");
    }

    public Level(int level, Main game) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        viewport = new FitViewport(1280, 720);
        stonebarhorizontal = new StoneHorizontal().getBlock();
        woodbarvertical = new WoodVertical().getBlock();
        this.shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        Texture stonebarvertical = new StoneVertical().getBlock();
        Texture glassbarvertical = new GlassVertical().getBlock();
        Texture glassbarhorizontal = new GlassHorizontal().getBlock();
        Texture tnt = new Texture("blocks/tnt.png");
        Random random = new Random();
        StoneBlock s = new StoneBlock();
        blocks.add(s.getBlock());
        blocks.add(s.getBlock());
        blocks.add(s.getBlock());
        GlassBlock g = new GlassBlock();
        blocks.add(g.getBlock());
        blocks.add(g.getBlock());
        blocks.add(g.getBlock());
        WoodBlock w = new WoodBlock();
        blocks.add(w.getBlock());
        blocks.add(w.getBlock());
        blocks.add(w.getBlock());
        if (level % 3 == 1) {
            background = new Texture("levelAssets/bg3.png");
        } else if (level % 3 == 0) {
            background = new Texture("levelAssets/bg2.png");
        } else {
            background = new Texture("levelAssets/bg1.png");
        }
        birds.add(new Red().getSprite());
        birds.add(new Chuck().getSprite());
        birds.add(new Bomb().getSprite());
        birds.add(new Blue().getSprite());
        birds.add(new Terence().getSprite());
        birds.add(new Matilda().getSprite());
        birds.add(new Hal().getSprite());
        selectedBirds = selectItems(birds);

        this.level = level;
        this.game = game;
        pause = new Texture("icons/pauseIcon.png");
        quit = new Texture("icons/exitIcon.png");
        resume = new Texture("icons/resumeIcon.png");
        retry = new Texture("icons/retryIcon.png");
        catapult = new Texture("catapult.png");
        winImage = new Texture("icons/winIcon.png");
        loseImage = new Texture("icons/loseIcon.png");
        scoreTitle = new Texture("levelAssets/scoreTitle.png");
    }

    public List<Sprite> selectItems(ArrayList<Sprite> birds) {
        Collections.shuffle(birds);
        return birds.subList(0, 3);
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
        Button pauseButton = new Button(pause, 20, Gdx.graphics.getHeight() - 90, 1f);
        Button resumeButton = new Button(resume, Gdx.graphics.getWidth() / 2 - 125, Gdx.graphics.getHeight() / 2, 1.4f);
        Button quitButton = new Button(quit, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 2, 1.6f);
        Button retryButton = new Button(retry, Gdx.graphics.getWidth() / 2 + 115, Gdx.graphics.getHeight() / 2 + 4, 1.6f);
        game.batch.begin();
        game.batch.draw(background, 0, 0, width, height);
        int x = 600;
        int y = 100;
        int counter = 0;
        for (Texture t : blocks) {
            counter++;
            if (counter == 4) {
                continue;
            }
            game.batch.draw(t, x, y);
            Pig p = new Pig(x + t.getWidth() / 2 - 300, y - 273);
            p.getSprite().draw(game.batch);
            y += t.getHeight();
            if (counter == 3) {
                x += t.getWidth();
                y -= 3 * t.getHeight();
                game.batch.draw(stonebarhorizontal, x, y);
                Crazy c = new Crazy(x + stonebarhorizontal.getWidth() / 2 - 25, y + 15);
                c.getSprite().draw(game.batch);
                x += stonebarhorizontal.getWidth();
                game.batch.draw(woodbarvertical, x, y);
                King k = new King(x + t.getWidth() / 2 - 250, y + 120);
                k.getSprite().draw(game.batch);
                x += t.getWidth();
                game.batch.draw(woodbarvertical, x - 15, y);
                x -= t.getWidth();
                y += woodbarvertical.getHeight() - 5;
            } else if (counter == 6) {
                y = 100;
                x += t.getWidth();
                game.batch.draw(stonebarhorizontal, x, y);
                Crazy c = new Crazy(x + stonebarhorizontal.getWidth() / 2 - 25, y + 15);
                c.getSprite().draw(game.batch);
                x += stonebarhorizontal.getWidth();
            }
        }
        pauseButton.getButtonSprite().draw(game.batch);
        game.batch.draw(catapult, 200, 100);
        Button winButton = new Button(winImage, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() - 65, 1.2f);
        Button loseButton = new Button(loseImage, Gdx.graphics.getWidth() / 2 + winImage.getWidth() + 25, Gdx.graphics.getHeight() - 65, 1.2f);
        winButton.getButtonSprite().draw(game.batch);
        loseButton.getButtonSprite().draw(game.batch);
        x = -50;
        y = 65;
        for (Sprite sp : selectedBirds) {
            if (sp.getWidth() < 101) {
                sp.setPosition(x + 60, y - sp.getHeight() / 2 + 55);
            } else if (sp.getHeight() < 190 || sp.getHeight() == 193) {
                sp.setPosition(x, y - sp.getHeight() / 2 + 55);
            } else {
                sp.setPosition(x, y - sp.getHeight() / 2 + 75);
            }
            x += 75;
            sp.draw(game.batch);
        }
        score = 1500; //dummy value
//        font.setColor(1f, 1f, 1f, 1f);
        font.setColor(0f, 0f, 0f, 1f);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.getData().setScale(2.5f);
        game.batch.draw(scoreTitle, 1050, Gdx.graphics.getHeight() - pause.getHeight() / 2 - 35 );
        font.draw(game.batch, Integer.toString(score), 1175, Gdx.graphics.getHeight() - pause.getHeight() / 2+3 );
        game.batch.end();
        if (visibility) {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.setColor(new Color(0, 0, 0, 0.5f));
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(0, 0, width, height);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
            game.batch.begin();
            retryButton.getButtonSprite().draw(game.batch);
            resumeButton.getButtonSprite().draw(game.batch);
            quitButton.getButtonSprite().draw(game.batch);
            game.batch.end();
        }

        float touchX = Gdx.input.getX();
        float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (pauseButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)
            || (visibility && pauseButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY))
            || (visibility && resumeButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY))
            || (visibility && quitButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY))
            || (visibility && retryButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY))
            || (winButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY))
            || (loseButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)))
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
        else Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        if (Gdx.input.justTouched()) {
            if (!visibility && pauseButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                visibility = true;
            } else {
                if (winButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    this.dispose();
                    game.setScreen(new WinScreen(level, this.game));
                } else if (loseButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    this.dispose();
                    game.setScreen(new LoseScreen(level, this.game, selectedBirds));
                }
                if (resumeButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    visibility = false;
                } else if (quitButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    this.dispose();
                    background.dispose();
                    game.setScreen(new Map(this.game));
                } else if (retryButton.getButtonSprite().getBoundingRectangle().contains(touchX, touchY)) {
                    try {
                        this.dispose();
                        background.dispose();
                        game.setScreen(new Level(level, this.game, selectedBirds));
                    } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    visibility = false;
                }
            }
        }

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
        stonebarhorizontal.dispose();
        woodbarvertical.dispose();
        shapeRenderer.dispose();
//        background.dispose();
        pause.dispose();
        quit.dispose();
        resume.dispose();
        retry.dispose();
        catapult.dispose();
        winImage.dispose();
        loseImage.dispose();

    }
}
