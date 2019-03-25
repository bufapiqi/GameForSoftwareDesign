import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * Hero 的类 集成Role类
 *
 * */
public class Hero extends Role{
    protected Image role_head;
    protected int level;
    protected int level_ex;
    protected int now_need_ex;
    public Hero(String Role_name, Point role_point){
        super(Role_name, role_point);
        this.level = 1;
        this.level_ex = 0;
        this.now_need_ex = 10;
        try {
            role_head = ImageIO.read(new FileInputStream("src/main/resources/"+Role_name+"/"+Role_name+"_head.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void raise_level(int gain_ex){
        level_ex += gain_ex;
        while (level_ex >= now_need_ex){
            //增加攻击力 血上线 血恢复满
            level+=1;
            level_ex = level_ex - now_need_ex;
            now_need_ex = (int)(now_need_ex * 1.5);
            HP += 100;
            NOW_HP = HP;
            attack_ab += 10;
        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevel_ex(int level_ex) {
        this.level_ex = level_ex;
    }

    public Image getRole_head() {
        return role_head;
    }

    public int getLevel() {
        return level;
    }

    public int getLevel_ex() {
        return level_ex;
    }
}
