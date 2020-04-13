package br.com.academia.repository;


import br.com.academia.model.Aluno;
import org.springframework.data.repository.CrudRepository;


public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
