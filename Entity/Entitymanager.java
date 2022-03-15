package Entity;

import Entity.creature.Monster;
import Entity.creature.players;
import kachikawawa.handler;

import java.awt.*;
import java.util.ArrayList;

public class Entitymanager {
    private handler handler;
    private static players player;
    private ArrayList<entity> entities;
    private static Monster monster1;

    public Entitymanager(handler handler,players player){
        this.handler=handler;
        this.player=player;
        entities=new ArrayList<entity>();
        monster1=new Monster(handler,100,300,100,100);
    }

    public void tick(){
        for(int i=0;i< entities.size();i++){
            entity e=entities.get(i);
            e.tick();
        }
        player.tick();
        if(Entitymanager.getMonster1().getHealth()>0) {
            monster1.tick();
        }
    }
    public  void render(Graphics g){
        for(int i=0;i<entities.size();i++){
            entity e=entities.get(i);
            e.render(g);
            if(player.checkEntityCollision(getPlayer().getxMove(), getPlayer().getyMove(),e)){
              //  System.out.println(i+" is removed");
                e.called();
                entities.remove(e);

             }//entity e in entities
          }
        player.render(g);
        if(Entitymanager.getMonster1().getHealth()>0) {
            monster1.render(g);
        }
    }

    public void addEntity(entity e){
        entities.add(e);
    }

    public kachikawawa.handler getHandler() {
        return handler;
    }

    public void setHandler(kachikawawa.handler handler) {
        this.handler = handler;
    }

    public static players getPlayer() {
        return player;
    }

    public void setPlayer(players player) {
        this.player = player;
    }

    public ArrayList<entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<entity> entities) {
        this.entities = entities;
    }

    public static Monster getMonster1() {
        return monster1;
    }

}
