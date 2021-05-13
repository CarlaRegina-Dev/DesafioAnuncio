package com.carla.Anuncio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.carla.Anuncio.Model.AnuncioModel;

import java.util.Optional;

@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Long> {

    @Query("select a from AnuncioModel a where a.cliente = ?1")
    AnuncioModel findByCliente(String nomeCliente);


}
