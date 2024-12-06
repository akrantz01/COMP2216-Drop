package comp2216.drop.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public class Bucket implements Collidable, Disposable {
    private static final float SPEED = 4;

    private final Texture texture;
    private final Sprite sprite;

    public Bucket() {
        this.texture = new Texture("bucket.png");
        this.sprite = new Sprite(this.texture);
        this.sprite.setSize(1, 1);
    }

    @Override
    public Rectangle getCollisionArea() {
        return this.sprite.getBoundingRectangle();
    }

    public void move(float by) {
        this.sprite.translateX(by * SPEED);
    }

    public void moveTo(float position) {
        this.sprite.setCenterX(position);
    }

    public void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }

    @Override
    public void dispose() {
        this.texture.dispose();
    }
}

