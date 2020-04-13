package br.com.academia.repository;

import br.com.academia.model.Turma;
import org.springframework.data.repository.CrudRepository;

public interface TurmaRepository  extends CrudRepository<Turma, Long> {

    Turma findById(long id, Class<Turma> turmaClass);
}
