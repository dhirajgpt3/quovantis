package com.quovantis.quovantis.repository;

import com.quovantis.quovantis.entity.ApplicationEntity;
import com.quovantis.quovantis.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Dhiraj on 31-07-2020.
 */
@Repository
public interface ApplicationRepository  extends JpaRepository<ApplicationEntity, Long> {

    @Query("SELECT ae From ApplicationEntity ae WHERE ae.candidateEmail= :candidateEmail")
    ApplicationEntity getApplicationByEmail(@Param("candidateEmail") String candidateEmail);

}


