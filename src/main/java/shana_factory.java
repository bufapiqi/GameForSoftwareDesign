import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 夏娜的工厂类
 * 用于创建夏娜的各种动作的Role_factory
 *
 * */
public class shana_factory extends Role_action_factory{

    public static Role_image create_role_action(int keyCode) {
        Role_image need_return = null;
        try {
            if ( keyCode == 39){
                Image shana = ImageIO.read(new FileInputStream("src/main/resources/shana/shana_forward.png"));
                need_return = new Role_image(shana, 8);
            }else if (keyCode == 37){
                Image shana = ImageIO.read(new FileInputStream("src/main/resources/shana/shana_rollback.png"));
                need_return = new Role_image(shana, 8);
            }else if (keyCode == 81){
                Image shana = ImageIO.read(new FileInputStream("src/main/resources/shana/shana_light_attack.png"));
                need_return = new Role_image(shana, 7);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return need_return;
    }
}
