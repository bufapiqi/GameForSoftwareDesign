import javax.swing.*;
import java.awt.*;

public class jpanelTest extends JPanel {

    private Graphics g;
    private Image im;
    private int x = 0;
    private int y = 0;
    private int actions_num = 1;
    public jpanelTest(Image im) {
        if (im != null) {
            this.im = im;
            g = im.getGraphics();
        }
    }
    public void display(int index) {
        if(g != null) {
            System.out.println("有没有到这里");
            //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
            super.paintComponent(g);
            // 设置像素
            x = 55 * index;
            //更新缓图
            this.repaint();
        }
    }

    @Override
    public void  paintComponent(Graphics g1){
//        System.out.println(im);
//        System.out.println(x);
        super.paintComponent(g1);
        if(x < actions_num){
            x = x + 1;
        }else {
            x = 0;
        }
        int width = im.getWidth(this)/actions_num;
        int height = im.getHeight(this);
        g1.drawImage(im, 0, 0,width, height,
                x*width, y, (x+1)*width, y+height,
                this);
    }

    public void setIm(Image im) {
        this.im = im;
        this.g = im.getGraphics();
    }
    public void setActions_num(int actions_num){
        this.actions_num = actions_num;
    }
}