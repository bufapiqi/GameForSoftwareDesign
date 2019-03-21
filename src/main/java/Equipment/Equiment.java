package Equipment;

import java.awt.*;

/**
 *
 * 装备的基类
 *
 * */
public class Equiment {
    protected String name;
    protected Equiment_enum equiment_type;
    protected Point droped_location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Equiment_enum getEquiment_type() {
        return equiment_type;
    }

    public void setEquiment_type(Equiment_enum equiment_type) {
        this.equiment_type = equiment_type;
    }

    public Point getDroped_location() {
        return droped_location;
    }

    public void setDroped_location(Point droped_location) {
        this.droped_location = droped_location;
    }
}
