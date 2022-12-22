//package com.gamemania.controllers;
//
//import com.gamemania.domain.models.Cart;
//import com.gamemania.services.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/cart")
//public class CartController {
//
//    @Autowired
//    CartService cartService;
//
//    @GetMapping
//    public ResponseEntity<List<Cart>> getAll(){
//        return ResponseEntity.ok().body(cartService.getAll());
//    }
//
//    @PostMapping
//    public ResponseEntity<Cart> addItem(@RequestBody Cart item){
//        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.add(item));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable int id){
//        cartService.delete(id);
//
//        return ResponseEntity.ok().build();
//    }
//}
