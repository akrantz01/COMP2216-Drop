package comp2216.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Drop extends ApplicationAdapter {
    private SpriteBatch batch;
    private Viewport viewport;

    private Texture background;

    public Drop() {
        super();
    }

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.viewport = new FitViewport(8, 5);

        this.background = new Texture("background.png");
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        this.viewport.apply();
        this.batch.setProjectionMatrix(this.viewport.getCamera().combined);

        this.batch.begin();
        this.batch.draw(this.background, 0, 0, this.viewport.getWorldWidth(), this.viewport.getWorldHeight());
        this.batch.end();
    }

    @Override
    public void dispose() {
        this.background.dispose();
        this.batch.dispose();
    }
}
