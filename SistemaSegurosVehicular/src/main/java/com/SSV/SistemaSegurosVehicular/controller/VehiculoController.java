package com.SSV.SistemaSegurosVehicular.controller;

import com.SSV.SistemaSegurosVehicular.model.Vehiculo;
import com.SSV.SistemaSegurosVehicular.repository.VehiculoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoRepository repository;
    public VehiculoController(VehiculoRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public List<Vehiculo> getAll(){
        return repository.findAll();
    }
    @PostMapping
    public Vehiculo create(@RequestBody Vehiculo vehiculo){
        return repository.save(vehiculo);
    }
    @GetMapping("/{id}")
    public Optional<Vehiculo> getById(@PathVariable Long id){
        return repository.findById(id);
    }
    @PutMapping("/{id}")
    public Vehiculo update(@PathVariable Long id, @RequestBody Vehiculo vehiculo){
        Vehiculo existente = repository.findById(id).orElse(null);
        if (existente == null) {
        return null;
        }
        existente.setPlaca(vehiculo.getPlaca());
        existente.setMarca(vehiculo.getMarca());
        existente.setModelo(vehiculo.getModelo());
        existente.setAnio(vehiculo.getAnio());
        existente.setColor(vehiculo.getColor());
        return repository.save(existente);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
    }

