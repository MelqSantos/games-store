package com.gamemania.services;

import com.gamemania.domain.models.Category;
import com.gamemania.domain.repositories.CategoryRepository;
import com.gamemania.exceptions.ObjNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category add(Category category){

        return categoryRepository.save(category);
    }

    public Category update(int id, Category category){

        Optional<Category> opt = categoryRepository.findById(id);

        if(opt.isPresent()){
            Category categoryUpdate = opt.get();

            categoryUpdate.setDescription(category.getDescription() != null ? category.getDescription() : opt.get().getDescription() );

            return categoryRepository.save(categoryUpdate);
        } else {
            return null;
        }
    }

    public void delete(int id){

        Optional<Category> opt = categoryRepository.findById(id);

        if(opt.isPresent()){
            categoryRepository.deleteById(id);
        } else {
            throw new ObjNotFoundException("Elemento com ID " + id +" não foi localizado");
        }

    }

}
