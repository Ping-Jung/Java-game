package UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageBotton extends UIobject{
    private BufferedImage[] images;
    private Clicklistener click;

    public UIImageBotton(float x, float y, int width, int height, BufferedImage []images,Clicklistener click){
        super(x,y,width,height);
        this.click=click;
        this.images=images;
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if(hovering){
            g.drawImage(images[1],(int) x,(int) y,  width, height, null );
        }
        else
            g.drawImage(images[0],(int) x,(int) y,  width, height, null );


    }

    @Override
    public void onClick() {
        click.onClick();
    }
}
