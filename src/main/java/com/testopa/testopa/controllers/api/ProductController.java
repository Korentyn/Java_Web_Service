package com.testopa.testopa.controllers.api;
import com.testopa.testopa.domain.Product;
import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.services.ProductService;
import com.testopa.testopa.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Evite de mettre @Response Body à chaque methode + renvoi auto en JSON
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    // @GetMapping(value="/", produces={MediaType.APPLICATION_JSON_VALUE})  = Si besoin de précider le format de retour
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<List<Product>>(this.productService.findProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){  // PathVariable lie le parametre id de la requete GET avec le param entrée de la methode
        Product c = this.productService.findProductsById(id).orElse(null);
        return new ResponseEntity<Product>(c, HttpStatus.OK);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        this.productService.deleteProductsById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> postProduct(@RequestBody Product product){
        Long id = productService.saveProducts(product).getId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> putProduct(@RequestBody Product product){
        //Check if client exist...
        Boolean result = (productService.saveProducts(product) != null);
        HttpStatus status = (result) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<Boolean>(result, status);
    }


}
