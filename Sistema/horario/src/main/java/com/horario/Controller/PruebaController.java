package com.horario.Controller;




import com.horario.Model.Profesor;
import com.horario.Service.Interface.IProfesorService;
import com.horario.Service.Interface.IUsuario;
import com.horario.Service.Interface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PruebaController {

    IProfesorService profesorService;

    // Get All Notes
    @GetMapping("/todo")
    public Iterable<Profesor> getAllNotes() {
        return profesorService.listAllProfesor();
    }

}
