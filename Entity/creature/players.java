package Entity.creature;

import Entity.Entitymanager;
import State.States;
import gfx.Animation;
import gfx.assets;


import java.awt.*;
import java.awt.image.BufferedImage;

import static gfx.assets.attackleft;
import static gfx.assets.man_down;

//setting the attack part  using space+direction to check  the attack target  the area of the target should be range from a tile
//and each attack should cause 10-20 of hp damage and increase ten percent of mp will increase +10 of hp harmness
// unfinish part : attack is valid to monster
//it is hard to show the which direction is valid attack
//need improvement

public class players extends creature{

    //animation
  private int tilex,tiley;
    int sleeptime=10;
    private  int attackdirection;
    private int sizechan=32;
    private boolean movused;
    final double ns=1000000000;
    private long atktime2,timer4,lastime2;


    private Animation anidown,aniup,anileft,aniright;
    private Animation aniattckup,aniattckdown,aniattckleft,aniattckright;
    public players(kachikawawa.handler handler, float x, float y){
        super(handler,x,y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
        collisionbound.x=4;
        collisionbound.y=20;
        collisionbound.width=26;
        collisionbound.height=30;
        anidown=new Animation(80, man_down);
        aniup=new Animation(80,assets.man_up);
        anileft=new Animation(80,assets.man_left);
        aniright=new Animation(80,assets.man_right);
        aniattckup=new Animation(80,assets.attackup);
        aniattckdown=new Animation(80,assets.attackdown);
        aniattckright=new Animation(80, assets.attackright);
        aniattckleft=new Animation(80, attackleft);
        movused=false;
        atktime2=System.nanoTime();
    }

    @Override
    public void tick() {
        //animation'
        if(xMove<0) {
            Entitymanager.getPlayer().setWidth(DEFAULT_CREATURE_WIDTH);
            anileft.tick();
        }
        else if(xMove>0) {
            Entitymanager.getPlayer().setWidth(DEFAULT_CREATURE_WIDTH);
            aniright.tick();
        }
        else if(yMove<0) {
            Entitymanager.getPlayer().setWidth(DEFAULT_CREATURE_WIDTH);
            aniup.tick();
        }
        else if(yMove>0) {
            Entitymanager.getPlayer().setWidth(DEFAULT_CREATURE_WIDTH);
            anidown.tick();
        }
        else if(attackdirection==0){
            Entitymanager.getPlayer().setWidth(64);
            aniattckup.tick();
        }
        else if(attackdirection==1){
            Entitymanager.getPlayer().setWidth(64);
            aniattckdown.tick();
        }
        else if(attackdirection==2){
            Entitymanager.getPlayer().setWidth(64);
            aniattckleft.tick();
        }
        else if(attackdirection==3){
            Entitymanager.getPlayer().setWidth(64);
           aniattckright.tick();
        }
        else
            Entitymanager.getPlayer().setWidth(DEFAULT_CREATURE_WIDTH);

        // movement
        getInput();
        move();
        attack();
        handler.getGamecamera().centreonEntity(this);
        tilex=(int)((y+30)/60);
        tiley=(int)((x+12)/60);
       // System.out.println("("+tilex+" " +tiley+")");
        gg();
        winwin();

      /*if(game.getKeymanager().up){
          y-=3;
      }
        if(game.getKeymanager().down){
            y+=3;
        }
        if(game.getKeymanager().left){
            x-=3;
        }
        if(game.getKeymanager().right){
            x+=3;
        }*/
    }
    public void gg(){
        if(Entitymanager.getPlayer().getHealth()<=0){
            States.setCurrentstate(handler.getGame().Lose);
        }

    }

    public void winwin(){
        if(Entitymanager.getPlayer().getTilex()==19 &&Entitymanager.getPlayer().getTiley()==17){
            States.setCurrentstate(handler.getGame().Win);
        }
    }
    private void getInput(){
        xMove=0;
        yMove=0;
        attackdirection=-1;
        if(handler.getKeyManager().up){
            yMove=-speed;
        }
        else if(handler.getKeyManager().down){
            yMove=+speed;
        }
        else if(handler.getKeyManager().left){
            xMove=-speed;
        }
        else if(handler.getKeyManager().right){
            xMove=+speed;
        }
        else if(handler.getKeyManager().attackup){
          attackdirection=0;
        }
        else if(handler.getKeyManager().attackdown){
            attackdirection=1;
        }
        else if(handler.getKeyManager().attackleft){
            attackdirection=2;
        }
        else if(handler.getKeyManager().attackright){
            attackdirection=3;
        }

    }


    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentframe(),(int)(x- handler.getGamecamera().getXoffset()),
                (int)(y- handler.getGamecamera().getYoffset()),width,height,null);
      //  g.setColor(Color.red);
       // g.fillRect((int)(x+12-handler.getGamecamera().getXoffset()),
      //          (int)(y+30-handler.getGamecamera().getYoffset()),10,10);
        g.setColor(Color.BLUE);
        g.setFont(new Font("kachikawawa",Font.BOLD,20));
        g.drawString("HP:",500,50);
        g.drawString(String.valueOf(Entitymanager.getPlayer().getHealth()),550,50);
    }


    private BufferedImage getCurrentframe(){
        if(xMove<0) {
            return anileft.getCurrentframe();
        }else if(xMove>0){
            return aniright.getCurrentframe();
        }
        else if(yMove>0){
            return anidown.getCurrentframe();
        }
        else if(yMove<0){return aniup.getCurrentframe();}
        else if(attackdirection==0){
            return aniattckup.getCurrentframe();
        }
        else if(attackdirection==1){
            return aniattckdown.getCurrentframe();
        }
        else if(attackdirection==2){
            return aniattckleft.getCurrentframe();
        }
        else if(attackdirection==3){
            return aniattckright.getCurrentframe();
        }
        else
            return man_down[0];

    }

    public int getTilex() {
        return tilex;
    }

    public int getTiley() {
        return tiley;
    }

    @Override
    public void attack() {
        //System.out.println("user condinate:"+tilex+ " "+tiley);
        //System.out.println("monster  corndinate"+ Entitymanager.getMonster1().getTilex()+" "+Entitymanager.getMonster1().getTiley());
            if (attackdirection == 0 && (Entitymanager.getMonster1().getTilex() - tilex == 0) && (Entitymanager.getMonster1().getTiley() - tiley == 1) &&
                    Entitymanager.getMonster1().getHealth() > 0) {
                timer4+=(System.nanoTime()-atktime2)/ns;
                if(timer4>1) {
                int tem = Entitymanager.getMonster1().getHealth();
                tem -= 20;
             //   System.out.println("monster hp" + tem);
                Entitymanager.getMonster1().setHealth(tem);
                atktime2=System.nanoTime();
                timer4=0;}
            }
            else if (attackdirection == 1 && (Entitymanager.getMonster1().getTilex() - tilex == 0) && (Entitymanager.getMonster1().getTiley() - tiley == -1) &&
                    Entitymanager.getMonster1().getHealth() > 0) {
                timer4+=(System.nanoTime()-atktime2)/ns;
                if(timer4>1) {
                    int tem = Entitymanager.getMonster1().getHealth();
                    tem -= 20;
                //    System.out.println("monster hp" + tem);
                    Entitymanager.getMonster1().setHealth(tem);
                    atktime2 = System.nanoTime();
                    timer4 = 0;
                }
            }
            else if (attackdirection == 2 && (Entitymanager.getMonster1().getTilex() - tilex == -1) && (Entitymanager.getMonster1().getTiley() - tiley == 0) &&
                    Entitymanager.getMonster1().getHealth() > 0) {
                timer4+=(System.nanoTime()-atktime2)/ns;
                if(timer4>1) {
                    int tem = Entitymanager.getMonster1().getHealth();
                    tem -= 20;
               //     System.out.println("monster hp" + tem);
                    Entitymanager.getMonster1().setHealth(tem);
                    atktime2 = System.nanoTime();
                    timer4 = 0;
                }
            }
            else if (attackdirection == 3 && (Entitymanager.getMonster1().getTilex() - tilex == 1) && (Entitymanager.getMonster1().getTiley() - tiley == 0) &&
                    Entitymanager.getMonster1().getHealth() > 0) {
                timer4+=(System.nanoTime()-atktime2)/ns;
                if(timer4>1) {
                    int tem = Entitymanager.getMonster1().getHealth();
                    tem -= 20;
                 //   System.out.println("monster hp" + tem);
                    Entitymanager.getMonster1().setHealth(tem);
                    atktime2 = System.nanoTime();
                    timer4 = 0;
                }
            }
            else if ((Entitymanager.getMonster1().getTilex() - tilex == 0) && (Entitymanager.getMonster1().getTiley() - tiley == 0) && Entitymanager.getMonster1().getHealth() > 0) {
                timer4+=(System.nanoTime()-atktime2)/ns;
                if(timer4>1){
                int tem = Entitymanager.getMonster1().getHealth();
                tem -= 20;
              //  System.out.println("monster hp" + tem);
                Entitymanager.getMonster1().setHealth(tem);
                atktime2=System.nanoTime();
                timer4=0;
               }
            }


        }

}



