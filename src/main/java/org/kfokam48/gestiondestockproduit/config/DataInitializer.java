package org.kfokam48.gestiondestockproduit.config;
import org.kfokam48.gestiondestockproduit.model.Produit;
import org.kfokam48.gestiondestockproduit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public void run(String... args) throws Exception {

        Produit p = new Produit();
        p.setNom("Stylo");
        p.setQuantite(3);
        p.setPrix(103.5);
        produitRepository.save(p);
        Produit p2 = new Produit();
        p2.setPrix(253.5);
        p2.setQuantite(15);
        p2.setNom("Cahier");
        produitRepository.save(p2);
        Produit p3 = new Produit();
        p3.setPrix(50.5);
        p3.setQuantite(10);
        p3.setNom("Gomme");
        produitRepository.save(p3);
        Produit p4 = new Produit();
        p4.setPrix(25.5);
        p4.setQuantite(5);
        p4.setNom("Crayon");
        produitRepository.save(p4);
        Produit p5 = new Produit();
        p5.setPrix(103.5);
        p5.setQuantite(2);
        p5.setNom("Règle");
        produitRepository.save(p5);

   

    }
}

