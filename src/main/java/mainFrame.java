import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * 主窗口类
 *
 */
public class mainFrame extends JFrame{
//    public mainFrame(){
//        setTitle("Java 第一个 GUI 程序");    //设置显示窗口标题
//        setSize(800,800);    //设置窗口显示尺寸
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
//        JLabel jl=new JLabel("这是使用JFrame类创建的窗口");    //创建一个标签
//        Container c=getContentPane();    //获取当前窗口的内容窗格
//        c.add(jl);    //将标签组件添加到内容窗格上
//        setVisible(true);    //设置窗口是否可见
// 38 == shang
// 37 == zuo
// 40 == xia
// 39 == you
//    }
    HashMap<String, Role> Role_pool;
    Role current_role;
    public mainFrame(){
        Role_pool = new HashMap<String, Role>();
    }
    public static void main(String[] args){
//        new mainFrame();
        BufferedImage shana;
        Image im;
        try {
            shana = ImageIO.read(new FileInputStream("src/main/resources/shana/shana_stand.png"));
            mainFrame jf = new mainFrame();
            jf.current_role = new Role_shana("shana", null);

            //通过构造方法将缓冲缓冲区对像的引用传给自定义Panel
            Role_jpanel jp = new Role_jpanel(jf.current_role);
            // 构造一个 bats的对象

            jf.setBounds(200,200,500, 500);
            jp.setSize(220, 100);
            jf.add(jp);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);
//            jp.display(1);
            jf.addKeyListener(new KeyEventAdapter(jp, jf.current_role));
            while(true) {
//                jp.repaint();
                jp.display(0);
                try
                {
                    Thread.sleep(60);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 74
    }
}
