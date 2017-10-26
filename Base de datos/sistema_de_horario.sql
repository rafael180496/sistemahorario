    CREATE DATABASE shorario;
    
    CREATE TABLE aula (
        id_aula INT PRIMARY KEY,
        desc_aula TEXT NOT NULL,
        ind_mant BOOLEAN NOT NULL,
        f_creacion DATE NOT NULL
    );


    CREATE TABLE profesor (
        id_profesor int PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        apellido TEXT NOT NULL, 
        f_creacion DATE NOT NULL
    );

    CREATE TABLE carrera (
        id_carrera int PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        f_creacion DATE  NOT NULL
    );

    CREATE TABLE usuario (
        id_usuario int PRIMARY KEY,
        nom_usr  CHAR(50) NOT NULL, 
        clave CHAR(30) NOT NULL,
        id_profesor INT NOT NULL,
        ind_adm BOOLEAN NOT NULL,
        f_creacion DATE NOT NULL
    );

     CREATE TABLE clase  (
        id_clase int PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        f_creacion DATE  NOT NULL
    );

    CREATE TABLE alumno (
        carnet CHAR(15) PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        apellido TEXT NOT NULL,
        id_carrera INT NOT NULL,
        f_creacion    DATE  NOT NULL
    );
    CREATE TABLE grupo (
        id_grupo int PRIMARY KEY,
        id_profesor  INT NOT NULL, 
        id_clase INT NOT NULL,
        nombre TEXT NOT NULL,
        f_creacion    DATE  NOT NULL
    );
    CREATE TABLE det_grupo (
        carnet CHAR(15)  NOT NULL,
        id_grupo  INT NOT NULL, 
        f_creacion    DATE  NOT NULL
    );

     CREATE TABLE horario (
        id_horario int PRIMARY KEY ,
        id_clase INT  NOT NULL,
        id_grupo INT  NOT NULL,
        id_aula INT  NOT NULL,
        dia  TEXT NOT NULL, 
        hora_inicio    INT  NOT NULL,
        min_inicio INT  NOT NULL,
        hora_fin INT  NOT NULL,
        min_fin INT  NOT NULL,
        f_creacion    DATE  NOT NULL
    );


