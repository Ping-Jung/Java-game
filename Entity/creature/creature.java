package Entity.creature;

import Entity.entity;
import Tiles.tile;

import java.io.IOException;

public  abstract class creature extends entity {
    public static final int DEFAULT_MP=200;
    public static final int DEFAULT_HEALTH=200;
    public static final float DEFAULT_SPEED=3.0f;
    public static int DEFAULT_CREATURE_WIDTH=32;
    public static int DEFAULT_CREATURE_WIDTH2=64;
    public static final int DEFAULT_CREATURE_HEIGHT=64;

    private int mp;
    private int health;
    protected float speed;
    protected float xMove,yMove;
    protected int  sleeptime;



    public creature(kachikawawa.handler handler, float x, float y, int width, int height){
       super(handler,x,y,width,height);
       mp=DEFAULT_MP;
       health= DEFAULT_HEALTH;
       speed=DEFAULT_SPEED;
       xMove=0;
       yMove=0;
    }

    public void move(){
        //if(!checkEntityCollision(xMove,0f)){
            moveX();
            moveY();
       // }
      //  if(!checkEntityCollision(0f,yMove)) {

       // }
    }

    protected boolean collisionwithtile(int x,int y){
     return handler.getWorld().getTile(x,y).isSolid();
    }
    protected boolean ememyappraoch(){  return true; }

    public void moveX(){
        if(xMove>0){        //right
            int tx=(int)(x+xMove+collisionbound.x+collisionbound.width)/ tile.TILEWIDTH;
            if(!collisionwithtile(tx,(int)(y+collisionbound.y)/tile.TILEHEIGHT)&&
                    !collisionwithtile(tx,(int)(y+collisionbound.y+collisionbound.height)/tile.TILEHEIGHT)){
                x+=xMove;
            }else {
                x=tx*tile.TILEWIDTH-collisionbound.x- collisionbound.width-1;
            }
        }
        else if(xMove<0) {      // left
             int tx = (int) (x + xMove + collisionbound.x) / tile.TILEWIDTH;
            if (!collisionwithtile(tx, (int) (y + collisionbound.y) / tile.TILEHEIGHT) &&
                    !collisionwithtile(tx, (int) (y + collisionbound.y + collisionbound.height) / tile.TILEHEIGHT)){
                x += xMove;
            }
            else{
                x=tx*tile.TILEWIDTH+tile.TILEWIDTH-collisionbound.x;
            }
        }
    }
    public void moveY() {
        if (yMove < 0) {            //up
            int ty = (int) (y + yMove + collisionbound.y) / tile.TILEHEIGHT;
            if (!collisionwithtile((int) (x + collisionbound.x / tile.TILEWIDTH), ty) &&
                    !collisionwithtile((int) (x + collisionbound.x + collisionbound.width) / tile.TILEWIDTH, ty)
            ) {
                y += yMove;
            } else {
                y = ty * tile.TILEHEIGHT + tile.TILEHEIGHT - collisionbound.y;
            }
        } else if (yMove > 0) {
            int ty = (int) (y + yMove + collisionbound.y + collisionbound.height) / tile.TILEHEIGHT;
            if (!collisionwithtile((int) (x + collisionbound.x) / tile.TILEWIDTH, ty) &&
                    !collisionwithtile((int) (x + collisionbound.x + collisionbound.width) / tile.TILEWIDTH, ty)
            ) {
                y += yMove;
            } else {        //down
                y = ty * tile.TILEHEIGHT - collisionbound.y - collisionbound.height - 1;

            }
        }
    }
    //getter setter

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void attack(){ }
}
