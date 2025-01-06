package com.example.student_management.Controllers;

import com.example.student_management.Domain.estudiante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class ControllerEstudiante {
    private List<estudiante> estudiantes = new ArrayList<>(Arrays.asList(
            new estudiante(123,"Alejandro","alejandro@gmail.com",20,11),
            new estudiante(456,"Sebastian","sebastian@gmail.com",15,7),
            new estudiante(789,"Daniel","daniel@gmail.com",17,6),
            new estudiante(109,"Laura","laura@gmail.com",25,16)
    ));

    @GetMapping
    public List<estudiante> getEstudiantes(){
        return estudiantes;
    }

    @GetMapping("/{email}")
    public estudiante getEstudianteEmail(@PathVariable String email){
        for (estudiante c : estudiantes){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public estudiante postEstudiante(@RequestBody estudiante estudiante){
        estudiantes.add(estudiante);
        return estudiante;
    }

    @PutMapping
    public estudiante putEstudiante(@RequestBody estudiante estudiante){
        for (estudiante c : estudiantes){
            if(c.getID() == estudiante.getID()){
                c.setNombre(estudiante.getNombre());
                c.setEmail(estudiante.getEmail());
                c.setEdad(estudiante.getEdad());
                c.setCurso(estudiante.getCurso());
                return c;
            }
        }
        return null;
    }

    @PatchMapping
    public estudiante patchEstudiante(@RequestBody estudiante estudiante){
        for (estudiante c : estudiantes){
            if(c.getID() == estudiante.getID()){
                if (estudiante.getNombre() != null){
                    c.setNombre(estudiante.getNombre());
                }
                if(estudiante.getEmail() != null){
                    c.setEmail(estudiante.getEmail());
                }
                if(estudiante.getEdad() != 0){
                    c.setEdad(estudiante.getEdad());
                }
                if(estudiante.getCurso() != 0){
                    c.setCurso(estudiante.getCurso());
                }
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public estudiante deleteEstudiante(@PathVariable int id){
        for(estudiante c:estudiantes){
            if(c.getID() == id){
                estudiantes.remove(c);
                return c;
            }
        }
        return null;
    }
}
