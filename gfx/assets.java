package gfx;

import java.awt.image.BufferedImage;

public class assets {
    public static BufferedImage  enemy1,enemy2,man,stone,wall,grass,water,dirt,stone2,flower,entry,exit,brick,bush;
    public static BufferedImage treasure,chicken,wine;
    public static BufferedImage[] man_down;//man width16 height 32
     public static BufferedImage[] man_up, man_right,man_left;//man width16 height 32
     public static BufferedImage[]  attackup,attackdown,attackright,attackleft;
     public static BufferedImage landscape;
     public static BufferedImage[] startbotton;
     public static BufferedImage[] monstermove,monsteratk;
     public static BufferedImage[] manualanack;

    public static void init(){
         landscape=imageloader.loadimage("/res/texture/Full-Background.png");
         spritesheet sheet=new spritesheet(imageloader.loadimage("/res/texture/character.png"));

         man_down=new BufferedImage[4];
         man_down[0]= sheet.crop(0,0,16,32);
         man_down[1]=sheet.crop(16,0,16,32);
         man_down[2]=sheet.crop(32,0,16,32);
         man_down[3]=sheet.crop(48,0,16,32);

         man_right =new BufferedImage[4];
         man_right[0]= sheet.crop(0,32,16,32);
         man_right[1]=sheet.crop(16,32,16,32);
         man_right[2]=sheet.crop(32,32,16,32);
         man_right[3]=sheet.crop(48,32,16,32);

         man_up=new BufferedImage[4];
         man_up[0]= sheet.crop(0,64,16,32);
         man_up[1]=sheet.crop(16,64,16,32);
         man_up[2]=sheet.crop(32,64,16,32);
         man_up[3]=sheet.crop(48,64,16,32);

         man_left=new BufferedImage[4];
         man_left[0]= sheet.crop(0,96,16,32);
         man_left[1]=sheet.crop(16,96,16,32);
         man_left[2]=sheet.crop(32,96,16,32);
         man_left[3]=sheet.crop(48,96,16,32);

         attackdown=new BufferedImage[4];
         attackdown[0]=sheet.crop(0,128,32,32);
         attackdown[1]=sheet.crop(32,128,32,32);
         attackdown[2]=sheet.crop(64,128,32,32);
         attackdown[3]=sheet.crop(96,128,32,32);

         attackup=new BufferedImage[4];
         attackup[0]=sheet.crop(0,160,32,32);
         attackup[1]=sheet.crop(32,160,32,32);
         attackup[2]=sheet.crop(64,160,32,32);
         attackup[3]=sheet.crop(96,160,32,32);

         attackright=new BufferedImage[4];
         attackright[0]=sheet.crop(0,192,32,32);
         attackright[1]=sheet.crop(32,192,32,32);
         attackright[2]=sheet.crop(64,192,32,32);
         attackright[3]=sheet.crop(96,192,32,32);

         attackleft=new BufferedImage[4];
         attackleft[0]=sheet.crop(0,224,32,32);
         attackleft[1]=sheet.crop(32,224,32,32);
         attackleft[2]=sheet.crop(64,224,32,32);
         attackleft[3]=sheet.crop(96,224,32,32);

         spritesheet landscape=new spritesheet(imageloader.loadimage("/res/texture/Overworld.png"));
         grass=landscape.crop(0,0,16,16);
         water=landscape.crop(48,64,16,16);    //
         dirt=landscape.crop(32,512,16,16);//dirt
         flower=landscape.crop(0,544,16,16);
         brick=landscape.crop(208,256,16,16);
         spritesheet lamellar=new spritesheet(imageloader.loadimage("/res/texture/roguelikeSheet_transparent.png"));
         stone=lamellar.crop(272,340,16,16);
         stone2=lamellar.crop(391,323,16,16);

         entry=lamellar.crop(595,68,16,16);
         exit=lamellar.crop(629,34,16,16);
         bush=lamellar.crop(323,154,16,16);
         treasure=lamellar.crop(851,357,16,16);
         chicken=lamellar.crop(919,255,16,16);
         wine=lamellar.crop(919,238,16,16);

         spritesheet ui=new spritesheet(imageloader.loadimage("/res/texture/UIpackSheet_transparent.png"));
         startbotton=new BufferedImage[2];
            startbotton[0]=ui.crop(376,430,16,16);
             startbotton[1]=ui.crop(484,430,16,16);

         manualanack=new BufferedImage[2];
             manualanack[1]=ui.crop(342,290,48,16);
             manualanack[0]=ui.crop(288,290,48,16);

             spritesheet dat=new spritesheet(imageloader.loadimage("/res/texture/slime spritesheet calciumtrice.png"));
             monstermove=new BufferedImage[10];
             monstermove[0]= dat.crop(0,64,32,32);
             monstermove[1]= dat.crop(32,64,32,32);
             monstermove[2]= dat.crop(64,64,32,32);
             monstermove[3]= dat.crop(96,64,32,32);
             monstermove[4]= dat.crop(128,64,32,32);
             monstermove[5]= dat.crop(160,64,32,32);
             monstermove[6]= dat.crop(192,64,32,32);
             monstermove[7]= dat.crop(224,64,32,32);
             monstermove[8]= dat.crop(256,64,32,32);
             monstermove[9]= dat.crop(288,64,32,32);



             monsteratk=new BufferedImage[10];
             monsteratk[0]=dat.crop(0,96,32,32);
             monsteratk[1]=dat.crop(32,96,32,32);
             monsteratk[2]=dat.crop(64,96,32,32);
             monsteratk[3]=dat.crop(96,96,32,32);
             monsteratk[4]=dat.crop(128,96,32,32);
             monsteratk[5]=dat.crop(160,96,32,32);
             monsteratk[6]=dat.crop(192,96,32,32);
             monsteratk[7]=dat.crop(224,96,32,32);
             monsteratk[8]=dat.crop(256,96,32,32);
             monsteratk[9]=dat.crop(288,96,32,32);


    }
}
