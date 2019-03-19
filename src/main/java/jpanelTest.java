import javax.swing.*;
import java.awt.*;

public class jpanelTest extends JPanel {

    private Graphics g;
    private Role_image im;
    private int im_x = 0;
    private int im_y = 0;
    private Point paint_point = new Point(0, 0);
    private Action_enum now_action_type = Action_enum.STAND;
    public jpanelTest(Role_image im) {
        if (im != null) {
            this.im = im;
            this.g = im.getGraphics();
        }
    }
    public void display(int index) {
        if(g != null) {
            //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
//            super.paintComponent(g);
            // 设置像素
//            im_x = 55 * index;
            //更新缓图
            this.repaint();
        }
    }

    @Override
    public void  paintComponent(Graphics g1){
        super.paintComponent(g1);
        if(im_x < this.im.getAction_nums()){
            im_x = im_x + 1;
        }else {
            im_x = 0;
        }
        int width = im.getWidth(this);
        int height = im.getHeight(this);
        g1.drawImage(im.getImage(), paint_point.getX(), paint_point.getY(),
                paint_point.getX() + width, paint_point.getY() + height,
                im_x * width, im_y, (im_x + 1) * width, im_y + height,
                this);
        paint_point.selfAdd(this.now_action_type, 500, 500);
    }

    public void setIm(Role_image im) {
        this.im = im;
        this.g = im.getGraphics();
    }

    public void setNow_action_type(Action_enum now_action_type) {
        this.now_action_type = now_action_type;
    }

    public Graphics getG() {
        return g;
    }

    public Role_image getIm() {
        return im;
    }

    public int getIm_x() {
        return im_x;
    }

    public int getIm_y() {
        return im_y;
    }

}
