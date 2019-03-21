package Equipment.Weapen;

import Equipment.Equiment;
import Equipment.Equiment_enum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 *  武器的基本类
 *  包含武器的名字、描述、攻击力
 *  后期或者可加特效
 *
 * */
public class Weapen extends Equiment {
    protected String description;
    protected int attack_ab;
    protected Image weapen_image;
    protected Point droped_location;
    public Weapen(String name, String description, int attack_ab){
        this.name = name;
        this.description = description;
        this.attack_ab = attack_ab;
        this.droped_location = new Point(0, 0);
        this.equiment_type = Equiment_enum.Weapen;
        try {
            this.weapen_image = ImageIO.read(new FileInputStream("src/main/resources/weapon/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttack_ab() {
        return attack_ab;
    }

    public void setAttack_ab(int attack_ab) {
        this.attack_ab = attack_ab;
    }

    public Image getWeapen_image() {
        return weapen_image;
    }

    public void setWeapen_image(Image weapen_image) {
        this.weapen_image = weapen_image;
    }

    public Point getDroped_location() {
        return droped_location;
    }

    public void setDroped_location(Point droped_location) {
        this.droped_location = droped_location;
    }
}
