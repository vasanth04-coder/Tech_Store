package com.vasanth.Tech_Store.Repository;

import com.vasanth.Tech_Store.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>
{

}
