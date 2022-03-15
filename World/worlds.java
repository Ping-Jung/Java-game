package World;

import Entity.Entitymanager;
import Entity.creature.Monster;
import Entity.creature.players;
import Entity.stactics.chicken;
import Entity.stactics.treasure;
import Entity.stactics.wine;
import Tiles.tile;

import java.awt.*;

public class worlds {
    private kachikawawa.handler handler;
    private int width;
    private Entitymanager entitymanager;


    private int height;
    private int spawnX,spawnY;
    private int[][] tileworld;

    public worlds(kachikawawa.handler handler, String path){
        this.handler=handler;
        entitymanager=new Entitymanager(handler,new players(handler,100,100));
        entitymanager.addEntity(new chicken(handler,915,665));
        entitymanager.addEntity(new treasure(handler,975,130));
        entitymanager.addEntity(new wine(handler,370,905));
        loadworld(path);
        entitymanager.getPlayer().setX(spawnX);
        entitymanager.getPlayer().setY(spawnY);
        entitymanager.getMonster1().setY(300);
        entitymanager.getMonster1().setX(100);
    }

    private void loadworld(String path){
        String file=Utils.util.loadfileasString(path);
        String[] tokens=file.split("\\s+");
        width=Utils.util.parseInt(tokens[0]);
        height=Utils.util.parseInt(tokens[1]);
        spawnX=Utils.util.parseInt(tokens[2]);
        spawnY=Utils.util.parseInt(tokens[3]);

        tileworld=new int[width][height];

        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
              tileworld[x][y]=Utils.util.parseInt(tokens[(x+y*width)+4]);
            }
        }
    }

    public void tick()  {
      entitymanager.tick();
    }

    public void render(Graphics g){
        //render for certain space of method
        int Xstart=(int)Math.max(0, handler.getGamecamera().getXoffset()/tile.TILEWIDTH);
        int Xend=(int)Math.min(width,(handler.getGamecamera().getXoffset()+ handler.getWidth())/tile.TILEWIDTH+1);
        int Ystart=(int)Math.max(0, handler.getGamecamera().getYoffset()/tile.TILEHEIGHT);
        int Yend=(int)Math.min(height,(handler.getGamecamera().getYoffset()+ handler.getHeight())/tile.TILEHEIGHT+1);;

         for(int y=Ystart;y<Yend;y++){
             for(int x=Xstart;x<Xend;x++){
                 getTile(x,y).render(g,(int)(x*tile.TILEWIDTH- handler.getGamecamera().getXoffset()),
                         (int)(y*tile.TILEHEIGHT- handler.getGamecamera().getYoffset()));
             }
         }
         entitymanager.render(g);
    }

    public tile getTile(int x,int y){
        if(x<0 || y<0 || x>=width||y>=height){
            return tile.grasstile;
        }
        tile t=tile.tiles[tileworld[x][y]];
        if(t==null){
            return tile.dirttile;
        }
        return t;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entitymanager getEntitymanager() {
        return entitymanager;
    }
}
