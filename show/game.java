package show;

import Entity.Entitymanager;
import Entity.input.KeyboardManager;
import Entity.input.Mousemanager;
import State.*;
import gfx.assets;
import gfx.gamecamera;
import kachikawawa.handler;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class game implements Runnable {
    private display display;
    private int width,height;
    public  String title;
    private Thread thread;
    private boolean running=false;

    private BufferStrategy bs;
    private Graphics g;
    // temp
    int x=0;
    //input
    private KeyboardManager Keymanager;
    private Mousemanager mousemanager;

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    //State
    public States gamestate;
    public States menustate;
    public  States manualandack;
    public  States Lose;
    public  States Win;

    //camera
    private gamecamera gamecamera;

    //handler
    private kachikawawa.handler handler;


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void tick() throws InterruptedException {
         Keymanager.tick();

         x++;
         if(States.getStates()!=null){
             States.getStates().tick();
         }
     }


    public game(String title,int width, int height){
          this.width=width;
          this.height=height;
          this.title=title;
          Keymanager=new KeyboardManager();
          mousemanager=new Mousemanager();
    }
    private void initial()
    {
        display=new display(title,width,height);
        display.getFrame().addKeyListener(Keymanager);
        display.getFrame().addMouseListener(mousemanager);
        display.getFrame().addMouseMotionListener(mousemanager);
        display.getCanvas().addMouseListener(mousemanager);
        display.getCanvas().addMouseMotionListener(mousemanager);
        assets.init();

        handler=new handler(this);

        gamecamera=new gamecamera(handler,0,0);
        gamestate=new Gamestate(handler);
        menustate=new Menustate(handler);
        manualandack=new ManualnandAck(handler);
        Lose=new Lose(handler);
        Win=new Win(handler);
        States.setCurrentstate(menustate);

    }

    private void update(){

    }
    private void render(){
     bs= display.getCanvas().getBufferStrategy();
     if(bs==null){
         display.getCanvas().createBufferStrategy(3);
         return;
     }
      g=bs.getDrawGraphics();
         //clear
          g.clearRect(0,0,width,height);
         //draw
        if(States.getStates()!=null){
            States.getStates().render(g);
        }

        // g.drawImage(assets.grass,x,10,null);
        // g.drawImage(assets.man,10,10,null);
         bs.show();// done
         g.dispose();
    }
    public void run(){
     initial();
     int fps=60;
     double timeperTick=1000000000/fps;
     double delta=0;
     long now;
     long lasTime=System.nanoTime();
     long timer=0;
     int ticks=0;

     while(running){
         now=System.nanoTime();
         delta+=(now-lasTime)/timeperTick;                        //run at 60fps
         timer+=now-lasTime;
         lasTime=now;
         if(delta>=1) {
             update();
             render();
             try {
                 tick();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             ticks++;
             delta--;
         }
       /*  if(timer>=1000000000){
           System.out.println("ticks and frames "+ticks);
           ticks=0;                                                   //verify 60fps
           timer=0;
         }
             */

      }
        stop();

    }
    public synchronized void start(){
        if(running)
            return;
      running=true;
      thread=new Thread(this);
      thread.start();
    }
    public synchronized void stop(){
        if(running=true){
            return;
        }
        else
            running = false;

      try {
          thread.join();
      }
      catch (InterruptedException e){
          e.printStackTrace();
      }
    }
    public KeyboardManager getKeymanager(){
         return  Keymanager;
    }

    public gamecamera getGamecamera(){
         return gamecamera;
    }

    public Mousemanager getMousemanager() {
        return mousemanager;
    }
}
