package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public Iterable<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepo.findOne(id);
    }

    @Override
    public Usuario Ingresar(String usuario, String Clave) {
        Iterable<Usuario> source=usuarioRepo.findAll();
        ArrayList<Usuario> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        for (Usuario n:Listado
             ) {
            n.setNom_usr(n.getNom_usr().replace(" ",""));
            n.setClave(n.getClave().replace(" ",""));

            if((n.getNom_usr().equals(usuario))&&( n.getClave().equals(Clave)))
            {
                return n;
            }
        }



        return null;
    }
}
