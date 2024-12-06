package comp2216.drop.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Droplet {
    private final Sprite sprite;

    public Droplet(Texture texture, float worldWidth, float worldHeight) {
        this.sprite = new Sprite(texture);
        this.sprite.setSize(1, 1);
        this.sprite.setCenter(MathUtils.random(0f, worldWidth - 1), worldHeight);
    }

    public void move(float delta) {
        this.sprite.translateY(-2f * delta);
    }

    public void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }
}

