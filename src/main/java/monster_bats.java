import Equipment.Equiment;
import Equipment.Weapen.yitian_sword;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 蝙蝠类的具体类
 *
 * */
public class monster_bats extends Monster {
    public monster_bats(String Role_name, Point role_points, int HP, int origin_attack_ab){
        super(Role_name, role_points);
        this.HP = HP;
        this.NOW_HP = HP;
        this.attack_ab = origin_attack_ab;
        this.droped_ex = 10;
        //暂时先放倚天剑进去瞅瞅  这个估计要放进工厂里生产 随机生产
        Equiment yitian = new yitian_sword();
        this.equiment_hashmap.put(yitian.getEquiment_type(), yitian);
        //暂时先放倚天剑进去瞅瞅
        Image bats = null;
        try {
            bats = ImageIO.read(new FileInputStream("src/main/resources/"+Role_name+"/"+Role_name+"_stand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.current_image = new Role_image(bats, 5, Action_enum.STAND);
        this.image_hashmap.put(-1, this.current_image);
    }

    public Action_enum random_direction(){
        int random = (int)(Math.random()*5);
        if (random == 0){
            return Action_enum.STAND;
        }else if( random == 1){
            return Action_enum.UP;
        }else if ( random == 2){
            return Action_enum.RIGHT;
        }else if (random == 3){
            return Action_enum.DOWN;
        }else if (random == 4){
            return Action_enum.LEFT;
        }
        return Action_enum.STAND;
    }
}
