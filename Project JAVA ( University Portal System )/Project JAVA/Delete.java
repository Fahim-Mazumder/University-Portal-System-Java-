import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener
{
	private JLabel idLabel;
	private JTextField idTF;
	private JButton back, logout, delete;
	private JPanel panel;
	private Registration regis;
	public Delete()
	{
		super("Delete Student Account");
		this.setSize(800, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		idLabel = new JLabel("Enter  ID : ");
		idLabel.setBounds(100,100,150,30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(260,100,100,30);
		panel.add(idTF);
		
		back = new JButton("Back");
		back.setBounds(100, 300, 80, 30);
		back.addActionListener(this);
		panel.add(back);
		
		delete = new JButton("Delete");
		delete.setBounds(190, 300, 80, 30);
		delete.addActionListener(this);
		panel.add(delete);
		
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
		else if(buttonClicked.equals(delete.getText()))
		{
			deleteFromDB();
		}
		else if(buttonClicked.equals(logout.getText()))
		{
			HomeAiub h = new HomeAiub();
			h.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void deleteFromDB()
	{
		String query = "DELETE from student where ID="+idTF.getText()+";";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imran", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query);
			JOptionPane.showMessageDialog(this,"DELETED");
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