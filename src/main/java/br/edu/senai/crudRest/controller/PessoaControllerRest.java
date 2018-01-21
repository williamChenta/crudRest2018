package br.edu.senai.crudRest.controller;

import br.edu.senai.crudRest.repository.PessoaDao;
import br.edu.senai.crudRest.model.Pessoa;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaControllerRest {
    
    @Autowired
    PessoaDao pdao;
    
    @RequestMapping(method = RequestMethod.POST, value = "/pessoas", 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {        
        Pessoa pessoaCadatrada = pdao.cadastrar(pessoa);
        return new ResponseEntity<>(pessoaCadatrada, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/pessoas", 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> alterarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaCadatrada = pdao.alterar(pessoa);
        return new ResponseEntity<>(pessoaCadatrada, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/pessoas/{id}")
    public ResponseEntity<Pessoa> excluirPessoa(@PathVariable Integer id) {
        Pessoa pessoa = pdao.buscarPorId(id);
        if(pessoa != null) {
            pdao.excluir(pessoa);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }    
    
    //teste
    //outro teste 22

    @RequestMapping(method = RequestMethod.GET, value = "/pessoas", 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Pessoa>> listarPessoas() {
        return new ResponseEntity<>(pdao.retornaTodas(), HttpStatus.OK);
    }
}
