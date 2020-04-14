package br.com.academia.controller;

import br.com.academia.model.Turma;
import br.com.academia.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/turma")
public class TurmaController {


    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping(path="/all", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Turma> getAllTurmas()
    {
        return turmaRepository.findAll();
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public @ResponseBody
    Optional<Turma> getTurmasByI(@PathVariable(name = "id") long id) {

        return turmaRepository.findById(id);
    }

    // -------------------Create Turma-------------------------------------------


    @PostMapping("/add")
    protected @Valid Turma addTurma(@Valid @RequestBody Turma turma) {

        return turmaRepository.save(turma);
    }

    // ------------------- Update Turma ------------------------------------------------

    @PutMapping(value = "/edit")
    protected @Valid Turma editTurma(@Valid @RequestBody Turma turma) {

        return turmaRepository.save(turma);
    }

    // ------------------- Delete Turma -----------------------------------------

//    @DeleteMapping(value = "/delete")
//    protected void deleteTurma(@Valid @RequestBody Turma turma) {
//        turmaRepository.delete(turma);
//    }

    @DeleteMapping(value="/delete/{id}")
    public @ResponseBody void deleteTurma(@PathVariable(name = "id") long id) {
        Turma turma =  new Turma();
        turma.setId(id);
        turmaRepository.deleteById(turma.getId());
    }

}
