import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIMySQL {
	static JFrame f;
	static Record record;
   static JButton A;
   static JButton B;
   static JButton C;
   static JButton D;
   static JButton E;
   static JButton F;
   static JButton G;
   static JButton O;
   static JButton K;
   
   public static JLabel LA;
   public static JLabel LB;
   public static JLabel LF;
   public static JLabel LF2;
   public static JTextField TF;
   public static JLabel LG;
   public static JLabel LO;
   public static JLabel LK;
	
	public static void main(String[] args) {
		f=new JFrame();
		f.setLayout(new GridLayout(30,10));
		
		A= new JButton("Connect mysql");
		B=new JButton("Create All Tables");
		C=new JButton("Sort Author Inf By LastName,FirstName");
		D=new JButton("Show Publishers");
		E=new JButton("Special Publisher");
		F=new JButton("Add New Author");
		G=new JButton("Update Author Info");
		O=new JButton("Add New Title");
		K=new JButton("Update Publisher Info");
		
		LA=new JLabel("Processing");
		LB=new JLabel("Processing");
		LF=new JLabel("Processing");
		LF2=new JLabel("authorID,firstName,lastName,isbn,title,editionNum,copyright,publisherid,price,publishername");
		TF=new JTextField();
		LG=new JLabel("Processing"); 
		LO=new JLabel("Processing");
		LK=new JLabel("Processing");
		 f.add(A);
		 f.add(LA);
		 f.add(B);
		 f.add(LB);
		 f.add(C);
		 f.add(D);
		 f.add(E);
		 f.add(LF2);
		 f.add(TF);
		 f.add(F);
		 f.add(LF);
		 f.add(G);
		 f.add(LG);
		 f.add(O);
		 f.add(LO);
		 f.add(K);
		 f.add(LK);
		 
        f.pack();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
	     
	     A.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AllMySqlFunctions.getConnection();
				A.setEnabled(false);
				
			}});
	     //Create All Tables
	     B.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					AllMySqlFunctions.executeAll(AllMySqlFunctions.stmt, JDBCAllTable.AUTHORTABLE, JDBCAllTable.AUTHORISBNTABLE, 
							JDBCAllTable.TITLESTABLE, JDBCAllTable.PUBLISHERSTABLE);
					B.setEnabled(false);
					
				}});
	     //Sort Author Information
	     C.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					AllMySqlFunctions.sortAll(AllMySqlFunctions.stmt,AllMySqlFunctions.myRs,JDBCAllTable.sort1);
					C.setEnabled(false);
				}});
	     //Show All Publishers
	     D.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					AllMySqlFunctions.showPublisher(AllMySqlFunctions.stmt, AllMySqlFunctions.myRs);
					D.setEnabled(false);
				}});
	     //Special Publishers
	     E.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					AllMySqlFunctions.specialPublisher(AllMySqlFunctions.stmt, AllMySqlFunctions.myRs);
					E.setEnabled(false);
				}});
	     //Add new Author
	     F.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					String s=TF.getText();
					String[] ss=s.split(",");
					 record=new Record(Integer.parseInt(ss[0]),ss[1],ss[2],
							ss[3],ss[4],Integer.parseInt(ss[5]),ss[6],Integer.parseInt(ss[7]),
							Integer.parseInt(ss[8]),ss[9]);
					 AllMySqlFunctions.insertNewAuthor(AllMySqlFunctions.stmt,record);
					F.setEnabled(false);
					
				}});
	     
	     //Update Authors Info
	     G.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					
					AllMySqlFunctions.updateAuthor(AllMySqlFunctions.stmt);
					G.setEnabled(false);
					
				}});
	     
	     //Add New Title,new Publisher to a existed author
	     O.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					
					AllMySqlFunctions.AddTitle(AllMySqlFunctions.stmt, AllMySqlFunctions.myRs);
					O.setEnabled(false);
					
				}});
	     K.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					
					AllMySqlFunctions.UpdatePublisher(AllMySqlFunctions.stmt);
					K.setEnabled(false);
					
				}});
	}

}
