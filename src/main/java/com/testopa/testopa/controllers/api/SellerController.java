package com.testopa.testopa.controllers.api;
import com.testopa.testopa.domain.Product;
import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Evite de mettre @Response Body à chaque methode + renvoi auto en JSON
@RequestMapping("api/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping("/")
    // @GetMapping(value="/", produces={MediaType.APPLICATION_JSON_VALUE})  = Si besoin de précider le format de retour
    public ResponseEntity<List<Seller>> getSellers(){
        return new ResponseEntity<List<Seller>>(this.sellerService.findSellers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id){  // PathVariable lie le parametre id de la requete GET avec le param entrée de la methode
        Seller c = this.sellerService.findSellersById(id).orElse(null);
        return new ResponseEntity<Seller>(c, HttpStatus.OK);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id){
        this.sellerService.deleteSellersById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> postSeller(@RequestBody Seller seller){
        Long id = sellerService.saveSellers(seller).getId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> putSeller(@RequestBody Seller seller){
        //Check if client exist...
        Boolean result = (sellerService.saveSellers(seller) != null);
        HttpStatus status = (result) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<Boolean>(result, status);
    }


}


