package br.com.academia.repository;


import br.com.academia.model.Aluno;
import br.com.academia.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface LoginRepository extends CrudRepository<Usuario, Long> {

}
