package com.vasanth.Tech_Store.Repository;

import com.vasanth.Tech_Store.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{
    List<Product>findByCategory_categoryId(int categoryId);
}

