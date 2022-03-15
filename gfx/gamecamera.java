package gfx;

import Entity.entity;
import Tiles.tile;
import kachikawawa.handler;
import show.game;

public class gamecamera {
    private handler handler;
    private float xoffset,yoffset;

    public gamecamera(handler handler,float xoffset, float yoffset){
        this.handler=handler;
         this.xoffset=xoffset;
         this.yoffset=yoffset;
    }


    public void centreonEntity(entity e){
       xoffset=e.getX()- handler.getWidth()/2+e.getWidth()/2;
       yoffset=e.getY()-handler.getHeight()/2+e.getHeight()/2;
       Blankcheckspace();
    }

    public void move(float xamt, float yamt){
        xoffset+=xamt;
        yoffset+=yamt;
        Blankcheckspace();
    }

    public void setXoffset(float xoffset) {
        this.xoffset = xoffset;
    }

    public float getXoffset() {
        return xoffset;
    }

    public void setYoffset(float yoffset) {
        this.yoffset = yoffset;
    }

    public float getYoffset() {
        return yoffset;
    }

    public void Blankcheckspace(){
        if(xoffset<0){
            xoffset=0;
        }else if(xoffset>handler.getWorld().getWidth()* tile.TILEWIDTH-handler.getWidth()){
            xoffset=handler.getWorld().getWidth()* tile.TILEWIDTH-handler.getWidth();
        }
        if(yoffset<0){
            yoffset=0;
        }else if(yoffset>handler.getWorld().getHeight()*tile.TILEHEIGHT-handler.getHeight()){
            yoffset=handler.getWorld().getHeight()*tile.TILEHEIGHT-handler.getHeight();
        }
    }

}
