/**
 *
 * Mosnter 类 用来与Hero区分
 *
 * */
public class Monster extends Role{
    protected int droped_ex;
    public Monster(String role_name, Point role_point){
        super(role_name, role_point);
    }

    public int getDroped_ex() {
        return droped_ex;
    }

    public void setDroped_ex(int droped_ex) {
        this.droped_ex = droped_ex;
    }
}
