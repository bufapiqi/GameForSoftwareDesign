import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 继承基类
 * 可以自己再添加一些方法
 *
 * */
public class Role_shana extends Hero {
    public Role_shana(String Role_name, Point role_point, int HP, int origin_attack_ab) {
        super(Role_name, role_point);
        this.NOW_HP = HP;
        this.HP = HP;
        this.attack_ab = origin_attack_ab;
        Image shana = null;
        try {
            shana = ImageIO.read(new FileInputStream("src/main/resources/"+Role_name+"/"+Role_name+"_stand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.current_image = new Role_image(shana, 4, Action_enum.STAND);
        this.image_hashmap.put(-1, this.current_image);
    }
}
