import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFramePanel extends JPanel implements ActionListener{

  JButton button1, button2, button3, button4;

  static int screenWidth = 200;
  static int screenHeight = 100;
  static final int DELAY = 1;
  double y;
  MouseHandler mouseHandler = new MouseHandler();
  Timer timer;

  JFramePanel(){
    this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    this.setBounds(200,0,0,100);
    this.setBackground(Color.black);
    this.setLayout(new GridLayout(5,1));
    newButton(button1,"button1",new Font("Comic Sans MS", Font.PLAIN, 32),false,this,"Button1",mouseHandler,this);
    newButton(button2,"button2",new Font("Comic Sans MS", Font.PLAIN, 32),false,this,"Button2",mouseHandler,this);
    newButton(button3,"button3",new Font("Comic Sans MS", Font.PLAIN, 32),false,this,"Button3",mouseHandler,this);
    newButton(button4,"button4",new Font("Comic Sans MS", Font.PLAIN, 32),false,this,"Button4",mouseHandler,this);
    start();
  }

  public void start(){
    timer = new Timer(DELAY,this);
    timer.start();
  }

  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      paint(g);
  }

  public void paint(Graphics g){
    /*y += 0.01;
    for (int z = 0; z < 256; z++) {
      for (int x = 0; x < 256; x++) {
        g.setColor(new Color(255,0,0));
        g.drawRect(x,z,0,0);
        g.fillRect(x,z,0,0);
      }
    }*/
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
    if(screenHeight != getHeight()){
      screenHeight = getHeight();
    }
    if(screenWidth != getWidth()){
      screenWidth = getWidth();
    }
  }

  public void newButton(JButton button, String name, Font font, Boolean focusPainted, JFramePanel aHandler, String actionCommand, MouseHandler mHandler, JPanel panel){
    button = new JButton(name);
    button.setFont(font);
    button.setFocusPainted(focusPainted);
    button.addActionListener(aHandler);
    button.setActionCommand(actionCommand);
    button.addMouseListener(mHandler);
    button.setText("No Text Given");
    panel.add(button);
  }

  public class MouseHandler implements MouseListener{
    @Override
    public void mouseClicked(MouseEvent e){

    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){
      JButton button = (JButton)e.getSource();
    }
    @Override
    public void mouseExited(MouseEvent e){

    }
  }
}