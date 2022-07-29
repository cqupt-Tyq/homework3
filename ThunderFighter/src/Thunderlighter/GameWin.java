package Thunderlighter;

import Thunderlighter.obj.*;
import Thunderlighter.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    //游戏默认状态,0为未开始，1为开始
    public  static int state=0;


    Image offScreenImage=null;
    int width=600;
    int height=600;
    //与约束子弹次数
    int count=1;

    //敌方飞机次数
    int con=1;
    //背景图对象
    BgObj bgObj=new BgObj(GameUtils.bgImage,0,-2000,2);


    //我方飞机对象
    public  PlaneObj planeObj=new PlaneObj(GameUtils.planeImage,290,550,20,30,0,this);

     public void launch(){
        //设置窗口
        this.setVisible(true);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("雷霆战机");


        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==1&&state==0){
                    state=1;
                    repaint();
                }
            }
        });
        while (true){
            if(state==1) {
                createObj();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if(offScreenImage==null){
            offScreenImage=createImage(width, height);
        }
        Graphics gImage=offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        if(state==0){
            gImage.drawImage(GameUtils.bgImage,0,0,null);
            gImage.drawImage(GameUtils.bossImage,220,120,null);
            gImage.setColor(Color.BLUE);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("点击开始游戏",180,300);
        }
        if(state==1){

            for(int i=0;i<GameUtils.gameObjList.size();i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
           GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if(state==3){

            gImage.setColor(Color.red);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("游戏失败",180,300);
        }
       g.drawImage(offScreenImage,0,0,null);
        count++;
        con++;
     }

    void createObj(){
         addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {

             }

             @Override
             public void keyPressed(KeyEvent e) {
              if(  e.getKeyCode()==KeyEvent.VK_J){
                  count=0;
              };
             }

             @Override
             public void keyReleased(KeyEvent e) {

             }
         });
          //我方子弹
        if(count==0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImage, planeObj.getX() + 3, planeObj.getY() - 16, 14, 29, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if(con%35==0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImage,(int)(Math.random()*12)*50,0,49,36,2.5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));

        }
        if(con%30==0) {
            for (EnemyObj enemyObj : GameUtils.enemyObjList) {
                GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImage, enemyObj.getX() + 25, enemyObj.getY() + 50, 14, 25, 10, this));
                GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size() - 1));
            }
        }
    }
    public static void main(String[] args) {
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
