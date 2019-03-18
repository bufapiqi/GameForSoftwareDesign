import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;

public class KeyEventAdapter implements KeyListener {
    private jpanelTest test; // 还需要一个 IO包装类
    public KeyEventAdapter(jpanelTest a){
        test = a;
    }
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39){
            try {
                test.setIm(ImageIO.read(new FileInputStream("src/main/resources/shana_forward.png")));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        try {
            test.setIm(ImageIO.read(new FileInputStream("src/main/resources/shana_stand.png")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
