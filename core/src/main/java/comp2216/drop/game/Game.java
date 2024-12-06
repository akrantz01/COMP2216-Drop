package comp2216.drop.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ScreenAdapter {
    private final SpriteBatch batch;

    private final Bucket player;

    public Game(SpriteBatch batch) {
        this.batch = batch;

        this.player = new Bucket();
    }

    @Override
    public void render(float delta) {
        this.player.draw(this.batch);
    }

    @Override
    public void dispose() {
        this.player.dispose();
    }
}

