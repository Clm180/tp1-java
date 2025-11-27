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
public class Commande {
    private int idCommande;
    private Client client;
    private ArrayList<Produit> produitsCommandes;
    private double total;

    public Commande(int idCommande, Client client, ArrayList<Produit> produitsCommandes) {
        this.idCommande = idCommande;
        this.client = client;
        this.produitsCommandes = new ArrayList<>(produitsCommandes);
        this.total = calculerTotal();
    }

    private double calculerTotal() {
        double somme = 0;
        for (Produit p : produitsCommandes) {
            somme += p.getPrix()*p.getQuantite();
        }
        return somme;
    }

    public void afficherDetailsCommande() {
        System.out.println("\n--- Détails de la commande " + idCommande + " ---");
        client.afficherDetails();
        for (Produit p : produitsCommandes) {
            p.afficherDetails();
        }
        System.out.println("Total de la commande : " + total + "€");
    }
}
