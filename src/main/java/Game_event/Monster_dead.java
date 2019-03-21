package Game_event;
/**
 *
 * Monster dead事件
 *
 * */
public class Monster_dead extends Base_event{
    public Monster_dead(String monster_name){
        this.event_type = Event_enum.MONSTER_DEAD;
        this.event_description = monster_name + "  死了！！！";
    }
}
