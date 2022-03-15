package Entity.creature;

import Entity.Entitymanager;
import Tiles.tile;
import gfx.Animation;
import gfx.assets;
import kachikawawa.handler;
                                                                 //that the pointer think the they have already gone to the right place
import Utils.util;                                               // also the range is too big will appear BFS null pointer exception
                                                                 //lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 20

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Monster extends creature {           //monster 64*64 pixels

    int harmness;
    int movespeed = 10;
    int hp;
    private Animation monstermove,monsteratk;
    private long lastime,timer,timer2,timer3;
    private long walktime,atktime;
    private int tilex,tiley;
    private int BFSx,BFSy;
    protected boolean comfirmatk;
    public boolean touchable(){
     return false;
    }
    final double ns=1000000000;

    public Monster(kachikawawa.handler handler, float x, float y, int width, int height) {
        super(handler, x, y,width,height);
        collisionbound.x = 30;
        collisionbound.y = 70;
        collisionbound.width =45;
        collisionbound.height = 30;
        monstermove=new Animation(100, assets.monstermove);
        monsteratk=new Animation(100,assets.monsteratk);
        lastime=System.nanoTime();
        walktime=System.nanoTime();
        atktime=System.nanoTime();
        hp=350;
    }



    @Override
    public void tick() {
        comfirmatk=false;
        int atx=Entitymanager.getPlayer().getTilex();
        int aty=Entitymanager.getPlayer().getTiley();
        tilex = (int) ((y + 30) / 60);
        tiley = (int) ((x + 30) / 60);
        if( ((atx - tilex) == 1 &&(aty - tiley) == 0) || ((atx - tilex) == 0 && (aty - tiley) == 1) ||
                ((atx - tilex) == -1 && (aty - tiley) == 0) ||
                ((atx - tilex) == 0 && ((aty - tiley) == -1))||((atx - tilex) == 0 && ((aty - tiley) == 0))){
            comfirmatk=true;
            attack();
            monsteratk.tick();

        }


        // left right down up or using area
         else {
            move();
            monstermove.tick();
        }

  //     System.out.println("monster cordinate+"+tilex+" "+tiley);
    }

    public int getTilex() {
        return tilex;
    }

    public int getTiley() {
        return tiley;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getcurrentFrame(),(int)(x- handler.getGamecamera().getXoffset()),
                (int)(y- handler.getGamecamera().getYoffset()),width,height,null);
        g.setColor(Color.BLUE);
        g.setFont(new Font("kachikawawa",Font.BOLD,20));
        g.drawString("HP(M):",480,100);
        g.drawString(String.valueOf(Entitymanager.getMonster1().getHealth()),550,100);
      //   g.setColor(Color.red);
       //  g.fillRect((int)(x+45-handler.getGamecamera().getXoffset()),(int)(y+80-handler.getGamecamera().getYoffset()),10,10);

    }
  @Override
   public void move() {
        if (detect()) {
           // System.out.println("monster cordinate:+" + getX() + " y" + getY());
            timer += (System.nanoTime()-lastime)/ ns;
            timer2+=(System.nanoTime()-walktime)/ns;
            if(distance()<100){
            //    System.out.println("near mode");
             xMove=dependonx();                  // short range
             yMove=dependonY();
            }
            else if(distance()>100) {
                xMove = getBFSx();
                yMove = getBFSy();
              //  System.out.println("BFS mode");
            }
            if(timer2>1) {
                if (xMove != 0) {
                    //     System.out.println("initiate on xvariable");
                    moveX();
                }
                if (yMove != 0) {
                  //  System.out.println("initiate on yvariable");
                    moveY();
                }
                walktime=System.nanoTime();
                timer2=0;
            }
            if (timer>1 && distance()>100) {
                     BFS();
                    lastime = System.nanoTime();
                  //  System.out.println(timer);
                    timer=0;
                }
            }

        }

    public int distance(){
        int a=(int)Math.sqrt((Entitymanager.getPlayer().getX() - x) * (Entitymanager.getPlayer().getX() - x) + (
                Entitymanager.getPlayer().getY() - y) * (
                Entitymanager.getPlayer().getY() - y));
     //   System.out.println(a);
        return a;
    }


    public boolean detect() {
        if (distance() < 14400000) {
          //  System.out.println("monster has initiated");
            return true;
        }
        else return false;

    }

    private BufferedImage getcurrentFrame() {
        int atx = Entitymanager.getPlayer().getTilex();
        int aty = Entitymanager.getPlayer().getTiley();

        if (((atx - tilex) == 1 && (aty - tiley) == 0) || ((atx - tilex) == 0 && (aty - tiley) == 1) ||
                ((atx - tilex) == -1 && (aty - tiley) == 0) ||
                ((atx - tilex) == 0 && ((aty - tiley) == -1))||((atx - tilex) == 0 && (aty - tiley) == 0) ) {
            return monsteratk.getCurrentframe();

        }
        else return monstermove.getCurrentframe();
    }



    @Override
    public void attack() {
        timer3 += (System.nanoTime()-atktime)/ ns;
        if(timer3>4){
            if(comfirmatk=true) {
            //    System.out.println("comfirmatk !");
                int tem = Entitymanager.getPlayer().getHealth();
                tem -= 20;
                if ((tem) >= 0) {
                    Entitymanager.getPlayer().setHealth(tem);
                //    System.out.println("player hp:" + tem);
                }
                atktime = System.nanoTime();
                timer3 = 0;
            }
            else
                atktime = System.nanoTime();
                timer3 = 0;

        }
    }
    public int dependonx() {
        xMove=0;
        if (Math.abs((x + movespeed)- Entitymanager.getPlayer().getX()) <Math.abs(x - Entitymanager.getPlayer().getX())) {
            //2 condition // 1.know the way // 2.and know where the player are
            xMove = +movespeed;
            return (int)xMove;
        } else if (Math.abs((x - movespeed) - Entitymanager.getPlayer().getX()) <Math.abs (x - Entitymanager.getPlayer().getX())
        ) {
            xMove = -movespeed;
            return (int) xMove;
        }
        else  return 0;
    }
    public int dependonY(){
        yMove=0;
        if (Math.abs((y + movespeed) - Entitymanager.getPlayer().getY()) < Math.abs(y - Entitymanager.getPlayer().getY())) {
            yMove = +movespeed;
            return (int)yMove;
        }
        else if (Math.abs((y - movespeed) - Entitymanager.getPlayer().getY()) <Math.abs(y - Entitymanager.getPlayer().getY())) {
            yMove = -movespeed;
            return (int)yMove;
        }
        else  return 0;
    }
    public int  getBFSx() {
        xMove=0;
        if(BFSx>0){
            xMove=movespeed;
            //   System.out.println("move x");
            return (int)xMove;
        }
        else if(BFSx<0) {
            xMove = -movespeed;
            //   System.out.println("move x");

            return (int) xMove;
        }
        else
            return 0;
    }

    public void setBFSx(int data) {
        this.BFSx=data;
    }

    public int getBFSy() {
        yMove=0;
        if(BFSy>0){
            yMove=movespeed;
            // System.out.println("move y");
            return (int)yMove;
        }
        else if(BFSy<0){
            yMove=-movespeed;
            //   System.out.println("move y");
            return (int)yMove;
        }
        else
            return 0;
    }

    public void setBFSy(int data) {
        this.BFSy=data;
    }



    public void BFS() {
        int startpointx, startpointy, endpointx, endpointy, spawnX, spawnY;
        startpointx = tilex;
        startpointy = tiley;
        endpointx = Entitymanager.getPlayer().getTilex();
        endpointy = Entitymanager.getPlayer().getTiley();
        String file = Utils.util.loadfileasString("res/worlds/world1.txt");
        String[] tokens = file.split("\\s+");
        //  spawnX=Utils.util.parseInt(tokens[2]);
        //  spawnY=Utils.util.parseInt(tokens[3]);

        int[][] tileworld = new int[20][20];
        int[][] record = new int[20][20];
        int[][] path = new int[20][20];

        try {
            for (int x = 0; x < 20; x++) {
                for (int y = 0; y < 20; y++) {
                    tileworld[x][y] = Utils.util.parseInt(tokens[(x + y * 20) + 4]);
                }
            }
     /*   for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                System.out.print(tileworld[y][x]+" ");
            }
            System.out.println();
        } */
            for (int h = 0; h < 20; h++) {
                for (int j = 0; j < 20; j++) {
                    path[h][j] = 0;
                    if (tileworld[j][h] == 4 || tileworld[j][h] == 3 || tileworld[j][h] == 2 || tileworld[j][h] == 6 || tileworld[j][h] == 7) {
                        record[h][j] = 2;
                    } else {
                        record[h][j] = 0;
                    }
                }
            }

            record[endpointx][endpointy] = 3;        //end point  2,14    1 18,6 2
            record[startpointx][startpointy] = 4;
            //start point
     /*  for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                System.out.print(record[x][y] + " ");
            }
            System.out.println();
         }   */

            int x = startpointx, y = startpointy;
            int stage = 0;
            ArrayList<Cordinate> database = new ArrayList<>();
            Queue<Cordinate> store = new LinkedList<>();
            Stack<Cordinate> reverse = new Stack<>();
            while (x != endpointx || y != endpointy) {
                stage++;
                if (record[x + 1][y] == 0 || record[x + 1][y] == 3) {
                    record[x + 1][y] = 9;
                    Cordinate a = new Cordinate((x + 1), y, stage);
                    a.addLInk(x, y);
                    store.offer(a);
                    database.add(a);
                    //    System.out.println("push" + (x + 1) + " " + y);
                }

                if (record[x][y + 1] == 0 || record[x][y + 1] == 3) {
                    record[x][y + 1] = 9;
                    Cordinate a = new Cordinate((x), (y + 1), stage);
                    a.addLInk(x, y);
                    store.offer(a);
                    database.add(a);
                    //  System.out.println("push" + (x) + " " + (y + 1));
                }

                if (record[x - 1][y] == 0 || record[x - 1][y] == 3) {
                    record[x - 1][y] = 9;
                    Cordinate a = new Cordinate((x - 1), y, stage);
                    a.addLInk(x, y);
                    store.offer(a);
                    database.add(a);
                    //    System.out.println("push" + (x - 1) + " " + y);
                }
                if (record[x][y - 1] == 0 || record[x - 1][y] == 3) {
                    record[x][y - 1] = 9;
                    Cordinate a = new Cordinate(x, (y - 1), stage);
                    a.addLInk(x, y);
                    store.offer(a);
                    database.add(a);
                    //  System.out.println("push" + "  (" + x + " " + (y - 1) + ")");
                } else {
                    Cordinate b = store.poll();
                    x = b.getX();
                    y = b.getY();
                    stage = b.getStage();
                    //   System.out.println("pop" + "  (" + x + " " + y + ")"+" "+store.size());
                }
            }


       /*for (int a= 0; a < 20; a++) {
            for (int b = 0; b < 20; b++) {
                System.out.print(record[a][b]+" ");
            }
            System.out.println();
         }  */
//find path and data record
            int sie = database.size();
            //      System.out.println(sie);

            int d = database.size();
            int g = d, f = d;
            //find destination
            int destinX, destinY, destinStage, destinPAx = 0, destinPAy = 0;
            destinStage = 0;
            Cordinate finddes = new Cordinate(0, 0, 0);

            for (int r = g; r > 0; r--) {
                d--;
                finddes = database.get(d);
                destinX = finddes.getX();
                destinY = finddes.getY();
                destinStage = finddes.getStage();
                destinPAx = finddes.getPapax();
                destinPAy = finddes.getPapay();
                if (destinX == endpointx && destinY == endpointy) {
                    //        System.out.println("found" + " end point:" + "(" + finddes.getX() + " " + finddes.getY() + ")");
                    break;
                }

            }
            Queue<Cordinate> route = new LinkedList<>();
            boolean firstuse = true;
            boolean seconduse = false;
            Cordinate eachpoint = new Cordinate(0, 0, 1);
            int eachStagex, eachStageY;
            int nextStagex = 0, nextStageY = 0;
            int storex = 0, storey = 0;
            for (int startfin = 0; startfin < (destinStage - 1); startfin++) {
                d = database.size();
                for (int r = g; r > 0; r--) {
                    d--;
                    eachpoint = database.get(d);
                    eachStagex = eachpoint.getX();
                    eachStageY = eachpoint.getY();
                    nextStagex = eachpoint.getPapax();
                    nextStageY = eachpoint.getPapay();
                    if (eachStagex == destinPAx && eachStageY == destinPAy && firstuse) {
                        firstuse = false;
                        seconduse = true;
                        route.add(eachpoint);
                        //   System.out.println("add point: "+ eachStagex+" "+eachStageY);
                        //   System.out.println("head to next point: "+nextStagex+" "+nextStageY);
                        storex = nextStagex;
                        storey = nextStageY;
                        //    System.out.println(storex+" "+storey);
                        continue;
                    } else if (eachStagex == storex && eachStageY == storey && seconduse) {
                        //    System.out.println("add point: "+ eachStagex+" "+eachStageY);
                        //    System.out.println("head to next point: "+nextStagex+" "+nextStageY);
                        route.add(eachpoint);
                        storex = nextStagex;
                        storey = nextStageY;
                        //    System.out.println(storex+" "+storey);
                        continue;
                    }

                }

            }


    /*    for (int r = g; r > 0; r--) {
            f--;
            int w, e, t,m,a;
            Cordinate c = database.get(f);
            w = c.getX();
            e = c.getY();
            t = c.getStage();
            m=c.getPapax();
            a=c.getPapay();
            System.out.println("x:" + w + " " + "y:" + e + " stage:" + t+"papa:"+m+" "+a);
            path[w][e] = 1;

        }        */
            int pathpirnt = route.size();
            if (pathpirnt != 0) {
                for (int k = 0; k < pathpirnt; k++) {
                    int pathx, pathy;
                    Cordinate c = route.remove();
                    pathx = c.getX();
                    pathy = c.getY();
                    reverse.push(c);
                    //   System.out.println(pathx+" "+pathy);
                    path[pathx][pathy] = 1;
                }
                path[endpointx][endpointy] = 3;        //end point  2,14
                path[startpointx][startpointy] = 4;


           /* for (int k = 0; k < pathpirnt; k++) {
                int pathx, pathy;
                Cordinate c = reverse.pop();
                pathx = c.getX();
                pathy = c.getY();
                System.out.println(pathx + " " + pathy);
                //path[pathx][pathy]=1;
            }
            */
                int gopathx, gopathy;
                int tem = reverse.size();
                if (tem != 0) {
                    Cordinate road = reverse.pop();
                    gopathx = road.getX();
                    gopathy = road.getY();
                    //System.out.println("path: (" + gopathx + " " + gopathy + ")");
                    if ((gopathx - tilex) != 0) {
                        int a = 1;
                        if (gopathx > tilex) {
                         //   System.out.println("move by y+");

                            setBFSy(a);
                        } else
                            a = -1;
                     //   System.out.println("move by y-");
                        setBFSy(a);
                    }
                    if ((gopathy - tiley) != 0) {
                        int a = 1;
                        if (gopathy > tiley) {
                       //     System.out.println("move by x+");
                            setBFSx(a);
                        } else
                            a = -1;
                   //     System.out.println("move by x-");
                        setBFSx(a);
                    }
                }
            }
        /*    for (int a = 0; a < 20; a++) {
                for (int b = 0; b < 20; b++) {
                    System.out.print(path[a][b] + " ");
                }
                System.out.println();
            }  */

        } catch (NullPointerException e) {
         //   System.out.println("null pointer");
        }catch (ArrayIndexOutOfBoundsException e){
         //   System.out.println("array out of bound");
        }

    }


}
