package comp2216.drop.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Droplet implements Collidable {
    private final Sprite sprite;

    public Droplet(Texture texture, float worldWidth, float worldHeight) {
        this.sprite = new Sprite(texture);
        this.sprite.setSize(1, 1);
        this.sprite.setCenter(MathUtils.random(0f, worldWidth - 1), worldHeight);
    }

    @Override
    public Rectangle getCollisionArea() {
        return this.sprite.getBoundingRectangle();
    }

    public boolean move(float delta) {
        this.sprite.translateY(-2f * delta);
        return this.sprite.getY() < -1;
    }

    public void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }
}

