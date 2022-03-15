package UI;

import kachikawawa.handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Handler;

public class UImanager {

    private handler handler;
    private ArrayList<UIobject> objects;




    public UImanager(handler handler){
         this.handler=handler;
         objects=new ArrayList<UIobject>();
    }
    public void tick(){

         for(UIobject o:objects){
             o.tick();
         }
    }
    public void render(Graphics g){
        for(UIobject o:objects){
            o.render(g);
        }
    }
    public void onMousemove(MouseEvent e){
        for(UIobject o:objects){
            o.onMousemove(e);
        }
    }
    public void onMouserelease(MouseEvent e){
        for(UIobject o:objects){
            o.onMouserelease(e);;
        }
    }
    public void addObject(UIobject o){
        objects.add(o);
    }
    public void removeObject(UIobject o){
        objects.remove(o);
    }


    public handler getHandler() {
        return handler;
    }

    public void setHandler(handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIobject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIobject> objects) {
        this.objects = objects;
    }
}
