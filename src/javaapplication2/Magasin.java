/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;
import java.util.ArrayList;
/**
 *
 * @author cleme
 */
public class Magasin {
    private ArrayList<Produit> produitsDisponibles = new ArrayList<>();

    public void ajouterProduit(Produit produit) {
        produitsDisponibles.add(produit);
    }

    public void afficherProduitsDisponibles() {
        System.out.println("\n--- Produits disponibles ---");
        for (Produit p : produitsDisponibles) {
            p.afficherDetails();
        }
    }

    public Produit trouverProduitParNom(String nom) {
        for (Produit p : produitsDisponibles) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }
}
