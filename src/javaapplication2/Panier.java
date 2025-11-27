package javaapplication2;
import java.util.ArrayList;

public class Panier {

    private ArrayList<Produit> produits = new ArrayList<>();

    public void ajouterProduit(Produit produit){
        produits.add(produit);
        System.out.println(produit.getNom() + " a ete ajoute a la liste");
    }

    public void supprimerProduit(Produit produit){
        produits.remove(produit);
        System.out.println(produit.getNom() + " a ete retire de la liste");
    }

    public void afficherPanier(){
        if (produits.isEmpty()) {
            System.out.println("Le panier est vide.");
        } else {
            System.out.println("Produits dans le panier :");
            for (Produit p : produits) {
                p.afficherDetails();
            }
        }
    }

    public double calculerTotal(){
        double total = 0;
        for (Produit p : produits) {
            total += p.getPrix() * p.getQuantite();
        }
        return total;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }
}
