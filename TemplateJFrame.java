import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemplateJFrame {
  
  JFrame window = new JFrame();
  ActionHandler actionHandler = new ActionHandler();
  MouseHandler mouseHandler = new MouseHandler();
  JButton button1,button2,button3,button5,button6,button7;
  JPanel itemPanel,titlePanel;
  JLabel titleLabel;
  JSlider slider;
  Timer timer;
  boolean timerOn = false;
  double perSecond = 0;
  int timerSpeed;
  int counter = 0;
  int r = 0;
  int g = 0;
  int b = 0;

  public TemplateJFrame() {
    window.setSize(800,600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(new Color(0,0,0));
    window.setLayout(null);
    
    itemPanel = new JPanel();
    itemPanel.setBounds(window.getWidth()/2-350/2,window.getHeight()/2-250/2,350,250);
    itemPanel.setBackground(new Color(0,0,0));
    itemPanel.setLayout(new GridLayout(3,2));
    window.add(itemPanel);

    titlePanel  = new JPanel();
    titlePanel.setBounds(window.getWidth()/2-350/2,window.getHeight()/2-350/2,350,50);
    titlePanel.setBackground(new Color(0,0,0));
    titlePanel.setLayout(new GridLayout(1,1));
    window.add(titlePanel);

    titleLabel = new JLabel("(0,0,0)",SwingConstants.CENTER);
    titleLabel.setBackground(Color.BLACK);
    titleLabel.setForeground(Color.white);
    titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
    titlePanel.add(titleLabel);

    button1 = newButton("button1",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button1",mouseHandler,"Red -");
    button1.setBackground(new Color(255,0,0));
    button2 = newButton("button2",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button2",mouseHandler,"Green -");
    button2.setBackground(new Color(0,255,0));
    button3 = newButton("button3",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button3",mouseHandler,"Blue -");
    button3.setBackground(new Color(0,0,255));
    button5 = newButton("button5",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button5",mouseHandler,"Red +");
    button5.setBackground(new Color(255,0,0));
    button6 = newButton("button6",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button6",mouseHandler,"Green +");
    button6.setBackground(new Color(0,255,0));
    button7 = newButton("button7",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button7",mouseHandler,"Blue +");
    button7.setBackground(new Color(0,0,255));
    itemPanel.add(button1);
    itemPanel.add(button5);
    itemPanel.add(button2);
    itemPanel.add(button6);
    itemPanel.add(button3);
    itemPanel.add(button7);
    window.setVisible(true);
  }

  public JButton newButton(String name, Font font, Boolean focusPainted, ActionHandler aHandler, String actionCommand, MouseHandler mHandler, String text){
    JButton button = new JButton(name);
    button.setFont(font);
    button.setForeground(Color.BLACK);
    button.setFocusPainted(focusPainted);
    button.addActionListener(aHandler);
    button.setActionCommand(actionCommand);
    button.addMouseListener(mHandler);
    button.setText(text);
    return button;
  }
  

  public void setTimer(){
    timer = new Timer(timerSpeed, new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){

      }
    });
  }
  public void timerUpdate(){
    if(!timerOn){
      timerOn=true;
    }
    else if(timerOn){
      timer.stop();
    }
    double speed = 1/perSecond*1000;
    timerSpeed = (int)Math.round(speed);
    setTimer();
    timer.start();
  }
    
  public class ActionHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){
      String action = event.getActionCommand();
      switch(action){
        case "Button5":
          r += 5;
          if(r >= 255){
            r = 255;
          }
          window.getContentPane().setBackground(new Color(r,g,b));
          break;
        case "Button6":
          g += 5;
          if(g >= 255){
            g = 255;
          }
          window.getContentPane().setBackground(new Color(r,g,b));
          break;
        case "Button7":
          b += 5;
          if(b >= 255){
            b = 255;
          }
          window.getContentPane().setBackground(new Color(r,g,b));
          break;
        case "Button1":
          r -= 5;
          if(r <= 0){
            r = 0;
          }
          window.getContentPane().setBackground(new Color(r,g,b));
          break;
        case "Button2":
          g -= 5;
          if(g <= 0){
            g = 0;
          }
          window.getContentPane().setBackground(new Color(r,g,b));
          break;
        case "Button3":
          b -= 5;
          if(b <= 0){
            b = 0;
          }
          window.getContentPane().setBackground(new Color(r,g,b));
          break;
      }
      titleLabel.setText("("+r+","+g+","+b+")");
      timerUpdate();
    }
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
