package Thunderlighter.obj;

import Thunderlighter.GameWin;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlaneObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch(e.getKeyCode())

                {
                    case KeyEvent.VK_W:

                        upGo();

                        break;

                    case KeyEvent.VK_S:

                        downGo();

                        break;

                    case KeyEvent.VK_D:

                        rightGo();

                        break;

                    case KeyEvent.VK_A:

                        leftGo();

                        break;

                }
            }


            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void upGo()

    {
        x=x;
        if(y>=0&&x>=0&&x<=600) {
            y = y - 20;
        }

    }

    public void downGo()

    {
        x=x;
         if(y<=600&&x>=0&&x<=600) {
             y = y + 20;
         }
    }

    public void leftGo()

    {
        y=y;
        if(x>=0&&y>=0&&y<=600) {
            x = x - 20;
        }
    }

    public void rightGo()

    {
        y=y;
      if (x<=600&&y>=0&&y<=600) {
    x = x + 20;
    }
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }
}
