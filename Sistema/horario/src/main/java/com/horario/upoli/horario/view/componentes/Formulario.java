package com.horario.upoli.horario.view.componentes;

import java.util.ArrayList;

public class Formulario  {
    private ArrayList<String> Cuerpo_formulario=new ArrayList();
    private String Accion ="";
    private String  metodo="";
    private String id_f="Sin";

    public  String Generar_formulario(){
        String Resultado ="";
        String inicio="<form action=\""+Accion+"\" method=\""+metodo+"\" id=\""+id_f+"\">" ;
        String Fin ="</form>";

        Resultado+=inicio;
        for (String n:Cuerpo_formulario
             ) {
            Resultado+=n;
        }
        Resultado+=Fin;
        return Resultado;
    }

    public ArrayList<String> getCuerpo_formulario() {
        return Cuerpo_formulario;
    }

    public void setCuerpo_formulario(ArrayList<String> cuerpo_formulario) {
        Cuerpo_formulario = cuerpo_formulario;
    }

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String accion) {
        Accion = accion;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getId_f() {
        return id_f;
    }

    public void setId_f(String id_f) {
        this.id_f = id_f;
    }
}
