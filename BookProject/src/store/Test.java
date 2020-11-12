package store;

import java.util.Scanner;

public class Test {
	
	//Affecter la methode main
	public static void main(String[] args) {
		
		//try-catch block
		try {
		
		//pour pouvoir entrer les variables à partitr de l'utilisateur 
		Scanner c=new Scanner(System.in);
		
		//entrer le premier variable: qte
		System.out.println("Saisir la quantité SVP: ");
		
		//lire le variable qte
		int qte=c.nextInt();
		
		//entrer le premier variable: prix
		System.out.println("Saisir le prix SVP:");
		
		//lire le variable de prix
		float unitPrice=c.nextFloat();
		
		//instanciation du classe Produit
		Book p=new Book();
		
		//l'affichage du résultat
		System.out.println("Le prix totale de l'achat est "+p.calculateTotalePrice(qte, unitPrice)+" Dinars");
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}

}
