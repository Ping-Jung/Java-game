package Entity;

import java.awt.*;
import kachikawawa.handler;

import javax.swing.text.html.parser.Entity;

public abstract class entity {
    protected kachikawawa.handler handler;
    protected float x,y;
    protected int width,height;
    protected  Rectangle collisionbound;
    public entity(handler handler, float x, float y, int width, int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        collisionbound=new  Rectangle(0,0,width,height);
    }
    public abstract void tick() ;
    public abstract void render(Graphics g);

    public boolean checkEntityCollision(float xOffset, float yOffset,entity e){

            if (Entitymanager.getPlayer().getCollisionbound(xOffset,yOffset).intersects(e.getCollisionbound(0f, 0f))){
            //    System.out.println("player cordinate x:"+Entitymanager.getPlayer().getX()+"  y: "
                    //    +Entitymanager.getPlayer().getY());

              //  System.out.println("entitiy cordinate: x"+e.getCollisionbound(0f, 0f).getX()+" y:"+
                      // e.getCollisionbound(0f, 0f).getY());
              //  System.out.println("collision detected");
                  return true;
                 }
            return false;
    }

    public  Rectangle getCollisionbound(float xOffset,float yOffset){
        return new Rectangle((int)(x+collisionbound.x+xOffset),(int)(y+collisionbound.y+yOffset),
                collisionbound.width,collisionbound.height);
    }

    public void setX(float x){
        this.x=x;
    }
    public float getX(){
        return x;
    }
    public void setY(float y){
        this.y=y;
    }
    public float getY(){
        return y;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public float getHeight(){
        return height;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public float getWidth(){
        return width;
    }
    public void called(){}
}
