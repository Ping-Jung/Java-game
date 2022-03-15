package State;

import UI.Clicklistener;
import UI.UIImageBotton;
import UI.UImanager;
import kachikawawa.handler;
import gfx.assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Menustate extends States {
    private BufferedImage landscape;
    private UImanager uiManager;
    public Menustate(handler handler){

        super(handler);
        uiManager=new UImanager(handler);
        handler.getMousemanager().setUimanager(uiManager);
        uiManager.addObject(new UIImageBotton(250, 200, 100, 100, assets.startbotton,
                new Clicklistener() {
            @Override
            public void onClick() {
                handler.getMousemanager().setUimanager(null);
                States.setCurrentstate(handler.getGame().gamestate);
            }
        }));
        uiManager.addObject(new UIImageBotton(220, 350, 150, 40, assets.manualanack, new Clicklistener() {
            @Override
            public void onClick() {
                handler.getMousemanager().setUimanager(null);
                States.setCurrentstate(handler.getGame().manualandack);

                }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
        //System.out.println(handler.getMousemanager().getMouseX()+" ");
       // System.out.println(handler.getMousemanager().getMouseY()+" ");


    }

    @Override
    public void render(Graphics g) {

         g.drawImage(assets.landscape,0,0,600,600,null);
         uiManager.render(g);
         g.setFont(new Font("will",Font.PLAIN,50));
        g.drawString("Slimevancoff !",150,150);
        //g.setColor(Color.ORANGE);
       // g.fillRect(handler.getMousemanager().getMouseX(),handler.getMousemanager().getMouseY(),10,10);

    }


}
