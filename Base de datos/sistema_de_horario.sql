    CREATE DATABASE shorario;
    
    CREATE TABLE Aula (
        id_aula INT PRIMARY KEY,
        desc_aula TEXT NOT NULL,
        ind_mant BOOLEAN NOT NULL,
        f_creacion DATE NOT NULL
    );


    CREATE TABLE Profesor (
        id_profesor int PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        apellido TEXT NOT NULL, 
        f_creacion DATE NOT NULL
    );

    CREATE TABLE Carrera (
        id_carrera int PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        f_creacion DATE  NOT NULL
    );

    CREATE TABLE Usuario (
        id_usuario int PRIMARY KEY,
        id_profesor INT NOT NULL,
        nom_usr  CHAR(50) NOT NULL, 
        clave CHAR(30) NOT NULL,
        ind_rest BOOLEAN NOT NULL,
        ind_adm BOOLEAN NOT NULL,
        f_creacion DATE NOT NULL
    );

     CREATE TABLE Clase  (
        id_clase int PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        f_creacion DATE  NOT NULL
    );

    CREATE TABLE Alumno (
        carnet CHAR(15) PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        apellido TEXT NOT NULL,
        id_carrera INT NOT NULL,
        f_creacion    DATE  NOT NULL
    );
    CREATE TABLE Grupo (
        id_grupo int PRIMARY KEY,
        id_profesor  INT NOT NULL, 
        id_clase INT NOT NULL,
        nombre TEXT NOT NULL,
        f_creacion    DATE  NOT NULL
    );
    CREATE TABLE Det_grupo (
        id_det_grupo int PRIMARY KEY,
        carnet CHAR(15)  NOT NULL,
        id_grupo  INT NOT NULL, 
        f_creacion    DATE  NOT NULL
    );

     CREATE TABLE Horario (
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

/*insert*/
INSERT INTO Profesor
VALUES
    (1, 'Rafael','Hidalgo',to_date('20171027','YYYYMMDD'));
INSERT INTO Profesor
VALUES
    (2, 'Marvin', 'Hidalgo', to_date('20171027','YYYYMMDD'));
INSERT INTO Profesor
VALUES
    (3, 'Kevin', 'Marquez', to_date('20171027','YYYYMMDD'));



INSERT INTO Usuario
VALUES  (1,'rhidalgo','upoliei',true,true,to_date('20171027','YYYYMMDD'));  
