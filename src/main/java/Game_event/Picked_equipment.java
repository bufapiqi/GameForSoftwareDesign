package Game_event;
/**
 *
 * 捡装备的事件
 *
 * */
public class Picked_equipment extends Base_event{
    public Picked_equipment(String equipment_name){
        this.event_type = Event_enum.PICKED_EQUIPMENT;
        this.event_description = "你捡起了 "+equipment_name + ", 攻击力 +";
    }
}
