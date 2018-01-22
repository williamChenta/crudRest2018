package br.edu.senai.crudRest.repository.interfaces;

import br.edu.senai.crudRest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRep extends JpaRepository<Pessoa, Integer>{
    
}
