import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 蝙蝠类的具体类
 *
 * */
public class monster_bats extends Role{
    public monster_bats(String Role_name, Point role_points){
        super(Role_name, role_points);
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
