import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class nyan extends JFrame {

    Container c;
    JLabel lab;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int lifecounter = 7;
    int speed = 1;
    Icon pic;
    String text;

    public nyan() {
        c = getContentPane();

        //make background transparent
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));

        //size
        setSize(400, 400);

        pic = new ImageIcon("nyan.gif");
        lab = new JLabel(text, pic, JLabel.CENTER);
        lab.setFont(new Font("Monospaced", Font.BOLD, 55));
        lab.setHorizontalTextPosition(JLabel.CENTER);

        lab.addMouseListener(new MouseListener());

        c.add(lab);
    }
    public class MouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            lab.setText(lifecounter-- + " ");
            speed += 2;
        }
    }

    public void run() throws Exception{
        int y = 300;
        int x = 500;
        boolean yb = false;
        boolean xb = false;

        while(lifecounter >= 0) {
            Thread.sleep(10);
            setLocation(x, y);

            if( y >= dim.getHeight() - 200) {
                yb = true;
            }else if (y <= -200) {
                yb = false;
            }
            if (x >= dim.getWidth() - 200) {
                xb = true;
            }else if (x <= -200) {
                xb = false;
            }
            if (yb) {
                y -= speed;
            }else {
                y += speed;
            }
            if (xb) {
                x -= speed;
            }else {
                x += speed;
            }
        }
        lab.setText("");
        lab.setIcon(new ImageIcon("ex.gif"));

        //set the time show to 1.8 seconds
        Thread.sleep(1800);
        System.exit(0);
    }

    public static void main(String[] args) {

        nyan frame = new nyan();
        frame.setVisible(true);

        try {
            frame.run();
        } catch (Exception e) {
        }
    }
}
