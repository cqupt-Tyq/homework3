package Thunderlighter.obj;

import Thunderlighter.GameWin;

import java.awt.*;

public class ShellObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y-=speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }
}
