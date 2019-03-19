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
        System.out.println(e.getKeyCode());
        try{
            if (e.getKeyCode() == 39){
                test.setIm(ImageIO.read(new FileInputStream("src/main/resources/shana_forward.png")));
                test.setActions_num(8);
            }else if (e.getKeyCode() == 81){
                test.setIm(ImageIO.read(new FileInputStream("src/main/resources/shana_attack_q1.png")));
                test.setActions_num(7);
            }else if (e.getKeyCode() == 37){
                test.setIm(ImageIO.read(new FileInputStream("src/main/resources/shana_rollback.png")));
                test.setActions_num(8);
            }
        }catch (IOException e1){
            e1.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e) {
        try {
            test.setIm(ImageIO.read(new FileInputStream("src/main/resources/shana_stand.png")));
            test.setActions_num(4);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
