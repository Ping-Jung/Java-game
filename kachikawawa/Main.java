package kachikawawa;

import show.game;

public class Main {

    public static void main(String[] args) {
      long lastime=System.nanoTime();
	  game game=new game("SLimevancoff",600,600);
	  game.start();
	  Musicontrol player = new Musicontrol();
	  player.play();
    }
}
