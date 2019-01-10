package com.horario.upoli.horario.service;

import com.horario.upoli.horario.model.UsuarioK;
import com.horario.upoli.horario.repo.ClaveK;
import com.horario.upoli.horario.recursos.CorreoK;
import com.horario.upoli.horario.repo.UsuarioRepo;
import com.horario.upoli.horario.seguridad.PermisosK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public Iterable<UsuarioK> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public UsuarioK getUsuarioById(Long id) {
        return usuarioRepo.findOne(id);
    }

    @Override
    public ArrayList<UsuarioK> listaUsuarios() {
        Iterable<UsuarioK> source=usuarioRepo.findAll();
        ArrayList<UsuarioK> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        return Listado;
    }

    @Override
    public UsuarioK Ingresar(String usuario, String Clave) {
        Iterable<UsuarioK> source=usuarioRepo.findAll();
        ArrayList<UsuarioK> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        for (UsuarioK n:Listado
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
        Iterable<UsuarioK> source=usuarioRepo.findAll();
        ArrayList<UsuarioK> Listado= new ArrayList<>();
        source.forEach(Listado::add);

        for (UsuarioK n:Listado
             ) {
            n.setCorreo(n.getCorreo().replace(" ",""));
            if(n.getCorreo().equals(correo))
            {

                String rec= ClaveK.Companion.getClave(ClaveK.Companion.getMINUSCULAS()+
                        ClaveK.Companion.getMAYUSCULAS()+
                        ClaveK.Companion.getESPECIALES(),10);
                rec=rec.replace(" ","");
                n.setInd_rest(true);
                n.setClave(rec);
                usuarioRepo.save(n);
                CorreoK Enviar= new CorreoK();
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
        UsuarioK n= usuarioRepo.findOne(id);
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
    public void GuardarUsuario(UsuarioK usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public Long Secuencia() {
        Iterable<UsuarioK> source=usuarioRepo.findAll();
        ArrayList<UsuarioK> Listado= new ArrayList<>();
        ArrayList<Long> Listadoid= new ArrayList<>();
        source.forEach(Listado::add);

        for (UsuarioK n:Listado
                ) {
            Listadoid.add(n.getId_usuario());
        }

        return PermisosK.Companion.maximoSecuencial(Listadoid)+1;
    }

    @Override
    public ArrayList<UsuarioK> filtrarUsuario(String name) {
        Iterable<UsuarioK> source=usuarioRepo.findAll();
        ArrayList<UsuarioK> Listado= new ArrayList<>();
        ArrayList<UsuarioK> Listadoaux= new ArrayList<>();
        source.forEach(Listadoaux::add);

        name=name.replace(" ","");

        for (UsuarioK n:Listadoaux
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
