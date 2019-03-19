import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/**
 * 角色类的基类
 * 其它的角色都是继承该类的
 * */
public abstract class Role{
    protected String Role_name;
    protected HashMap<Integer, Role_image> image_hashmap;

    public Role(String Role_name){
        this.Role_name = Role_name;
        this.image_hashmap = new HashMap<Integer, Role_image>();
        Image shana = null;
        try {
            shana = ImageIO.read(new FileInputStream("src/main/resources/"+Role_name+"/"+Role_name+"_stand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image_hashmap.put(-1, new Role_image(shana, 4));
    }

    public Role_image get_Action(int KeyCode){
        if(image_hashmap.get(KeyCode) == null){
//            Role_image need = 需要通过工厂去获得  Class.forName(Role_name)
            String factory_name = Role_name+"_factory";
            try {
                Class factory = Class.forName(factory_name);
                Method create = factory.getMethod("create_role_action", int.class);
                image_hashmap.put(KeyCode, (Role_image) create.invoke(null, KeyCode));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return image_hashmap.get(KeyCode); // 返回相应的角色动作
    }

}
