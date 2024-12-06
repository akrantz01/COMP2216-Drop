package comp2216.drop.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashSet;
import java.util.Set;

public class GameProcessor extends InputAdapter {
    private final Viewport viewport;
    private final Bucket bucket;

    private final Set<Integer> pressed;
    private boolean dragging;
    private final Vector2 touchPosition;

    public GameProcessor(Viewport viewport, Bucket bucket) {
        this.viewport = viewport;
        this.bucket = bucket;

        this.pressed = new HashSet<>();
        this.dragging = false;
        this.touchPosition = new Vector2();
    }

    @Override
    public boolean keyDown(int keycode) {
        return this.pressed.add(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return this.pressed.remove(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT) return false;

        this.dragging = true;
        return this.moveTo(screenX, screenY);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return this.moveTo(screenX, screenY);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (!this.dragging || button != Input.Buttons.LEFT) return false;

        this.dragging = false;
        return true;
    }

    private boolean moveTo(int screenX, int screenY) {
        this.viewport.unproject(this.touchPosition.set(screenX, screenY));
        this.bucket.moveTo(this.touchPosition.x);
        return true;
    }

    public void move(float delta) {
        if (this.pressed.contains(Input.Keys.LEFT) || this.pressed.contains(Input.Keys.A))
            this.bucket.move(-1 * delta);

        if (this.pressed.contains(Input.Keys.RIGHT) || this.pressed.contains(Input.Keys.D))
            this.bucket.move(1 * delta);
    }
}

