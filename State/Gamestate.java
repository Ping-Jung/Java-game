package State;

import java.awt.*;

import World.worlds;

public class Gamestate extends  States{
    private worlds tworld;

    public Gamestate(kachikawawa.handler handler){
       super(handler);
       tworld=new worlds(handler,"C:\\Users\\william\\OneDrive\\桌面\\java上課用\\ideaproject\\project\\巫秉融-b08502173\\src\\res\\worlds\\world1.txt");
       handler.setWorld(tworld);
     //  game.getGamecamera().move(200,100);
     
    }
    

    @Override
    public void tick()  {
        tworld.tick();
    }

    @Override
    public void render(Graphics g) {
        tworld.render(g);

    }
}
