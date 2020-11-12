package calculPrice;

 

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

 

import connection.MyConnection;

 

public class Commande {
    public void addCommande() throws ClassNotFoundException, SQLException 
    { double pricebook = 0;
    MyConnection con;
    PreparedStatement pstmt;
    con = new MyConnection();
    System.out.println("Ajouter l'id de livre ");
    Scanner sc1 = new Scanner( System.in );
    long idBook   = sc1.nextLong();
    System.out.println("Ajouter la quantité ");
    Scanner sc2 = new Scanner( System.in );
    int quantite   = sc2.nextInt();
     try {
            pstmt = con.Myconnect().prepareStatement("SELECT * FROM Book where id = ? "); 
            pstmt.setDouble(1,idBook);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
                {
                 pricebook =Double.parseDouble(rs.getString("price"));
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
    pstmt =  con.Myconnect().prepareStatement("INSERT INTO `commande`(id,idbook,price,quantite,total) VALUES ( ?, ?, ?, ?,?)");
    pstmt.setInt(1, 0 );
    pstmt.setLong(2, idBook );
    pstmt.setDouble(3,pricebook);
    pstmt.setInt(4, quantite );
    pstmt.setDouble(5,pricebook*quantite );
    System.out.println("Ajouté avec succès");
    pstmt.executeUpdate();
    pstmt.setDouble(5,pricebook*quantite );


    }
}