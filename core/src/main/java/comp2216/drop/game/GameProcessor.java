package comp2216.drop.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.util.HashSet;
import java.util.Set;

public class GameProcessor extends InputAdapter {
    private final Bucket bucket;

    private final Set<Integer> pressed;

    public GameProcessor(Bucket bucket) {
        this.bucket = bucket;

        this.pressed = new HashSet<>();
    }

    @Override
    public boolean keyDown(int keycode) {
        return this.pressed.add(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return this.pressed.remove(keycode);
    }

    public void move(float delta) {
        if (this.pressed.contains(Input.Keys.LEFT) || this.pressed.contains(Input.Keys.A))
            this.bucket.move(-1 * delta);

        if (this.pressed.contains(Input.Keys.RIGHT) || this.pressed.contains(Input.Keys.D))
            this.bucket.move(1 * delta);
    }
}

