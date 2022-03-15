package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;


public class tile {
    // static stuff here
   public static tile[] tiles=new tile[256];
   public static tile grasstile=new grasstile(0);
   public static tile dirttile=new dirtile(1);
   public static tile watertile=new watertile(2);
   public static tile  rocktile=new rocktile(3);
   public static tile  rock2tile=new rock2tile(4);
   public static tile flowertile=new flowertile(5);
   public static tile entrytile=new entrytile(6);
   public static tile exittile=new exittile(7);
   public static tile bricktile=new bricktile(8);
    //class
    public static final int TILEWIDTH=60,TILEHEIGHT=60;
    protected BufferedImage texture;
    protected final int id;
    public tile(BufferedImage texture,int id){
      this.texture=texture;
      this.id=id;
      tiles[id]=this;
    }
    public void tick(){

    }
    public void render(Graphics g,int x,int y){
       g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
    }

    public boolean isSolid(){        // can walk through ==false
        return false;
    }


    public int getId() {
        return id;
    }
}
