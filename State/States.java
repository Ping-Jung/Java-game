package State;

import java.awt.*;

public abstract class States {
    private static States  currentstate=null;

    public static void setCurrentstate(States state){
        currentstate=state;
    }
    public static States getStates(){
        return currentstate;
    }


    //  class

    protected kachikawawa.handler handler;
    public States(kachikawawa.handler handler){
        this.handler=handler;
    }
    public abstract void tick() throws InterruptedException;

    public abstract void render(Graphics g);

}
