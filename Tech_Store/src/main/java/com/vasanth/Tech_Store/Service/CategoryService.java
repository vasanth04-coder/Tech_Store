package com.vasanth.Tech_Store.Service;


import com.vasanth.Tech_Store.Exception.categoryNotFoundException;
import com.vasanth.Tech_Store.Model.Category;
import com.vasanth.Tech_Store.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    CategoryRepo categoryRepo;
    public CategoryService (CategoryRepo categoryRepo)
    {
        this.categoryRepo = categoryRepo;
    }

   public String addCategory(Category category)
   {
     categoryRepo.save(category);
     return "added Succesfully..";
   }

   public List<Category> getCategories()
   {
       return categoryRepo.findAll();
   }

   public Category getCategoryById(int categoryId)
   {
       return categoryRepo.findById(categoryId).orElseThrow(()->new categoryNotFoundException("Category Not Found"));
   }

   public String deleteCategoryById(int categoryId)
   {
       Category category =  categoryRepo.findById(categoryId).orElseThrow(()->new categoryNotFoundException("Category Not Found.."));
       categoryRepo.delete(category);
       return "Deleted Succesfully,,";
   }

   public String updateCategory(Category category,int categoryId)
   {
       Category existCategory = categoryRepo.findById(categoryId).orElseThrow(()-> new categoryNotFoundException("Category Not Found"));
       existCategory.setCategory_name(category.getCategory_name());
       categoryRepo.save(existCategory);
       return "Update Category Succesfully..";
   }
}

