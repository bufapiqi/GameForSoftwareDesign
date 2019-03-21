package Game_event;
/**
 *
 * 掉落装备的事件
 *
 * */
public class Droped_equipment extends Base_event{
    public Droped_equipment(String equipment_name){
        this.event_type = Event_enum.DROPED_EQUIPMENTS;
        this.event_description = equipment_name + " 掉落了，这是神器啊！！！！";
    }
}
