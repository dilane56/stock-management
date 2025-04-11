package org.kfokam48.gestiondestockproduit.service;

import jakarta.validation.Valid;
import org.kfokam48.gestiondestockproduit.dto.ProduitDto;
import org.kfokam48.gestiondestockproduit.exception.ProductAlreadyExistException;
import org.kfokam48.gestiondestockproduit.exception.ProductNotFoundException;
import org.kfokam48.gestiondestockproduit.model.Produit;
import org.kfokam48.gestiondestockproduit.repository.ProduitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit createProduit(@Valid ProduitDto produitDto) {

        List<Produit> produits = produitRepository.findAll();
        for (Produit produit : produits) {
            if (produit.getNom().equals(produitDto.getNom())) {
                throw new ProductAlreadyExistException("Le Produit avec le nom:" + produitDto.getNom() + " existe déja");
            }
        }

        Produit produit = new Produit();
        produit.setNom(produitDto.getNom());
        produit.setPrix(produitDto.getPrix());
        produit.setQuantite(produitDto.getQuantite());
        produit.setStockBas(5);
        produitRepository.save(produit);
        return produit;
    }

    @Override
    public Produit updateProduit(Long id,@Valid ProduitDto produitDto) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Le produit avec l'ID:" + id + " n'existe pas"));

        List<Produit> produits = produitRepository.findAll();
        for (Produit produit1 : produits) {
            if (produit1.getNom().equals(produitDto.getNom())&& produit1.getId()!=id) {
                throw new ProductAlreadyExistException("Le Produit avec le nom:" + produitDto.getNom() + " existe déja");
            }
        }
        produit.setNom(produitDto.getNom());
        produit.setPrix(produitDto.getPrix());
        produit.setQuantite(produitDto.getQuantite());
        produit.setStockBas(5);
        produitRepository.save(produit);
        return produit;


    }

    @Override
    public ResponseEntity<String> deleteProduit(Long id) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Le produit avec l'ID:" + id + " n'existe pas"));
        produitRepository.deleteById(id);
        return ResponseEntity.ok("Produit Supprimer avec succes");
    }


    @Override
    public List<Produit> getProduitsAvecStockBas() {
        List<Produit> produits = produitRepository.findAll();
        List<Produit> produitsAvecStockBas = new ArrayList<Produit>();
        if (!produits.isEmpty()) {
            for (Produit produit : produits) {
                if (produit.stockEstBas()) {
                    produitsAvecStockBas.add(produit);

                }
            }
        }
        return produitsAvecStockBas;
    }

    @Override
    public Produit getProduitById(Long id) {
        return  produitRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Le produit avec l'ID:" + id + " n'existe pas"));
    }

    @Override
    public List<Produit> getProduitsAvecFaibleQuantite() {
        return produitRepository.findProduitsAvecQuantiteFaible();
    }
}
