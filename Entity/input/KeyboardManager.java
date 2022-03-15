package Entity.input;
// eta time 1/25 will finish the whole project

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {
    private boolean[] keys;
    public boolean up,down,right,left,attackup,attackdown,attackleft,attackright;
    public KeyboardManager(){
        keys=new boolean[256];
    }

    public void tick(){
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];
        attackup=keys[KeyEvent.VK_W];             //the up down right left
        attackdown=keys[KeyEvent.VK_S];
        attackleft=keys[KeyEvent.VK_A];
        attackright=keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
}
