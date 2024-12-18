package rocks.zipcode.piro360j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.piro360j.domain.Piro;
import rocks.zipcode.piro360j.service.PiroService;

import java.util.List;

@RestController
@RequestMapping("/api/piros/")
public class PiroController {

    @Autowired
    private PiroService piroService;

    @GetMapping
    public List<Piro> getAllPiros() {
        return piroService.findAll();
    }

    @PostMapping
    public Piro createPiro(@RequestBody Piro piro) {
        return piroService.save(piro);
    }

    @DeleteMapping("/{id}")
    public void deletePiro(@PathVariable Long id) {
        piroService.deleteById(id);
    }
}
