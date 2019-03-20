import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Role_jpanel extends JPanel {
    // 估计需要一个role_image的队列，或者说arraylist
    private ArrayList<Role> im_list = new ArrayList<Role>();

    public Role_jpanel(Role im) {
        if (im != null) {
            im_list.add(im);
        }
    }
    public void display(int index) {
        //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
//            super.paintComponent(g);
        // 设置像素
//            im_x = 55 * index;
        //更新缓图
        this.repaint();
    }

    @Override
    public void  paintComponent(Graphics g1){
        super.paintComponent(g1);
        for (int i = 0; i < im_list.size(); i++){
            Role temp = im_list.get(i);
            Role_image temp_image = temp.current_image;
            int width = temp_image.getWidth(this);
            int height = temp_image.getHeight(this);
            if (temp instanceof monster_bats){  // 这里可能需要修改设计模式
                monster_bats temp_bats = (monster_bats)temp;
                temp_bats.get_Action(temp_bats.random_direction());
            }
            temp.update_image_x(temp_image);
            g1.drawImage(temp_image.getImage(), temp.role_point.getX(), temp.role_point.getY(),
                    temp.role_point.getX()+width, temp.role_point.getY()+height,
                    temp_image.getIm_x()*width, temp_image.getIm_y(),
                    (temp_image.getIm_x()+1)*width, temp_image.getIm_y()+height,
                    this);
        }
    }

    public void add_Role(Role im){
        im_list.add(im);
    }
}
