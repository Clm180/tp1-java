package javaapplication2;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Magasin magasin = new Magasin();
        magasin.ajouterProduit(new Produit(1, "Pomme", 1.2, 50));
        magasin.ajouterProduit(new Produit(2, "Banane", 0.9, 30));
        magasin.ajouterProduit(new Produit(3, "Pain", 2.5, 20));

        Client client = new Client(1, "Alice Dupont", "alice@example.com");

        Panier panier = new Panier();

        int choix;
        int idCommande = 1000;

        do {
            System.out.println("\n--- MENU MAGASIN ---");
            System.out.println("1. Afficher les produits disponibles");
            System.out.println("2. Ajouter un produit au panier");
            System.out.println("3. Afficher le panier");
            System.out.println("4. Passer la commande");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    magasin.afficherProduitsDisponibles();
                    break;

                case 2:
                    System.out.print("Nom du produit à ajouter : ");
                    String nomProduit = sc.nextLine();
                    Produit produit = magasin.trouverProduitParNom(nomProduit);
                    if (produit != null) {
                        panier.ajouterProduit(produit);
                    } else {
                        System.out.println("Produit introuvable !");
                    }
                    break;

                case 3:
                    panier.afficherPanier();
                    break;

                case 4:
                    if (panier.getProduits().isEmpty()) {
                        System.out.println("Le panier est vide !");
                    } else {
                        Commande commande = new Commande(idCommande++, client, panier.getProduits());
                        commande.afficherDetailsCommande();
                        System.out.println("Commande passée !");
                        panier = new Panier();
                    }
                    break;

                case 5:
                    System.out.println("Merci de votre visite !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 5);

        sc.close();
    }
}
