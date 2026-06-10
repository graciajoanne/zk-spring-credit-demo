package com.fif.services.impl;

import com.fif.entity.Application;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseAppRepository extends JpaRepository<Application, String> {
    List<Application> findAll();

    List<Application> findByNamaLengkap(String namaLengkap);
}