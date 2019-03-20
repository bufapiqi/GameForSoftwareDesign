import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 *
 * 对 Image 的包装
 * Image的装饰器
 *
 * */
public class Role_image extends Image {
    private Image image;
    private int action_nums = 1;
    private Action_enum action_type;
    private int im_x = 0;
    private int im_y = 0;

    public Role_image(Image image, int action_nums, Action_enum type){
        this.image = image;
        this.action_nums = action_nums;
        this.action_type = type;
    }

    public int getWidth(ImageObserver observer) {
        int image_width = image.getWidth(observer);
        return image_width/action_nums;
    }

    public int getHeight(ImageObserver observer) {
        return image.getHeight(observer);
    }

    public ImageProducer getSource() {
        return image.getSource();
    }

    public Graphics getGraphics() {
        return image.getGraphics();
    }

    public Object getProperty(String name, ImageObserver observer) {
        return null;
    }

    public Image getImage() {
        return image;
    }

    public int getAction_nums() {
        return action_nums;
    }

    public Action_enum getAction_type() {
        return action_type;
    }

    public int getIm_x() {
        return im_x;
    }

    public int getIm_y() {
        return im_y;
    }

    public void setIm_x(int im_x) {
        this.im_x = im_x;
    }

    public void setIm_y(int im_y) {
        this.im_y = im_y;
    }
}
