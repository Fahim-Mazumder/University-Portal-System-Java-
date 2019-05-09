import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class Admin extends JFrame implements ActionListener
{
	private JLabel label,welcome;
	private JLabel imgLabel;
	private JButton create, delete, addcourse, deletecourse, addfaculty, deletefaculty, logout,update;
	private JPanel panel;
	private HomeAiub h;
	private Update upd;
	private Create c;
	private Admin admin;
	private ImageIcon imge;
	
	public Admin()
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
		
		create = new JButton("Add Student");
		create.setBounds(170, 100, 150, 30);
		create.addActionListener(this);
		panel.add(create);
		
		delete = new JButton("Delete Student");
		delete.setBounds(350, 100, 150, 30);
		delete.addActionListener(this);
		panel.add(delete);
		
		addcourse = new JButton("Add Course");
		addcourse.setBounds(170, 150, 150, 30);
		addcourse.addActionListener(this);
		panel.add(addcourse);
		
		deletecourse = new JButton("Delete Course");
		deletecourse.setBounds(350, 150, 150, 30);
		deletecourse.addActionListener(this);
		panel.add(deletecourse);
		
		addfaculty = new JButton("Add Faculty");
		addfaculty.setBounds(170, 200, 150, 30);
		addfaculty.addActionListener(this);
		panel.add(addfaculty);
		
		deletefaculty = new JButton("Delete Faculty");
		deletefaculty.setBounds(350, 200, 150, 30);
		deletefaculty.addActionListener(this);
		panel.add(deletefaculty);
		
		update = new JButton("Update");
		update.setBounds(250, 250, 150, 30);
		update.addActionListener(this);
		panel.add(update);
		
		logout = new JButton("Log out");
		logout.setBounds(250, 300, 150, 30);
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
		
		if(buttonClicked.equals(create.getText()))
		{
			Create c = new Create();
			c.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(delete.getText()))
		{
			Delete d = new Delete();
			d.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(addcourse.getText()))
		{
			AddCourse a = new AddCourse();
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(deletecourse.getText()))
		{
			DeleteCourse dc = new DeleteCourse();
			dc.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(addfaculty.getText()))
		{
			AddFaculty af = new AddFaculty();
			af.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(deletefaculty.getText()))
		{
			DeleteFaculty df = new DeleteFaculty();
			df.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(logout.getText()))
		{
			HomeAiub h = new HomeAiub();
			this.setVisible(false);
			h.setVisible(true);	
		}
		else if(buttonClicked.equals(update.getText()))
		{
			Update upd = new Update();
			this.setVisible(false);
			upd.setVisible(true);
		}
	}
}