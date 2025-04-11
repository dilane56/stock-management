package org.kfokam48.gestiondestockproduit.repository;

import org.kfokam48.gestiondestockproduit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT p FROM Produit p WHERE p.quantite <= 5")
    List<Produit> findProduitsAvecQuantiteFaible();
}
