package com.vasanth.Tech_Store.Repository;

import com.vasanth.Tech_Store.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>
{
     Users findByEmail(String email);
}
