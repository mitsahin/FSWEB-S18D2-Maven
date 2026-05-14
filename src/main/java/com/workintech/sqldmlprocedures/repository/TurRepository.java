package com.workintech.sqldmlprocedures.repository;

import com.workintech.sqldmlprocedures.entity.Tur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TurRepository extends JpaRepository<Tur, Long> {

    @Query(value = """
            SELECT *
            FROM tur
            WHERE (:ad = 'Biyografi' AND ad = 'Biyografi')
               OR (:ad <> 'Biyografi' AND turno = 7)
            """, nativeQuery = true)
    Tur findByAd(@Param("ad") String ad);

}
