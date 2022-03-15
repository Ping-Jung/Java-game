package Entity.stactics;


import Entity.Entitymanager;
import gfx.assets;
import kachikawawa.handler;

import java.awt.*;

public class treasure extends StaticEntity {

    protected int plusMP=150;

    public treasure(handler handler, float x, float y){
        super(handler,x,y,40,40);
        collisionbound.x=5;
        collisionbound.y=10;
        collisionbound.width=30;
        collisionbound.height=30;
    }
    @Override
    public  void tick(){};
    @Override
    public  void render(Graphics g){
        g.drawImage(assets.treasure,(int)(x- handler.getGamecamera().getXoffset()),
                (int)(y- handler.getGamecamera().getYoffset()), width,height,null);
       // g.setColor(Color.red);
         // g.fillRect((int)(x+collisionbound.x-handler.getGamecamera().getXoffset()),
        //  (int)(y+collisionbound.y-handler.getGamecamera().getYoffset()),collisionbound.width,collisionbound.height);
    }
    @Override
    public void called() {
        int k=Entitymanager.getPlayer().getMp();
        k+=plusMP;
        Entitymanager.getPlayer().setMp(k);
      //  System.out.print("plusMp:150  final mp:");
      //  System.out.println(Entitymanager.getPlayer().getMp());
    }
}
