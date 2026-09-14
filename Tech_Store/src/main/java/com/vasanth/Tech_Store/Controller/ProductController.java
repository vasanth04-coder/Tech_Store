package com.vasanth.Tech_Store.Controller;

import com.vasanth.Tech_Store.Model.Category;
import com.vasanth.Tech_Store.Model.Product;
import com.vasanth.Tech_Store.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController
{
    @Autowired
    ProductService productService;
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product)
    {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @GetMapping("pages")
    public ResponseEntity<Page<Product>> getProductPages(@RequestParam int page, @RequestParam int size)
    {
        return new ResponseEntity<>(productService.getProductPages(page,size),HttpStatus.OK);
    }

    @GetMapping("get/id/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id)
    {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("get/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable int categoryId)
    {
        return new ResponseEntity<>(productService.getProductByCategory(categoryId), HttpStatus.OK);
    }

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id )
    {
        return new ResponseEntity<>(productService.deleteProductById(id),HttpStatus.OK);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<String> updateById(@Valid @PathVariable int id,@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.updateProductById(id,product),HttpStatus.OK);
    }

    @GetMapping("get/categoryByProductId/{id}")
    public ResponseEntity<Category> getCategotyByProductId(@PathVariable int id)
    {
        return new ResponseEntity<>(productService.getCategotyByProductId(id),HttpStatus.OK);
    }
}

