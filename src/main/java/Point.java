/**
 * 坐标类
 *
 * */
public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void selfAdd(Action_enum action_type, int width, int height){
        switch (action_type){
            case RIGHT:
                x = (x+10) > width ? 0 : x+10;
                break;
            case LEFT:
                x = (x-10) > 0 ? x-10 : width;
                break;
            case UP:
                y = (y-10) < 0 ? height : y -10;
                break;
            case DOWN:
                y = (y+10) > height ? 0 : y+10;
                break;
            case LIGHT_ATTACK:
                break;
            case HEAVY_ATTACK:
                break;
            case STAND:
                break;
        }
    }
    public void printPoint(){
        System.out.println(x+"     "+y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
