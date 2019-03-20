import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Role_jpanel extends JPanel {
    // 估计需要一个role_image的队列，或者说arraylist
    private ArrayList<Role> im_list = new ArrayList<Role>();
    private Image background;

    public Role_jpanel(Role im) {
        if (im != null) {
            im_list.add(im);
        }
        try {
            background = ImageIO.read(new FileInputStream("src/main/resources/backgrounds.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
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
        g1.drawImage(this.background, 0, 0, 780, 638, this);
        ArrayList<Integer> need_delete = new ArrayList<Integer>();
        Role role_hero = im_list.get(0);
        for (int i = 0; i < im_list.size(); i++){
            Role temp = im_list.get(i);
            Role_image temp_image = temp.current_image;
            int width = temp_image.getWidth(this);
            int height = temp_image.getHeight(this);
            if (!(temp instanceof Role_shana)){
                monster_bats temp_bats = (monster_bats)temp;
                temp_bats.get_Action(temp_bats.random_direction());
                int attack_judge_x = role_hero.role_point.getX() + role_hero.current_image.getWidth(this);
                int attack_judge_y = role_hero.role_point.getY() + role_hero.current_image.getHeight(this);
                if (role_hero.current_image.getAction_type() == Action_enum.LIGHT_ATTACK &&
                        attack_judge_x > temp.role_point.getX() && attack_judge_y > temp.role_point.getY() &&
                    temp.role_point.getX() > role_hero.role_point.getX() &&
                    temp.role_point.getY() > role_hero.role_point.getY()){
                    temp.setNOW_HP(temp.getNOW_HP() - role_hero.getAttack_ab());
                    if (temp.getNOW_HP() <= 0){
                        need_delete.add(i);
                    }
                }
            }
            // tou ding de xue tiao
            g1.setColor(Color.red);
            int temp_width = (int)(((double)temp.getNOW_HP() / (double)temp.getHP()) * 40);
            g1.drawRect(temp.role_point.getX() + 20, temp.role_point.getY()-10, 40, 10);
            g1.fillRect(temp.role_point.getX() + 20, temp.role_point.getY()-10, temp_width, 10);

            temp.update_image_x(temp_image);
            g1.drawImage(temp_image.getImage(), temp.role_point.getX(), temp.role_point.getY(),
                    temp.role_point.getX()+width, temp.role_point.getY()+height,
                    temp_image.getIm_x()*width, temp_image.getIm_y(),
                    (temp_image.getIm_x()+1)*width, temp_image.getIm_y()+height,
                    this);
            // 分割线
            g1.setColor(Color.BLACK);
            g1.fillRect(0, 636, 800, 1);
            // HP String
            g1.drawString("HP:", 20, 650);
            // HP 血条
            g1.setColor(Color.red);
            int now_width = (role_hero.NOW_HP / role_hero.getHP()) * 40;
            g1.drawRect(50, 640, 40, 10);
            g1.fillRect(50, 640, now_width, 10);
            // 攻击力
            g1.setColor(Color.BLACK);
            g1.drawString("攻击力:", 20, 670);
            g1.drawString(String.valueOf(role_hero.attack_ab), 60, 671);
            // 武器  这个估计要随机生成
            // 防具  +1
            // 饰品  +1
            // 与事件  面板隔离
            g1.drawLine(250, 636, 250, 750);
            // 英雄头像
//            Role_shana shana_hero = (Role_shana)role_hero;
//            g1.drawImage(shana_hero.getShana_head(), 0, 636, 64, 700,
//                    0, 0, 64, 64, this);
        }
        for (int i = 0 ; i < need_delete.size(); i++){
            im_list.remove((int)need_delete.get(i));
        }
    }

    public void add_Role(Role im){
        im_list.add(im);
    }
}
