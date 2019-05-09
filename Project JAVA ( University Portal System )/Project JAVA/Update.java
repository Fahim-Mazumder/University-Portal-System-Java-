import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class Update extends JFrame implements ActionListener
{
	private JLabel label,welcome;
	private JLabel imgLabel;
	private JButton updatecourse, updatestudent, updatefaculty,back, logout;
	private JPanel panel;
	private Update up;
	private UpdateStud updateS;
	private UpdateCourse updateC;
	private UpdateFaculty updateF;
	private HomeAiub h;
	private Admin admin;
	private ImageIcon imge;
	
	public Update()
	{
		super("AIUB ADMIN HOME");
		
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		welcome = new JLabel(" WELCOME TO AMERICAN INTERNATIONAL UNIVERSITY-BANGLADESH");
		welcome.setBounds(140,20,800,60);
		welcome.setBackground(Color.BLUE);
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		welcome.setOpaque(true);
		panel.add(welcome);
		
		updatecourse = new JButton("Update Course");
		updatecourse.setBounds(300, 150, 150, 30);
		updatecourse.addActionListener(this);
		panel.add(updatecourse);
		
		updatestudent = new JButton("Update Student");
		updatestudent.setBounds(300, 100, 150, 30);
		updatestudent.addActionListener(this);
		panel.add(updatestudent);
		
		updatefaculty = new JButton("Update Faculty");
		updatefaculty.setBounds(300, 200, 150, 30);
		updatefaculty.addActionListener(this);
		panel.add(updatefaculty);

		back = new JButton("Back");
		back.setBounds(200, 250, 150, 30);
		back.addActionListener(this);
		panel.add(back);
		
		logout = new JButton("Log out");
		logout.setBounds(380, 250, 150, 30);
		logout.addActionListener(this);
		panel.add(logout);
		
		imge = new ImageIcon("img1.png");
		imgLabel = new JLabel(imge);
		imgLabel.setBounds(0,20,150,70);
		panel.add(imgLabel);
		
		this.add(panel);
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();

		if(buttonClicked.equals(logout.getText()))
		{
			HomeAiub h = new HomeAiub();
			this.setVisible(false);
			h.setVisible(true);	
		}
		else if(buttonClicked.equals(back.getText()))
		{
			Admin admin = new Admin();
			this.setVisible(false);
			admin.setVisible(true);	
		}
		else if(buttonClicked.equals(updatestudent.getText()))
		{
			UpdateStud updateS = new UpdateStud();
			this.setVisible(false);
			updateS.setVisible(true);	
		}
		else if(buttonClicked.equals(updatecourse.getText()))
		{
			UpdateCourse updateC = new UpdateCourse();
			this.setVisible(false);
			updateC.setVisible(true);	
		}
		else if(buttonClicked.equals(updatefaculty.getText()))
		{
			UpdateFaculty updateF = new UpdateFaculty();
			this.setVisible(false);
			updateF.setVisible(true);	
		}
	}
}