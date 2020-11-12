package calculPrice;

 

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

 

import connection.MyConnection;

 

public class Utilisateur {
	private String login;
	private String mdp;
    private String nom;
    private String prenom;
    private String tel;
    
    
    public Utilisateur(String login, String mdp, String nom, String prenom, String tel) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
    public Utilisateur() {
		super();
	}
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void adduser(String login, String mdp, String nom, String prenom, String tel) throws ClassNotFoundException, SQLException
    {
    	MyConnection c;
	    PreparedStatement pstmt;
	    c = new MyConnection();
		    if (c==null)
	            System.out.println("server connection error!");
	            else System.out.println("Connected !");
		    pstmt = c.Myconnect().prepareStatement("INSERT INTO `user`(id,login,mdp,nom,prenom,tel) VALUES (?, ?, ?, ?, ?,?)");
		    pstmt.setString(1, null );
	        pstmt.setString(2, login );
	        pstmt.setString(3, mdp );
	        pstmt.setString(4, nom );
	        pstmt.setString(5,prenom);
	        pstmt.setString(6, tel );
		    pstmt.executeUpdate();
	        System.out.println("ADD succefully");}

    
    public void consultuser() throws ClassNotFoundException, SQLException
    {
    	
    	
    	MyConnection con;
         PreparedStatement pstmt;
         con = new MyConnection();
          pstmt = con.Myconnect().prepareStatement("SELECT * FROM user "); 
         ResultSet rs = pstmt.executeQuery();
         int i=0;
         while (rs.next()) {
             
                String login = rs.getString("login");
                String mdp = rs.getString("mdp");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String tel = rs.getString("tel");
                

 

                //Display values
                System.out.println("-------------------------");

                System.out.println("login: " + login);
                System.out.println("password: " + mdp);
                System.out.println(" nom: " + nom);
                System.out.println(" prenom: " + prenom);
                System.out.println(" phone: " + tel);
    }
         
    }
    public void deleteuser(int id) throws ClassNotFoundException, SQLException
    {    MyConnection c;
    PreparedStatement pstmt;
    c = new MyConnection();
    try {
   pstmt =  c.Myconnect().prepareStatement("DELETE FROM user WHERE id =?");
  
    pstmt.setLong(1,id);
    pstmt.executeUpdate();
    System.out.println("Deleted !");
    }
    catch(SQLException e)
    {e.printStackTrace();}
           
        }
    public void updateuser(int id,String login, String mdp, String nom, String prenom, String tel) throws ClassNotFoundException, SQLException
	{   Connection con =null;
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3307/BookStore?serverTimezone=UTC";
	con = DriverManager.getConnection(url,"root","");
	try {
	PreparedStatement pstmt = con.prepareStatement("UPDATE user SET login = ?,mdp = ?,nom = ?,prenom = ?tel = ? WHERE id = ?");

	 

	pstmt.setString(1, login );
	pstmt.setString(2, mdp );
	pstmt.setString(3,nom);
	pstmt.setString(4, prenom );
	pstmt.setInt(5, id );

	 

	           pstmt.executeUpdate();
	           System.out.println("updated succefully");}
	catch(SQLException e)
	{e.printStackTrace();}
	       
	    }

    
    
}