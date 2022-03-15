package show;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int height,width;

    public display(String title,int width, int height){
        this.height=height;
        this.width=width;
        this.title=title;
        createdisplay();

    }
    public Canvas getCanvas(){
        return canvas;
    }
    public JFrame getFrame(){
        return frame;
    }
    private void createdisplay(){
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();

    }
}
