package org.kfokam48.gestiondestockproduit.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProduitDto {

    @NotNull(message = "Le nom du produit ne doit pas être null")
    @NotBlank(message = "Le nom du produit est obligatoire")
    private String nom;
    @NotNull(message = "Le prix est obligatoire")
    @Min(value = 0, message = "Le prix ne doit pas être inférieur a 0")
    private double prix;
    @NotNull(message = "La quantité en stock est obligatoire")
    @Min(value =0, message = "Le stock minimum est de 0")
    private int quantite;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


}
