import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/**
 * 角色类的基类
 * 其它的角色都是继承该类的
 * */
public abstract class Role{
    protected String Role_name;
    protected int HP;
    protected int NOW_HP;
    protected int attack_ab;
    protected HashMap<Integer, Role_image> image_hashmap;
    protected Point role_point;
    protected Role_image current_image;

    public Role(String Role_name, Point role_point){
        this.Role_name = Role_name;
        this.image_hashmap = new HashMap<Integer, Role_image>();
        if ( role_point == null){
            this.role_point = new Point(0, 0);
        }else {
            this.role_point = role_point;
        }
    }

    public Role get_Action(int KeyCode){
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
//        this.current_image = image_hashmap.get(KeyCode); // 返回相应的角色动作
        update_image_x(image_hashmap.get(KeyCode));
//        role_point.printPoint();
        this.role_point.selfAdd(this.current_image.getAction_type(), 800, 800);
        return this;
    }

    public Role get_Action(Action_enum mons_direction){
//        this.current_image = image_hashmap.get(-1);
        update_image_x(image_hashmap.get(-1));
        this.role_point.selfAdd(mons_direction, 800, 800);
        return this;
    }

    public void update_image_x(Role_image temp){
        if (this.current_image == temp){
            int temp_int = this.current_image.getIm_x();
            if (temp_int < this.current_image.getAction_nums()){
                this.current_image.setIm_x(temp_int+1);
            }else {
                this.current_image.setIm_x(0);
            }
        }else {
            this.current_image.setIm_x(0);
            this.current_image = temp;
        }

    }

    public Point getRole_point() {
        return role_point;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack_ab() {
        return attack_ab;
    }

    public int getNOW_HP() {
        return NOW_HP;
    }

    public void setNOW_HP(int NOW_HP) {
        this.NOW_HP = NOW_HP;
    }

    public void setAttack_ab(int attack_ab) {
        this.attack_ab = attack_ab;
    }
}
