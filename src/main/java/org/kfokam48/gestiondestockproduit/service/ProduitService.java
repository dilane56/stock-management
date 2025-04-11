package org.kfokam48.gestiondestockproduit.service;

import org.kfokam48.gestiondestockproduit.dto.ProduitDto;
import org.kfokam48.gestiondestockproduit.model.Produit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();
    Produit createProduit(ProduitDto produitDto);
    Produit updateProduit(Long id, ProduitDto produitDto);
    ResponseEntity<String> deleteProduit(Long id);
    List<Produit> getProduitsAvecStockBas();
    Produit getProduitById(Long id);
    List<Produit> getProduitsAvecFaibleQuantite();


}
