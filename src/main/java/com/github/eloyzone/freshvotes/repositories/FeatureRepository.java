package com.github.eloyzone.freshvotes.repositories;

import com.github.eloyzone.freshvotes.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/9/20, 9:09 PM.
 */
@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long>
{

}
