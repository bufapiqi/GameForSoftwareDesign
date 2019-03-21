import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventAdapter implements KeyListener {
    private Role_jpanel test; // 还需要一个 IO包装类
    private Role current;
    public KeyEventAdapter(Role_jpanel a, Role start){
        test = a;
        this.current = start;
    }
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
//        System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
        Role need_return = current.get_Action(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
//        System.out.println(e.getKeyCode() + "    释放了");
        Role need_return = current.get_Action(-1);
    }
}
