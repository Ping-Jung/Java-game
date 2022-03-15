package State;

import gfx.assets;

import java.awt.*;

public class Lose extends States{

    public Lose(kachikawawa.handler handler){

        super(handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(assets.landscape,0,0,600,600,null);
        g.setFont(new Font("raven",Font.BOLD,30));
        g.drawString("You Lose",230,250);
        g.drawString("never gonna give you up!",120,300);
        g.setFont(new Font("raven",Font.BOLD,15));
        g.drawString("(press x to end game)",230,330);

    }

}
