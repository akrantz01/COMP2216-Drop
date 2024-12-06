package comp2216.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver extends ScreenAdapter {
    private final SpriteBatch batch;
    private final BitmapFont font;

    private final Runnable onComplete;

    private int score;
    private float timeout;

    public GameOver(SpriteBatch batch, BitmapFont font, Runnable onComplete) {
        this.batch = batch;
        this.font = font;
        this.onComplete = onComplete;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(null);
        this.timeout = 5;
    }

    @Override
    public void render(float delta) {
        this.timeout -= delta;
        if (this.timeout < 0) this.onComplete.run();

        this.font.draw(this.batch, "Game Over!", 3, 3);
        this.font.draw(this.batch, "Score: " + this.score + " points", 2.75f, 2.5f);
    }
}

