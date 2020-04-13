package br.com.academia.repository;

import br.com.academia.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepositoryJPA extends JpaRepository<Turma, Long> {

    @Query(value = "select t.id, t.nome, t.horario, t.atividade from turma t " +
            "inner join turma_alunos ta on t.id = ta.turma_id " +
            "inner join aluno a on ta.alunos_id = a.id " +
            "where a.id = ?1",
            nativeQuery = true)
//     @Query("select t from Turma  t join Aluno  a where a.id = ?1" )
    public List<Turma> listaTurmaByIdAluno(@Param("id") long id);

}

