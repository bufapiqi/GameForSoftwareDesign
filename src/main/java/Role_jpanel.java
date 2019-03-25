import Equipment.Equiment;
import Equipment.Equiment_enum;
import Equipment.Weapen.Weapen;
import Game_event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Role_jpanel extends JPanel {
    private ArrayList<Role> im_list = new ArrayList<Role>();
    private Image background;
    private ArrayList<Equiment> equiment_pool = new ArrayList<Equiment>(); // 掉落在界面上的装备的池子
    private Image offScreenImage;
    private LinkedList<Base_event> event_pool = new LinkedList<Base_event>();  // 事件池子

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
//        this.update(getGraphics());
    }

    @Override
    public void  paint(Graphics g1){   // 这里可能要把 Graphics传进去 让每个组件 自己画自己
        super.paint(g1);
        g1.drawImage(this.background, 0, 0, 780, 638, this);
        Hero role_hero = (Hero)im_list.get(0);
        ArrayList<Integer> need_delete = new ArrayList<Integer>();  // 保存了需要删除的monster
        for (int i = 0; i < im_list.size(); i++){
            Role temp = im_list.get(i);
            Role_image temp_image = temp.current_image;
            int width = temp_image.getWidth(this);
            int height = temp_image.getHeight(this);
            int attack_judge_x = role_hero.role_point.getX() + role_hero.current_image.getWidth(this);
            int attack_judge_y = role_hero.role_point.getY() + role_hero.current_image.getHeight(this);
            if (!(temp instanceof Hero)){
                // 判断monster的受伤害范围
                Monster temp_Monster = (Monster)temp;
                monster_bats temp_bats = (monster_bats)temp_Monster;
                temp_bats.get_Action(temp_bats.random_direction());
                if (role_hero.current_image.getAction_type() == Action_enum.LIGHT_ATTACK &&
                        attack_judge_x > temp_Monster.role_point.getX() && attack_judge_y > temp_Monster.role_point.getY() &&
                        temp_Monster.role_point.getX() > role_hero.role_point.getX() &&
                        temp_Monster.role_point.getY() > role_hero.role_point.getY()){
                    temp_Monster.setNOW_HP(temp.getNOW_HP() - role_hero.getAttack_ab());
                    if (temp_Monster.getNOW_HP() <= 0){
                        // 怪物掉落装备的代码
                        HashMap<Equiment_enum, Equiment> droped_equiment = temp_Monster.getEquiment_hashmap();
                        Weapen temp_equi = (Weapen) droped_equiment.get(Equiment_enum.Weapen);  //暂时只掉落武器
                        temp_equi.setDroped_location(new Point(temp_Monster.role_point.getX(), temp_Monster.role_point.getY()));
                        equiment_pool.add(temp_equi);
                        // 删除页面上的怪物
                        need_delete.add(i);
                        // 增加英雄的经验值
                        role_hero.raise_level(temp_Monster.droped_ex);
                        // 添加事件的代码
                        event_pool.add(new Monster_dead(temp.Role_name));
                        event_pool.add(new Droped_equipment(temp.equiment_hashmap.get(Equiment_enum.Weapen).getName()));
                    }
                }
            }else {
                // 判断英雄有没有捡什么东西
                if (role_hero.current_image.getAction_type() == Action_enum.PICK_EQUIPMENT){
                    int equimentpool_length = equiment_pool.size();
                    int current_index = 0;
                    while (equiment_pool.size() != 0 && current_index < equimentpool_length){
                        Equiment current_equiment = equiment_pool.get(current_index);

                        if (attack_judge_x > current_equiment.getDroped_location().x &&
                                attack_judge_y > current_equiment.getDroped_location().y &&
                                current_equiment.getDroped_location().x > role_hero.role_point.getX() &&
                                current_equiment.getDroped_location().y > role_hero.role_point.getY()){

                            switch (current_equiment.getEquiment_type()){
                                case Weapen:
                                    Equiment old_equiment = role_hero.add_equiment(current_equiment);
                                    Picked_equipment picked_event = new Picked_equipment(current_equiment.getName());
                                    picked_event.append(String.valueOf(((Weapen)current_equiment).getAttack_ab()));
                                    event_pool.add(picked_event);
                                    if (old_equiment != null){
                                        equiment_pool.remove(current_index);
                                        equiment_pool.add(current_equiment);
                                    }else {
                                        equiment_pool.remove(current_index);
                                        current_index --;
                                    }
                            }
                        }else {
                            current_index++;
                        }

                    }
                }
            }
            // 头顶的血条
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
//            System.out.println(temp.Role_name +"    "+(temp_image.getIm_x()+1)*width);
            // 分割线
            g1.setColor(Color.BLACK);
            g1.fillRect(0, 636, 800, 1);
            // 头像
            g1.drawImage(role_hero.getRole_head(), 0, 636, role_hero.getRole_head().getWidth(this),
                    role_hero.getRole_head().getHeight(this), this);
            // HP String
            g1.drawString("HP:", 120, 650);
            // HP 血条
            g1.drawString(String.valueOf(role_hero.NOW_HP)+"/"+String.valueOf(role_hero.HP), 160, 650);
            // 攻击力
            g1.setColor(Color.BLACK);
            g1.drawString("攻击力:", 120, 665);
            // 武器  这个估计要随机生成
            g1.drawString("武器:", 120, 680);
            if (role_hero.get_Weapon() != null){
                g1.drawString(String.valueOf(role_hero.attack_ab + role_hero.get_Weapon().getAttack_ab()),
                        160, 666);
                g1.drawString(role_hero.get_Weapon().getName(), 160, 681);
            }else {
                g1.drawString(String.valueOf(role_hero.attack_ab), 160, 666);
                g1.drawString("无装备", 160, 681);
            }
            // 防具  +1
            g1.drawString("防具:", 120, 695);
            g1.drawString("锁子甲", 160, 696);
            // 饰品  +1
            g1.drawString("饰品:", 120, 710);
            g1.drawString("麻痹戒指", 160, 711);
            // 等级
            g1.drawString("等级:", 120, 725);
            g1.drawString(String.valueOf(role_hero.level), 160, 726);
            // 经验
            g1.drawString("经验:", 120, 740);
            g1.drawString(String.valueOf(role_hero.level_ex)+"/"+String.valueOf(role_hero.now_need_ex),
                    160, 741);
            // 与事件  面板隔离
            g1.drawLine(250, 636, 250, 750);
        }
        for (int i = 0 ; i < need_delete.size(); i++){
            im_list.remove((int)need_delete.get(i));
        }
        for(int i = 0; i < equiment_pool.size(); i++){
            Weapen draw = (Weapen)equiment_pool.get(i);
//            System.out.println(draw.getDroped_location().toString());
            g1.drawImage(draw.getWeapen_image(), draw.getDroped_location().x, draw.getDroped_location().y,
                    draw.getWeapen_image().getWidth(this), draw.getWeapen_image().getHeight(this),
                    this);
        }
        int count = event_pool.size()-1;
        for (int i = 0 ; i < 3 ; i++){
            if (count >= 0){
                g1.drawString(event_pool.get(count).getEvent_description(), 260, 670 + count*20);
                count--;
            }
        }
    }

    @Override
    public void update(Graphics g){
//        super.update(g);
        if (this.offScreenImage == null){
            this.offScreenImage = this.createImage(800, 800);
        }
        Graphics gOffScreen = this.offScreenImage.getGraphics();  // 得到缓冲图像的画笔
        // 开始绘制图像
        System.out.println("ss");
//        paint(gOffScreen);
        paintComponent(gOffScreen);
        g.drawImage(offScreenImage,0, 0, null);

    }

    public void add_Role(Role im){
        im_list.add(im);
    }
}
