package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.Entity.Marca;
import br.com.uniamerica.estacionamento.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    List<Marca> findByAtivo(boolean ativo);
    @Modifying
    @Query(value = "UPDATE marcas SET ativo = false WHERE id = :id", nativeQuery = true)
    public void desativar(@Param("id") Long id);
}
