package br.edu.senai.crudRest.repository;

import br.edu.senai.crudRest.model.Pessoa;
import br.edu.senai.crudRest.repository.interfaces.PessoaRep;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaDao {
    
    @Autowired
    PessoaRep pessoaRep;
    
    public Pessoa cadastrar(Pessoa pessoa) {
        return pessoaRep.save(pessoa);
    }
    
    public Pessoa alterar(Pessoa pessoa) {
        return pessoaRep.save(pessoa);
    }
    
    public void excluir(Pessoa pessoa) {
        pessoaRep.delete(pessoa.getId());
    }
    
    public Collection<Pessoa> retornaTodas() {
        return pessoaRep.findAll();
    }
    
    public Pessoa buscarPorId(Integer id) {
        return pessoaRep.findOne(id);
    }
}
