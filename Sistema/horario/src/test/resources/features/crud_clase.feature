# language: es
Característica: Pagina de login

  Escenario: Prueba Crud Clase
    Dado que estoy en la pagina de Login
    Y yo lleno el campo nombre de usuario con "rhidalgo"
    Y yo lleno el campo contraseña con "upoliei"
    Y yo hago click el boton Ingresar
    Y yo hago click al link Clase
    Y yo hago click al link Agregar Clase
    Y yo lleno el campo clase con "CALCULO1"
    Y yo hago click al Grabar la Clase
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "CALCULO1"
    Y yo hago click  en el boton editar de la fila  con "1"
    Y yo lleno el campo clase con "CALCULO2"
    Y yo hago click al Grabar la Clase
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "CALCULO2"
    Y yo hago click  en el boton eliminar  la fila  de la clase con codigo:"1"
    Y yo hago click en el boton Verde
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "CALCULO2"
    Y Me detengo por 3 segundos