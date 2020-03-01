package com.github.eloyzone.freshvotes.repositories;

import com.github.eloyzone.freshvotes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/29/20, 8:02 PM.
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
