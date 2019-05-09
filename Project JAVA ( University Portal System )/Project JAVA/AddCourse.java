import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AddCourse extends JFrame implements ActionListener
{
	private JLabel name,id;
	private JTextField nameTF,idTF;
	private JButton back, logout, insert;
	private JPanel panel;
	private Registration regis;
	public AddCourse()
	{
		super("Add Course");
		
		this.setSize(800, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		name = new JLabel("Enter Course Name : ");
		name.setBounds(100,50,150,30);
		panel.add(name);
		
		nameTF = new JTextField();
		nameTF.setBounds(260,50,100,30);
		panel.add(nameTF);
		
		id = new JLabel("Enter Course ID : ");
		id.setBounds(100,100,150,30);
		panel.add(id);
		
		idTF = new JTextField();
		idTF.setBounds(260,100,100,30);
		panel.add(idTF);
		
		back = new JButton("Back");
		back.setBounds(100, 300, 80, 30);
		back.addActionListener(this);
		panel.add(back);
		
		insert = new JButton("Insert");
		insert.setBounds(190, 300, 80, 30);
		insert.addActionListener(this);
		panel.add(insert);
		
		logout = new JButton("Logout");
		logout.setBounds(280, 300, 80, 30);
		logout.addActionListener(this);
		panel.add(logout);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(back.getText()))
		{
			Admin ad = new Admin();
			ad.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(insert.getText()))
		{
			insertIntoDB();
		}
		else if(buttonClicked.equals(logout.getText()))
		{
			HomeAiub h = new HomeAiub();
			h.setVisible(true);
			this.setVisible(false);
		}
	}
	public void insertIntoDB()
	{
		String query = "INSERT INTO course VALUES ('"+nameTF.getText()+"','"+idTF.getText()+"');";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			JOptionPane.showMessageDialog(this,"CREATED");
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,"Invalid");
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}