package Entity.stactics;

import Entity.Entitymanager;
import Entity.creature.players;
import gfx.assets;
import kachikawawa.handler;

import java.awt.*;

public class wine extends StaticEntity{

    protected int wplusHP=50;
    public wine(handler handler, float x, float y){
        super(handler,x,y,50,50);
        collisionbound.x=10;
        collisionbound.y=10;
        collisionbound.width=30;
        collisionbound.height=30;

    }
    @Override
    public  void tick(){};
    @Override
    public  void render(Graphics g){
        g.drawImage(assets.wine,(int)(x- handler.getGamecamera().getXoffset()),
                (int)(y- handler.getGamecamera().getYoffset()), width,height,null);

       // g.setColor(Color.red);
        // g.fillRect((int)(x+collisionbound.x-handler.getGamecamera().getXoffset()),
         // (int)(y+collisionbound.y-handler.getGamecamera().getYoffset()),collisionbound.width,collisionbound.height);
    }
    @Override
    public void called(){
        int a= Entitymanager.getPlayer().getHealth();
        a+=wplusHP;
        Entitymanager.getPlayer().setHealth(a);
      //  System.out.print("plushp:50   final hp:");
      //  System.out.println(Entitymanager.getPlayer().getHealth());

    }
}
