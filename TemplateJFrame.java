import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TemplateJFrame {
  
  JFrame window = new JFrame();
  ActionHandler actionHandler = new ActionHandler();
  MouseHandler mouseHandler = new MouseHandler();
  JButton button1,button2,button3,button5,button6,button7;
  JPanel itemPanel,titlePanel,sliderPanel;
  JLabel titleLabel;
  JSlider rSlider,gSlider,bSlider;
  Timer timer;
  boolean timerOn = false;
  double perSecond = 0;
  int timerSpeed;
  int r = 0;
  int g = 0;
  int b = 0;

  public TemplateJFrame() {
    window.setSize(800,600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(new Color(0,0,0));
    window.setLayout(null);

    itemPanel = new JPanel();
    itemPanel.setBounds(0,0,window.getWidth(),window.getHeight()/3);
    itemPanel.setBackground(new Color(255, 255, 255));
    window.add(itemPanel);

    titlePanel  = new JPanel();
    titlePanel.setBounds(0,window.getHeight()/3,window.getWidth(),window.getHeight()/3*2);
    titlePanel.setBackground(new Color(10, 142, 236));
    titlePanel.setLayout(new GridLayout(1,2));
    window.add(titlePanel);

    window.setVisible(true);
  }

  public JButton newButton(String name, Font font, Boolean focusPainted, ActionHandler aHandler, String actionCommand, MouseHandler mHandler, String text){
    JButton button = new JButton(name);
    button.setFont(font);
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
      timerUpdate();
    }
  }

  public class SliderHandler implements ChangeListener {
    public void stateChanged(ChangeEvent e){
      JSlider slider = ((JSlider)e.getSource());
      switch (slider.getName()) {
        case "RSlider":
          r = slider.getValue();
          window.getContentPane().setBackground(new Color(r, g, b));
          break;
        case "GSlider":
          g = slider.getValue();
          window.getContentPane().setBackground(new Color(r, g, b));
          break;
        case "BSlider":
          b = slider.getValue();
          window.getContentPane().setBackground(new Color(r, g, b));
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
