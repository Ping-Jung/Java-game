package State;
import UI.Clicklistener;
import UI.UIImageBotton;
import UI.UImanager;
import gfx.assets;
import kachikawawa.handler;

import java.awt.*;

public class ManualnandAck extends States {
    private UImanager uImanager;

    public ManualnandAck(handler handler) {
        super(handler);
        uImanager=new UImanager(handler);
    //   handler.getMousemanager().setUimanager(uImanager);
        uImanager.addObject(new UIImageBotton(500,520 , 50, 50, assets.startbotton,
                new Clicklistener() {
                    @Override
                    public void onClick() {
                        handler.getMousemanager().setUimanager(null);
                        States.setCurrentstate(handler.getGame().gamestate);
                    }
                }));

    }

    @Override
    public void tick() {
        uImanager.tick();
    }

    @Override
    public void render(Graphics g) {

           g.drawImage(assets.landscape,0,0,600,600,null);
           uImanager.render(g);
           g.setFont(new Font("shirley",Font.PLAIN,15));
           g.drawString("Manual", 20, 30);
           g.drawString("press w=attack (up)", 20, 60);
           g.drawString("press s=attack (down)", 20, 90);
           g.drawString("press a=attack (left)", 20, 120);
           g.drawString("press w=attack (right)", 20, 150);
           g.drawString("use direction key to control the character", 20, 180);
           g.drawString("the player has hp 200,each attack on slime will cause the slime lose hp 20", 20, 210);
           g.drawString("try your best to beat the monster and find the way out", 20, 240);
           g.drawString("now as long as you reach the end point you will win", 20, 270);
           g.drawString("(due to time lacking,next update will be done after the report has been sent)", 20, 300);
           g.drawString("three treasures are hidden in the map that you can increase your hp or mp", 20, 330);
           g.drawString("acknowledgement", 20, 420);
           g.drawString("thanks for those people who provide the spritesheet ", 20, 450);
           g.drawString("-due to technical error please close the game and click the play botton in menu"
                   ,20 ,480);


    }

}

/* final JFrame frame = new JFrame("JTextArea Demo");
        JTextArea ta = new JTextArea(10, 20);

        JScrollPane sp = new JScrollPane(ta);

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 220);
        frame.getContentPane().add(sp);

        frame.setVisible(true);*/
 /*
manual:
press w=attack (up)
press s=attack (down)
press a=attack (left)
press w=attack (right)
using direction key to control the character
the player has hp 200,each attack on slime will cause the slime lose hp 20
try your best to beat the monster and find the way out
the system is design to have to kill all the monster so that the game can shut down
(due to time lacking,this update will after the report has been sent)
three treasures are hidden in the map that you can increase your hp or mp


acknowledgement
thank for those people who provide the spritesheet that the game can be created




  */