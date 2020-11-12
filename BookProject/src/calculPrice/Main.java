package calculPrice;

 

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import connection.MyConnection;



public class Main {

	public static void totalPrice() throws ClassNotFoundException {
		double Totalprice=0;
        try {
        	 MyConnection con;
        	 PreparedStatement pstmt;
        	 con = new MyConnection();
            pstmt = con.Myconnect().prepareStatement("SELECT price FROM commande ");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
                {
                 Totalprice += Double.parseDouble(rs.getString("price"));
                }
            System.out.println();
            System.out.println("total to pay "+Totalprice);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }


    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
    	Commande commande = new Commande();
    	Utilisateur user = new Utilisateur();
        Book book = new Book();
        int a=0;
        do {System.out.println("Bienvenue cher Administrateur : ");
            System.out.println("Vous pouvez :");
            System.out.println("1: Mise à jour livre ");
            System.out.println("2: Ajouter Livre ");
            System.out.println("3: Boutique  ");
            System.out.println("4: Add Commande ");
            System.out.println("5: Supprimer Livre");
            System.out.println("6: Ajouter Utilisateur ");
            System.out.println("7: Affihcher liste des utilisateurs ");
            System.out.println("8: Supprimer un utilisateur ");
            System.out.println("9: Rechercher livre ");

            System.out.println("10: Mise à jour Utilisateur  ");
            System.out.println("11: Panier  ");






            System.out.println("12: Déconnexion ");
            Scanner s = new Scanner( System.in );
            a   = s.nextInt();
            switch(a)
            {case 1:{
        System.out.println("Mettez les livres si vous voulez mettre à jour ");
        Scanner sc9 = new Scanner( System.in );
        int idu   = sc9.nextInt();
        
         System.out.println(" titre ");
            Scanner sc = new Scanner( System.in );
            String title   = sc.nextLine();
            System.out.println(" auteur ");
            Scanner sc1 = new Scanner( System.in );
            String author   = sc1.nextLine();
            System.out.println(" prix ");
            Scanner sc3 = new Scanner( System.in );
            Double price   = sc3.nextDouble();
            System.out.println("entrez la date de sortie du livre POUR METTRE À JOUR (yyyy-mm-dd)");
            Scanner sc5 = new Scanner( System.in );
            String doj=sc5.next();
            Date releasedate=java.sql.Date.valueOf(doj);    
     book.updateBook(idu, title,author, price, releasedate);
break;}
            case 2:{ 
                try { System.out.println("Entrer le titre de livre ");
                Scanner sc = new Scanner( System.in );
                String title   = sc.nextLine();
                System.out.println("Entrer le nom de l'auteur  ");
                Scanner sc1 = new Scanner( System.in );
                String author   = sc1.nextLine();
                System.out.println("Entrer le prix de livre ");
                Scanner sc3 = new Scanner( System.in );
                Double price   = sc3.nextDouble();
                System.out.println("entrez la date de sortie du livre (yyyy-mm-dd)");
                Scanner sc5 = new Scanner( System.in );
                String doj=sc5.next();
                Date releasedate=java.sql.Date.valueOf(doj);                   
                book.insertBooks(title, author, price, releasedate);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }break;}
            case 3:{
            try {
                book.displayBook();;
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }break;}
            case 4:{
            	System.out.println("Add Commande");
            	commande.addCommande();

            break;}
            case 5:{
            System.out.println("Mettez l'id de livre si vous souhaitez supprimer ");
            Scanner sc8 = new Scanner( System.in );
            int idd   = sc8.nextInt();
            book.deleteBook(idd);
            break;}
            case 6:{
            	System.out.println(" login ");
                Scanner a1 = new Scanner( System.in );
                String login   = a1.nextLine();
                System.out.println(" Mot de passe ");
                Scanner a2 = new Scanner( System.in );
                String mdp   = a2.nextLine();
                System.out.println(" Nom ");
                Scanner a3 = new Scanner( System.in );
                String nom   = a3.nextLine();
                System.out.println(" Prenom ");
                Scanner a4 = new Scanner( System.in );
                String prenom   = a4.nextLine();
                System.out.println(" Telephone ");
                Scanner a5 = new Scanner( System.in );
                String tel  = a5.nextLine();
                user.adduser(login,mdp,nom,prenom,tel);
                break;
            	
            	}
            case 7:{
            	user.consultuser();

            	break
            	;}
            case 8:{
            	
            	System.out.println("Mettez l'identifiant de l'utilisateur que vous souhaitez supprimer ");
                Scanner sc8 = new Scanner( System.in );
                int idd   = sc8.nextInt();
                 user.deleteuser(idd);break;}
case 9:{
            	
            	System.out.println("Rechercher livre ");
                Scanner sc8 = new Scanner( System.in );
                String nom   = sc8.nextLine();
                 book.rechercherlivre(nom);break;}



 case 10:{
	 System.out.println(" id ");
     Scanner a0 = new Scanner( System.in );	
     int ids   = a0.nextInt();

	 System.out.println(" login ");
     Scanner a1 = new Scanner( System.in );
     String login   = a1.nextLine();
     System.out.println(" mot de passe ");
     Scanner a2 = new Scanner( System.in );
     String mdp   = a2.nextLine();
     System.out.println(" Nom ");
     Scanner a3 = new Scanner( System.in );
     String nom   = a3.nextLine();
     System.out.println("Prenom ");
     Scanner a4 = new Scanner( System.in );
     String prenom   = a4.nextLine();
     System.out.println(" telephone ");
     Scanner a5 = new Scanner( System.in );
     String tel  = a5.nextLine();
     user.updateuser(ids,login,mdp,nom,prenom,tel);}
 case 11:
 {

 	    MyConnection con;
		 PreparedStatement pstmt;
		 con = new MyConnection();
		  pstmt = con.Myconnect().prepareStatement("SELECT * FROM commande "); 
		 ResultSet rs = pstmt.executeQuery();
		 int i=0;
		 while (rs.next()) {

			    String id= rs.getString("id");
			    String idbook = rs.getString("idbook");
			    String price = rs.getString("price");
			    String quantite = rs.getString("quantite");
			    String total = rs.getString("total");


			    //Display values
			    System.out.print("\n"+"id commande: " + id);
			    System.out.print(", id livre: " + idbook);
			    System.out.print(", prix de livre: " +price);
			    System.out.print(", quantité: " + quantite);
			    System.out.println(", prix totale: " + total);

	}
 break;}
 case 12: {
	    MyConnection con;
	    PreparedStatement pstmt;
	    con = new MyConnection();
	    try {
	    pstmt = con.Myconnect().prepareStatement("TRUNCATE TABLE commande ");



	   
	    pstmt.executeUpdate();
	    System.out.println("Au revoir ");
	    }
	    catch(SQLException e)
	    {e.printStackTrace();}
	   break;}
           }
            
            
        }
        while(a!=12);
    }

 

}
 