package com.gamemania.controllers;

import com.gamemania.domain.models.Product;
import com.gamemania.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Product>> getByTitle(@PathVariable String title){
        return ResponseEntity.ok().body(productService.getByTitle(title));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(product));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, @PathVariable int id){
        return ResponseEntity.ok().body(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        productService.delete(id);

        return ResponseEntity.ok().build();
    }
}
