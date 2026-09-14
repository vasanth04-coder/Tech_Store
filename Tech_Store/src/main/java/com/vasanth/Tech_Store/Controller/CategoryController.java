package com.vasanth.Tech_Store.Controller;

import com.vasanth.Tech_Store.Model.Category;
import com.vasanth.Tech_Store.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")

public class CategoryController
{
    @Autowired
    CategoryService categoryService;
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @PostMapping("add")
    public ResponseEntity<String> addCategory(@Valid @RequestBody Category category)
    {
       return new ResponseEntity<>(categoryService. addCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Category>> getCategories()
    {
        return new ResponseEntity<>(categoryService.getCategories(),HttpStatus.OK);
    }

    @GetMapping("get/categoryId/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId)
    {
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId),HttpStatus.OK);
    }

    @DeleteMapping("delete/categoryId/{categoryId}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable int categoryId)
    {
        return new ResponseEntity<>(categoryService.deleteCategoryById(categoryId),HttpStatus.OK);
    }

    @PutMapping("update/categoryId/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category,@PathVariable int categoryId)
    {
        return new ResponseEntity<>(categoryService.updateCategory(category,categoryId),HttpStatus.OK);
    }

}
