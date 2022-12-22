package com.gamemania.controllers;

import com.gamemania.domain.models.Category;
import com.gamemania.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok().body(categoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.add(category));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> editCategory(@RequestBody Category category, @PathVariable int id){
        return ResponseEntity.ok().body(categoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        categoryService.delete(id);

        return ResponseEntity.ok().build();
    }

}
