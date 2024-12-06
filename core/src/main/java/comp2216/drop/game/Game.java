package comp2216.drop.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Game extends ScreenAdapter {
    private final SpriteBatch batch;
    private final Viewport viewport;

    private final Bucket player;

    private final Texture dropletTexture;
    private final Array<Droplet> droplets;
    private float dropTimer;

    private final GameProcessor inputProcessor;

    public Game(SpriteBatch batch, Viewport viewport) {
        this.batch = batch;
        this.viewport = viewport;

        this.player = new Bucket();

        this.dropletTexture = new Texture("drop.png");
        this.droplets = new Array<>();
        this.dropTimer = 0;

        this.inputProcessor = new GameProcessor(this.viewport, this.player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.inputProcessor);
        this.droplets.clear();
        this.dropTimer = 0;
    }

    @Override
    public void render(float delta) {
        this.inputProcessor.move(delta);

        this.droplets.forEach(droplet -> droplet.move(delta));
        this.spawnDroplet(delta);

        this.droplets.forEach(droplet -> droplet.draw(this.batch));
        this.player.draw(this.batch);
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

