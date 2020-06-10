package br.com.academia.controller;

import br.com.academia.model.Aluno;
import br.com.academia.model.Plano;
import br.com.academia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/plano") // This means URL's start with /demo (after Application path)
public class PlanoController {

    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping(path="/all", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Plano> getAllPlanos() {
        // This returns a JSON or XML with the users
        return planoRepository.findAll();
    }
}
