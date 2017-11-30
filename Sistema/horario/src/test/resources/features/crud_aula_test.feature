# language: es
Característica: Pagina de login

  Escenario: Prueba Crud Aula
    Dado que estoy en la pagina de Login
    Y yo lleno el campo nombre de usuario con "rhidalgo"
    Y yo lleno el campo contraseña con "upoliei"
    Y yo hago click el boton Ingresar
    Y yo hago click al link Aula
    Y yo hago click al link Agregar Aula
    Y yo lleno el campo descripcion del aula con: "H5"
    Y yo hago click al Mantenimiento
    Y yo hago click al Grabar la Aula
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "H5"
    Y yo hago click  en el boton editar la fila de aula: "8"
    Y yo lleno el campo descripcion del aula con: "H7"
    Y yo hago click al Grabar la Aula
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "H7"
    Y yo hago click  en el boton eliminar  la fila  de la aula con codigo:"8"
    Y yo hago click en el boton Verde
    Y yo hago click en el boton Verde
    Y yo deberia poder ver el texto "H7"
    Y Me detengo por 3 segundos