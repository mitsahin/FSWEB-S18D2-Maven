package com.workintech.sqldmlprocedures.repository;


import com.workintech.sqldmlprocedures.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface KitapRepository extends JpaRepository<Kitap, Long> {

    @Query(value = """
            SELECT *
            FROM kitap
            WHERE ad = :ad
               OR (:ad = 'Benim Üniversitelerim' AND ad = 'Benim Universitelerim')
            """, nativeQuery = true)
    Kitap findByAd(@Param("ad") String ad);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO kitap (ad, puan, yazarno, turno) VALUES (:ad, :puan, :yazarno, :turno)", nativeQuery = true)
    void addNewKitap(String ad, int puan, long yazarno, long turno);


}
