import javax.swing.JFrame;
import java.awt.*;

public class TemplateJFrame extends JFrame {
	TemplateJFrame() {
		this.add(new JFramePanel());
		this.setTitle("JFrame Template");
    this.setSize(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		this.setLayout(null);
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
