package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.Usuario;
import com.horario.upoli.horario.recursos.Clave;
import com.horario.upoli.horario.recursos.Correo;
import com.horario.upoli.horario.repo.UsuarioRepo;
import com.horario.upoli.horario.seguridad.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
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
    public ArrayList<Usuario> listaUsuarios() {
        Iterable<Usuario> source=usuarioRepo.findAll();
        ArrayList<Usuario> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
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

    @Override
    public boolean Recuperacion(String correo) {
        Iterable<Usuario> source=usuarioRepo.findAll();
        ArrayList<Usuario> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        for (Usuario n:Listado
             ) {
            n.setCorreo(n.getCorreo().replace(" ",""));
            if(n.getCorreo().equals(correo))
            {
                String rec= Clave.getClave(Clave.MINUSCULAS+
                        Clave.MAYUSCULAS+
                        Clave.ESPECIALES,10);
                rec=rec.replace(" ","");
                n.setInd_rest(true);
                n.setClave(rec);
                usuarioRepo.save(n);
                Correo Enviar= new Correo();
                Enviar.setAsunto("Recuperación de contraseña ");
                Enviar.setPara(n.getCorreo());
                Enviar.setMensage("Esta clave es de recuperación cuando la introduzca debe de cambiar la contraseña:"+n.getClave());
                Enviar.SendMail();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Cambiar_clave(Long id, String clave) {
        Usuario n= usuarioRepo.findOne(id);
        clave=clave.replace(" ","");
        n.setClave(clave);
        n.setInd_rest(false);
        usuarioRepo.save(n);
        return true;
    }

    @Override
    public void EliminarUsuario(Long id) {
        usuarioRepo.delete(id);
    }

    @Override
    public void GuardarUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public Long Secuencia() {
        Iterable<Usuario> source=usuarioRepo.findAll();
        ArrayList<Usuario> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (Usuario n:Listado
                ) {
            Listadoid.add(n.getId_usuario());
        }

        return Permisos.maximoSecuencial(Listadoid)+1;
    }

    @Override
    public ArrayList<Usuario> filtrarUsuario(String name) {
        Iterable<Usuario> source=usuarioRepo.findAll();
        ArrayList<Usuario> Listado= new ArrayList<>();
        ArrayList<Usuario> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (Usuario n:Listadoaux
                ) {
            n.setNom_usr(n.getNom_usr().replace(" ",""));

            if((n.getNom_usr().toLowerCase().matches(name+"(.*)")))
            {
                Listado.add(n);
            }
        }

        return Listado;
    }
}
