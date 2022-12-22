//package com.gamemania.services;
//
//import com.gamemania.domain.models.Cart;
//import com.gamemania.domain.repositories.CartRepository;
//import com.gamemania.exceptions.ObjNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class CartService {
//
//    @Autowired
//    CartRepository cartRepository;
//
//    public List<Cart> getAll(){
//
//        var cart = cartRepository.findAll();
//
//        // Total dos itens no carrinho
//        BigDecimal sum = new BigDecimal(0);
//        cart.get(0).getProductList().stream()
//                .map(el -> el.getPrice()).collect(Collectors.toList())
//                .forEach(price -> sum.add(price));
//        cart.get(0).setTotal(sum);
//
//        return cart;
//    }
//
//    public Cart add(Cart cart){
//
//        // Total dos itens no carrinho
//        BigDecimal sum = new BigDecimal(0);
//        cart.getProductList().stream()
//                .map(el -> el.getPrice()).collect(Collectors.toList())
//                .forEach(price -> sum.add(price));
//        cart.setTotal(sum);
//
//        return cartRepository.save(cart);
//    }
//
//    public void delete(int id){
//
//        Optional<Cart> opt = cartRepository.findById(id);
//
//        if(opt.isPresent()) {
//            cartRepository.deleteById(id);
//        } else {
//            throw new ObjNotFoundException("Elemento com ID " + id +" não foi localizado");
//        }
//    }
//}
