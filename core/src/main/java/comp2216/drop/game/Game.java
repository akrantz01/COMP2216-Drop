package comp2216.drop.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ScreenAdapter {
    private final SpriteBatch batch;

    private final Bucket player;

    private final GameProcessor inputProcessor;

    public Game(SpriteBatch batch) {
        this.batch = batch;

        this.player = new Bucket();

        this.inputProcessor = new GameProcessor(this.player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.inputProcessor);
    }

    @Override
    public void render(float delta) {
        this.inputProcessor.move(delta);
        this.player.draw(this.batch);
    }

    @Override
    public void dispose() {
        this.player.dispose();
    }
}

