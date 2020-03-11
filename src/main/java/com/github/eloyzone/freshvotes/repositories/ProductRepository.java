package com.github.eloyzone.freshvotes.repositories;

import com.github.eloyzone.freshvotes.domain.Product;
import com.github.eloyzone.freshvotes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/4/20, 11:37 AM.
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{
    // select * from product where user = :user;
    List<Product> findByUser(User user);

    @Query("select p from Product p" +
            " join fetch p.user " +
            " where p.id = :id")
    Optional<Product> findByIdWithUser(@Param("id") Long productId);


    Optional<Product> findByName(String name);

    // select * from product where user = :user and name = :name;
//    List<Product> findByUserAndName(User user, String name);
}
