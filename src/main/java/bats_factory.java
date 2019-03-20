import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 蝙蝠怪的工厂类
 * 用于创建蝙蝠的各种动作的工厂类
 *
 * */
public class bats_factory extends Role_action_factory{

    public static Role_image create_role_action(int keyCode){
        Role_image need_return = null;
        try {
            Image bats = ImageIO.read(new FileInputStream("src/main/resources/bats/bats_stand.png"));
            need_return = new Role_image(bats, 5, Action_enum.STAND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return need_return;
    }
}
