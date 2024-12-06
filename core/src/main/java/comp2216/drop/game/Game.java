package comp2216.drop.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.function.Consumer;

public class Game extends ScreenAdapter {
    private final SpriteBatch batch;
    private final Viewport viewport;
    private final BitmapFont font;

    private final Bucket player;

    private final Texture dropletTexture;
    private final Array<Droplet> droplets;
    private float dropTimer;

    private int score;
    private int health;

    private final Consumer<Integer> onGameOver;
    private final GameProcessor inputProcessor;

    public Game(SpriteBatch batch, Viewport viewport, BitmapFont font, Consumer<Integer> onGameOver) {
        this.batch = batch;
        this.viewport = viewport;
        this.font = font;

        this.player = new Bucket();

        this.dropletTexture = new Texture("drop.png");
        this.droplets = new Array<>();
        this.dropTimer = 0;

        this.onGameOver = onGameOver;
        this.inputProcessor = new GameProcessor(this.viewport, this.player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.inputProcessor);
        this.droplets.clear();
        this.dropTimer = 0;
        this.score = 0;
        this.health = 3;
    }

    @Override
    public void render(float delta) {
        this.inputProcessor.move(delta);

        for (int i = this.droplets.size - 1; i >= 0; i--) {
            Droplet droplet = this.droplets.get(i);

            if (droplet.move(delta)) {
                this.droplets.removeIndex(i);
                this.health--;
                if (this.health == 0) this.onGameOver.accept(this.score);
            }
            else if (this.player.collidesWith(droplet)) {
                this.droplets.removeIndex(i);
                this.score++;
            }
        }
        this.spawnDroplet(delta);

        this.droplets.forEach(droplet -> droplet.draw(this.batch));
        this.player.draw(this.batch);
        this.font.draw(this.batch, "Score: " + this.score, 3.75f, 4.75f);
        this.font.draw(this.batch, "Health: " + this.health, 3.75f, 4.5f);
    }

    private void spawnDroplet(float delta) {
        this.dropTimer += delta;
        if (this.dropTimer <= 1) return;

        this.dropTimer = 0;

        float worldWidth = this.viewport.getWorldWidth();
        float worldHeight = this.viewport.getWorldHeight();
        this.droplets.add(new Droplet(this.dropletTexture, worldWidth, worldHeight));
    }

    @Override
    public void dispose() {
        this.dropletTexture.dispose();
        this.player.dispose();
    }
}

