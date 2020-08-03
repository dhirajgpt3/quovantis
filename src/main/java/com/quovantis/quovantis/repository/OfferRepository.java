package com.quovantis.quovantis.repository;

/**
 * Created by Dhiraj on 31-07-2020.
 */

import com.quovantis.quovantis.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query("SELECT oe From OfferEntity oe WHERE oe.jobTital= :jobTital")
    OfferEntity getOfferByJobTitle(@Param("jobTital") String jobTital);

}


