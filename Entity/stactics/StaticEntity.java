package Entity.stactics;

import Entity.entity;
import kachikawawa.handler;

public abstract class StaticEntity extends entity {

    public StaticEntity(handler handler,float x,float y,int width,int height){
        super(handler, x, y, width, height);
    }
    public void called(){};
}

