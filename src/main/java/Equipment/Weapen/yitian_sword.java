package Equipment.Weapen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * 倚天剑 传说中的神器！
 *
 * */
public class yitian_sword extends Weapen{
    public yitian_sword(String name, String description, int attack_ab) {
        super(name, description, attack_ab);
    }
    public yitian_sword(){
        super("yitian_sword", "传说中的神器，曹操的佩剑，锋利无比",10);
    }
}
