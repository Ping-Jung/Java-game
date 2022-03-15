package kachikawawa;

import Entity.input.KeyboardManager;
import Entity.input.Mousemanager;
import World.worlds;
import gfx.gamecamera;
import show.game;

public class handler {

    private game game;
    private worlds world;

    public handler(game game){
       this.game=game;
    }
    public gamecamera getGamecamera(){
        return game.getGamecamera();
    }

    public KeyboardManager getKeyManager(){
        return game.getKeymanager();
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }

    public Mousemanager getMousemanager(){
        return game.getMousemanager();
    }

    public show.game getGame() {
        return game;
    }

    public void setGame(show.game game) {
        this.game = game;
    }

    public worlds getWorld() {
        return world;
    }

    public void setWorld(worlds world) {
        this.world = world;
    }
}
