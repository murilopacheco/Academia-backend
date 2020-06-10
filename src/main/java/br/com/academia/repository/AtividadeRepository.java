package br.com.academia.repository;

import br.com.academia.model.Atividade;
import org.springframework.data.repository.CrudRepository;

public interface AtividadeRepository extends CrudRepository<Atividade, Long> {
}
