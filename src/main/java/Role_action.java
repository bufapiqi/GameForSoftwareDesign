/**
 *
 *  一个角色，即人物的顶级接口，定义了一般角色的常用动作
 *
 * */
public interface Role_action {

    /**
     * 角色向右走的接口
     *
     * */
    public Role_image Role_walk_right();

    public Role_image Role_walk_left();

    public Role_image Role_walk_up();

    public Role_image Role_walk_down();

    public Role_image Role_light_attack();

    public Role_image Role_heavy_attack();
}
