package com.horario.upoli.horario.view.Const;

public enum Estilos {
    Material_Icons("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">"),
    materialize("<link href=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/css%2Fmaterialize.css?alt=media&token=c1182d85-8ade-444f-a1ff-9b0ec66bcd15\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />"),
    style("<link href=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/css%2Fstyle.css?alt=media&token=d0885422-4ed6-4d03-93c0-a3070be51101\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\" />");

    private String mostrar;

    Estilos(String mostrar){
        this.mostrar=mostrar;
    }
    public String mostrar() {
        return mostrar;
    }
}
