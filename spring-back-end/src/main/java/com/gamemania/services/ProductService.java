package com.gamemania.services;

import com.gamemania.domain.models.Product;
import com.gamemania.domain.repositories.ProductRepository;
import com.gamemania.exceptions.ObjNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product add(Product product){
        return productRepository.save(product);
    }

    public  Product getById(int id){
        return productRepository.findById(id)
                .orElseThrow( () -> new ObjNotFoundException("Elemento com ID " + id +" não foi localizado"));
    }

    public List<Product> getByTitle(String title){
        return productRepository.findByTitleContainsIgnoreCase(title)
                .orElseThrow( () -> new ObjNotFoundException("Elemento com título " + title + " não foi localizado"));
    }

    public Product update(int id, Product product){

        Optional<Product> opt = productRepository.findById(id);

        if(opt.isPresent()){
            Product productUpdate = opt.get();

            productUpdate.setCategory(product.getCategory() != null ? product.getCategory() : opt.get().getCategory() );
            productUpdate.setImg_url(product.getImg_url() != null ? product.getImg_url() : opt.get().getImg_url() );
            productUpdate.setStars(product.getStars() != 0 ? product.getStars() : opt.get().getStars() );
            productUpdate.setTitle(product.getTitle() != null ? product.getTitle() : opt.get().getTitle() );
            productUpdate.setPrice(product.getPrice() != null ? product.getPrice() : opt.get().getPrice() );

            return productRepository.save(productUpdate);
        } else {
            return null;
        }
    }

    public void delete(int id){

        Optional<Product> opt = productRepository.findById(id);

        if(opt.isPresent()){
            productRepository.deleteById(id);
        } else {
            throw new ObjNotFoundException("Elemento com ID " + id +" não foi localizado");
        }

    }
}
