package Entity.input;

import UI.UImanager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mousemanager implements MouseListener, MouseMotionListener {
    private boolean rightpressed,leftpressed;
    private int mouseX,mouseY;
    private  UImanager uimanager;

    public Mousemanager(){

    }
    public void setUimanager(UImanager uimanager) {
        this.uimanager = uimanager;
    }


    public boolean isRightpressed() {
        return rightpressed;
    }

    public boolean isLeftpressed() {
        return leftpressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            leftpressed=true;

        else if(e.getButton()==MouseEvent.BUTTON3)
            rightpressed=true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            leftpressed=false;

        else if(e.getButton()==MouseEvent.BUTTON3)
            rightpressed=false;
        if (uimanager !=null)
            uimanager.onMouserelease(e);


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if (uimanager !=null)
            uimanager.onMousemove(e);

    }
}
