package State;

import gfx.assets;

import java.awt.*;

public class Win extends States{
        public Win(kachikawawa.handler handler){
                super(handler);
        }

        @Override
        public void tick() {

        }

        @Override
        public void render(Graphics g) {
                g.drawImage(assets.landscape,0,0,600,600,null);
                g.setFont(new Font("raven",Font.BOLD,30));
                g.drawString("You WIN!",230,250);
                g.drawString("It's time to watch PUI PUI!",120,300);
                g.setFont(new Font("raven",Font.BOLD,15));
                g.drawString("(press x to end game)",230,330);

        }

}