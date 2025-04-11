package org.kfokam48.gestiondestockproduit.controller;


import jakarta.validation.Valid;
import org.kfokam48.gestiondestockproduit.dto.ProduitDto;
import org.kfokam48.gestiondestockproduit.model.Produit;
import org.kfokam48.gestiondestockproduit.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/v1/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    @Operation(
            summary = "Obtenir tous les produits",
            description = "Retourne une liste complète de tous les produits disponibles"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des produits retournée avec succès")
    })
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtenir un produit par son ID",
            description = "Retourne les informations d'un produit spécifique à partir de son identifiant"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit trouvé"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé")
    })
    public Produit getProduitById(
            @Parameter(description = "L'identifiant unique du produit", required = true) @PathVariable Long id
    ) {
        return produitService.getProduitById(id);
    }

    @PostMapping
    @Operation(
            summary = "Créer un nouveau produit",
            description = "Ajoute un nouveau produit en utilisant les informations fournies dans le corps de la requête"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produit créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides fournies pour la création")
    })
    public Produit createProduit(
            @Parameter(description = "Les informations du produit à créer", required = true)@Valid @RequestBody ProduitDto produitDto
    ) {
        return produitService.createProduit(produitDto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Mettre à jour un produit existant",
            description = "Modifie les informations d'un produit spécifique à partir de son identifiant"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides fournies pour la mise à jour")
    })
    public ResponseEntity<Produit> updateProduit(
            @Parameter(description = "L'identifiant unique du produit à mettre à jour", required = true) @PathVariable Long id,
            @Parameter(description = "Les nouvelles informations du produit", required = true)@Valid @RequestBody ProduitDto produitDto
    ) {
        return ResponseEntity.ok(produitService.updateProduit(id, produitDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Supprimer un produit par son ID",
            description = "Supprime un produit spécifique à partir de son identifiant"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé")
    })
    public ResponseEntity<String> deleteProduit(
            @Parameter(description = "L'identifiant unique du produit à supprimer", required = true) @PathVariable Long id
    ) {
        return produitService.deleteProduit(id);
    }

//    @GetMapping("/alerte/stockbas")
//    @Operation(
//            summary = "Produits avec stock bas",
//            description = "Retourne une liste de produits qui ont un stock inférieur au seuil défini"
//    )
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "Liste des produits avec stock bas retournée avec succès")
//    })
//    public List<Produit> getProduitsAvecStockBas() {
//        return produitService.getProduitsAvecStockBas();
//    }

    @GetMapping("/quantitefaible")
    @Operation(
            summary = "Produits avec faible quantité",
            description = "Retourne une liste de produits avec des quantités faibles"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des produits avec faible quantité retournée avec succès")
    })
    public List<Produit> getProduitsQuantiteFaile() {
        return produitService.getProduitsAvecFaibleQuantite();
    }
}