package Thunderlighter.obj;

import Thunderlighter.GameWin;

import java.awt.*;

public class BgObj extends GameObj{
    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y+=speed;
        if(y>=0){
            y=-2000;
        }
    }
}
