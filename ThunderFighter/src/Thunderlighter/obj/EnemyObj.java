package Thunderlighter.obj;

import Thunderlighter.GameWin;
import Thunderlighter.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);

        y+=speed;
        if(this.getRec().intersects(this.frame.planeObj.getRec())){
                  GameWin.state=3;
        }
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){
              shellObj.setX(-100);
              shellObj.setY(100);
              this.x=-200;
              this.y=200;
              GameUtils.removeList.add(shellObj);
              GameUtils.removeList.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
