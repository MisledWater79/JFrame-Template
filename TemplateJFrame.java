import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemplateJFrame {
  
  JFrame window = new JFrame();
  ActionHandler actionHandler = new ActionHandler();
  MouseHandler mouseHandler = new MouseHandler();
  JButton button1,button2,button3,button4;
  JPanel itemPanel;
  Timer timer;
  boolean timerOn = false;
  double perSecond = 0;
  int timerSpeed;
  int counter = 0;

  public TemplateJFrame() {
    window.setSize(800,600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(Color.black);
    window.setLayout(null);
    
    itemPanel = new JPanel();
    itemPanel.setBounds(450,150,300,250);
    itemPanel.setBackground(Color.black);
    itemPanel.setLayout(new GridLayout(4,1));
    window.add(itemPanel);
    button1 = newButton("button1",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button1",mouseHandler);
    itemPanel.add(button1);
    newButton("button2",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button2",mouseHandler);
    newButton("button3",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button3",mouseHandler);
    newButton("button4",new Font("Comic Sans MS", Font.PLAIN, 32),false,actionHandler,"Button4",mouseHandler);
    window.setVisible(true);
  }

  public JButton newButton(String name, Font font, Boolean focusPainted, ActionHandler aHandler, String actionCommand, MouseHandler mHandler){
    JButton button = new JButton(name);
    button.setFont(font);
    button.setFocusPainted(focusPainted);
    button.addActionListener(aHandler);
    button.setActionCommand(actionCommand);
    button.addMouseListener(mHandler);
    button.setText("No Text Given");
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
        case "button1":
          button1.setText(Integer.toString(counter));
        case "button2":
          button2.setText(Integer.toString(counter));
        case "button3":
          button3.setText(Integer.toString(counter));
        case "button4":
          button4.setText(Integer.toString(counter));
      }
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
