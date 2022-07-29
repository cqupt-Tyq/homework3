package Thunderlighter.utils;

import Thunderlighter.obj.BulletObj;
import Thunderlighter.obj.EnemyObj;
import Thunderlighter.obj.GameObj;
import Thunderlighter.obj.ShellObj;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

public class GameUtils {
    //背景图片
    public static Image bgImage=Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");

    //boss飞机
    public static Image bossImage=Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //我方战斗机
    public static Image planeImage=Toolkit.getDefaultToolkit().getImage("imgs/hero0.png");
    //敌机图片
    public static Image enemyImage=Toolkit.getDefaultToolkit().getImage("imgs/airplane.png");
    //敌机图片

    //子弹
public static Image shellImage=Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
//所有物体集合
public static Image bulletImage=Toolkit.getDefaultToolkit().getImage("imgs/shell.png");

    public static List<GameObj> gameObjList=new ArrayList<>();
    //要删除元素的集合
    public static List<GameObj> removeList=new ArrayList<>();

    //子弹集合
   public static List<ShellObj> shellObjList=new ArrayList<>();
   //敌方战机集合
   public static List<EnemyObj> enemyObjList=new ArrayList<>();

   //敌方子弹集合
   public static List<BulletObj> bulletObjList=new ArrayList<>();


}
