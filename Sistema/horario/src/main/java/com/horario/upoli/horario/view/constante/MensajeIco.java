package com.horario.upoli.horario.view.constante;

public enum MensajeIco {
    Bien("https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Fsuccess.png?alt=media&token=14404dc6-de50-493e-8aca-8105bef019a9"),
    Advertencia("https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Fexclamation-mark.png?alt=media&token=aff43df2-fbac-4896-a1fb-1fb43cc4da3b"),
    Error("https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Ferror.png?alt=media&token=97996a0f-0cb3-403b-bb0e-cff661caaf78");

    private String mostrar;

    MensajeIco(String mostrar){
        this.mostrar=mostrar;
    }
    public String mostrar() {
        return mostrar;
    }
}
