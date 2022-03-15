package gfx;

import java.awt.image.BufferedImage;


public class Animation {
    private int index;
    private int speed;
    private long lasTime,timer;
    private BufferedImage[] frames;

    public Animation(int speed,BufferedImage[] frames){
        this.speed=speed;
        this.frames=frames;
        index=0;
        timer=0;
        lasTime=System.currentTimeMillis();
    }
    public void tick(){
       timer+=System.currentTimeMillis()-lasTime;
       lasTime=System.currentTimeMillis();

       if(timer>speed){
           index++;
           timer=0;
           if(index>=frames.length){
               index=0;
           }
       }
    }
    public BufferedImage getCurrentframe(){
        return  frames[index];
    }
}
