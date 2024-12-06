package comp2216.drop.mainmenu;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu extends ScreenAdapter {
    private final SpriteBatch batch;
    private final BitmapFont font;

    public MainMenu(SpriteBatch batch, BitmapFont font) {
        this.batch = batch;
        this.font = font;
    }

    @Override
    public void render(float delta) {
        this.font.draw(this.batch, "Welcome to Drop!", 3, 3);
        this.font.draw(this.batch, "Click anywhere to begin", 2.75f, 2.5f);
    }
}
