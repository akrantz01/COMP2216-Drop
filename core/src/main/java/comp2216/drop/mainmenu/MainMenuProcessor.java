package comp2216.drop.mainmenu;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class MainMenuProcessor extends InputAdapter {
    private final Runnable onStart;

    public MainMenuProcessor(Runnable onStart) {
        this.onStart = onStart;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            this.onStart.run();
            return true;
        }

        return false;
    }
}
