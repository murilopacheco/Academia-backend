package br.com.academia.controller;


import br.com.academia.model.Aluno;
import br.com.academia.model.Turma;
import br.com.academia.repository.AlunoRepository;

import br.com.academia.repository.AlunoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/aluno") // This means URL's start with /demo (after Application path)
public class AlunoController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoRepositoryJPA alunoRepositoryJPA;

    @PostMapping("/add")
    protected @Valid Aluno addAluno(@Valid @RequestBody Aluno aluno) {

        return alunoRepository.save(aluno);
    }

    // ------------------- Update Aluno ------------------------------------------------

    @PutMapping(value = "/edit")
    protected @Valid Aluno editAluno(@Valid @RequestBody Aluno aluno) {

        return alunoRepository.save(aluno);
    }

    // ------------------- buscar aluno por id ------------------------------------------------

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public @ResponseBody
    Optional<Aluno> getAlunoByI(@PathVariable(name = "id") long id) {

        return alunoRepository.findById(id);
    }

    @GetMapping(path="/all", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Aluno> getAllAlunos() {
        // This returns a JSON or XML with the users
        return alunoRepository.findAll();
    }

//    @GetMapping(path="/idAll", produces= MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody Iterable<Turma> getTurmasByIdAluno(@RequestParam("id") long id) {
//        // This returns a JSON or XML with the users
//        return alunoRepositoryJPA.listaTurmaByIdAluno(id);
//    }

    @RequestMapping(value="/turmas/{id}", method=RequestMethod.GET)
    public @ResponseBody Iterable<Turma> getTurmasByIdAluno(@PathVariable(name = "id") long id) {
        Iterable<Turma> turmas = alunoRepositoryJPA.listaTurmaByIdAluno(id);
        turmas.forEach(turma -> {turma.setAlunos(null);});
        return turmas;
    }

//    ------------------ delete aluno -----------------------
    @DeleteMapping(value="/delete/{id}")
    public @ResponseBody void deleteAluno(@PathVariable(name = "id") long id) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        alunoRepository.deleteById(aluno.getId());
}

}
