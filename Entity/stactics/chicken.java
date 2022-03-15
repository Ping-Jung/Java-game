package Entity.stactics;

import Entity.Entitymanager;
import Entity.creature.creature;
import Entity.creature.players;
import gfx.assets;
import kachikawawa.handler;


import java.awt.*;

public class chicken extends StaticEntity {

    protected int plusHP=100;

    public chicken(handler handler, float x, float y){
        super(handler,x,y,40,40);
        collisionbound.x=5;
        collisionbound.y=10;
        collisionbound.height=25;
        collisionbound.width=25;
    }


    @Override
    public  void tick(){};
    @Override
    public  void render(Graphics g){
        g.drawImage(assets.chicken,(int)(x- handler.getGamecamera().getXoffset()),
                (int)(y- handler.getGamecamera().getYoffset()), width,height,null);
        //g.setColor(Color.red);
        // g.fillRect((int)(x+collisionbound.x-handler.getGamecamera().getXoffset()),
        // (int)(y+collisionbound.y-handler.getGamecamera().getYoffset()),collisionbound.width,collisionbound.height);
    }
    @Override
    public void called(){
       int b=Entitymanager.getPlayer().getHealth();
       b+=plusHP;
       Entitymanager.getPlayer().setHealth(b);
     //  System.out.print("plushp:100  final hp: ");
     //  System.out.println(Entitymanager.getPlayer().getHealth());
    }
}
