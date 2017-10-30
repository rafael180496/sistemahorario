package com.horario.upoli.horario.view.constante;

public enum Scrips {
    jquery("\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>"),
    materialize("<script src=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/js%2Fmaterialize.js?alt=media&token=ea9cd3ec-9430-4bed-be1f-d560ad47d895\"></script>"),
    init("<script src=\"https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/js%2Finit.js?alt=media&token=fb8a441d-908b-405d-ae1a-9286edc7d8b2\"></script>");


    private String mostrar;

    Scrips(String mostrar){
        this.mostrar=mostrar;
    }
    public String mostrar() {
        return mostrar;
    }
}
