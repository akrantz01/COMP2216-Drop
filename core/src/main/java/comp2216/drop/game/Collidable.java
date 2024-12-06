package comp2216.drop.game;

import com.badlogic.gdx.math.Rectangle;

public interface Collidable {
    Rectangle getCollisionArea();

    default boolean collidesWith(Collidable collidable) {
        return this.getCollisionArea().overlaps(collidable.getCollisionArea());
    }
}

