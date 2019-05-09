import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class UpdateStud extends JFrame implements ActionListener
{
	private JLabel name, id, dept, pass;
	private JTextField nameTF, idTF, deptTF;
	private JPasswordField passPF;
	private JButton back, logout, update;
	private JPanel panel;
	private UpdateStud updateS;
	private Update up;
	private Registration regis;
	
	public UpdateStud()
	{
		super("Update Student Account");
		
		this.setSize(800, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		name = new JLabel("Name");
		name.setBounds(100,50,150,30);
		panel.add(name);
		
		nameTF = new JTextField();
		nameTF.setBounds(260,50,100,30);
		panel.add(nameTF);
		
		id = new JLabel("ID");
		id.setBounds(100,100,150,30);
		panel.add(id);
		
		idTF = new JTextField();
		idTF.setBounds(260,100,100,30);
		panel.add(idTF);
		
		dept = new JLabel("Department");
		dept.setBounds(100,150,150,30);
		panel.add(dept);
		
		deptTF = new JTextField();
		deptTF.setBounds(260,150,100,30);
		panel.add(deptTF);
		
		pass = new JLabel("Password");
		pass.setBounds(100, 200, 150, 30);
		panel.add(pass);
		
		passPF =new JPasswordField();
		passPF.setBounds(260, 200, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		back = new JButton("Back");
		back.setBounds(100, 300, 80, 30);
		back.addActionListener(this);
		panel.add(back);
		
		update= new JButton("Update");
		update.setBounds(190, 300, 80, 30);
		update.addActionListener(this);
		panel.add(update);
		
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
			Update up = new Update();
			up.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonClicked.equals(update.getText()))
		{
			updatestd();
		}
		else if(buttonClicked.equals(logout.getText()))
		{
			HomeAiub h = new HomeAiub();
			h.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void updatestd()
	{
		String query = "UPDATE `student` SET `Name`='"+nameTF.getText()+"',`Department`='"+deptTF.getText()+"',`Password`='"+passPF.getText()+"' where `ID`='"+idTF.getText()+"'";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			JOptionPane.showMessageDialog(this,"DONE");
			stm.close();
			con.close();					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}