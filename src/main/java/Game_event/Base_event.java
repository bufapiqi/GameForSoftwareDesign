package Game_event;
/**
 * 游戏内需要打印的基础事件s
 *
 * */
public class Base_event {
    protected Event_enum event_type;
    protected String event_description;

    public Event_enum getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Event_enum event_type) {
        this.event_type = event_type;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public void append(String append_content){
        this.event_description = this.event_description + append_content;
    }
}
