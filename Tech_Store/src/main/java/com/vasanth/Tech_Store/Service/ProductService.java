package com.vasanth.Tech_Store.Service;
import com.vasanth.Tech_Store.Exception.productNotFoundException;
import com.vasanth.Tech_Store.Model.Category;
import com.vasanth.Tech_Store.Model.Product;
import com.vasanth.Tech_Store.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product)
    {
         return productRepo.save(product);
    }

    public List<Product> getAll()
    {
        return productRepo.findAll();
    }

    public Page<Product> getProductPages(int pages, int size)
    {
        PageRequest pageable = PageRequest.of(pages,size);
        return productRepo.findAll(pageable);
    }


    public Product getProductById(int id)
    {
       return  productRepo.findById(id).orElseThrow(()->new productNotFoundException("product not found"));
    }

    public List<Product> getProductByCategory(int categoryId)
    {
        return productRepo.findByCategory_categoryId(categoryId);
    }

    public String deleteProductById(int id)
    {
        Product product = productRepo.findById(id).orElseThrow(()->new productNotFoundException("Product Not Found"));
        productRepo.delete(product);
        return "Product Deleted Successfully..";
    }

    public String updateProductById(int id,Product product)
    {
        Product existProduct = productRepo.findById(id).orElseThrow(()-> new productNotFoundException("Product Not Found"));
        existProduct.setName(product.getName());
        existProduct.setCategory(product.getCategory());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        productRepo.save(existProduct);
        return "Update Successfully..";
    }

    public Category getCategotyByProductId(int id)
    {
         Product product =  productRepo.findById(id).orElseThrow(()-> new productNotFoundException("product not found"));
         return product.getCategory();
    }
}
