package com.horario.Service.Implement;

import com.horario.Model.Usuario;
import com.horario.Service.Interface.IUsuario;
import com.horario.Service.Interface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService implements IUsuarioService {

    private IUsuario usuarioRepo;

    @Autowired
    public void setUsuarioRepo(IUsuario usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Iterable<Usuario> listAllUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario getUsuarioById(long id) {
        return usuarioRepo.findOne(id);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public void deleteUsuario(long id) {
        usuarioRepo.delete(id);
    }
}
