package com.github.eloyzone.freshvotes.repositories;

import com.github.eloyzone.freshvotes.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/4/20, 11:37 AM.
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
