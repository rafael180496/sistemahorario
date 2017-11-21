# language: es
Característica: Pagina de login

  Escenario: Prueba Crud Carrera
    Dado que estoy en la pagina de Login
    Y yo lleno el campo nombre de usuario con "rhidalgo"
    Y yo lleno el campo contraseña con "upoliei"
    Y yo hago click el boton Ingresar
    Y yo hago click al link Carrera
    Y yo hago click al link Agregar
    Y yo lleno el campo carrera con "ALGORITMO"
    Y yo hago click al Grabar
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "ALGORITMO"
    Y yo hago click  en el boton editar de la fila  con "1"
    Y yo lleno el campo carrera con "Algoritmo2"
    Y yo hago click al Grabar
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "ALGORITMO2"
    Y yo hago click  en el boton elimnar de la fila  con "1"
    Y yo hago click en el boton Verde
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "ALGORITMO2"
    Y Me detengo por 3 segundos
