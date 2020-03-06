package com.github.eloyzone.freshvotes.repositories;

import com.github.eloyzone.freshvotes.domain.Product;
import com.github.eloyzone.freshvotes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/4/20, 11:37 AM.
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{
    // select * from product where user = :user;
    List<Product> findByUser(User user);

    // select * from product where user = :user and name = :name;
//    List<Product> findByUserAndName(User user, String name);
}
