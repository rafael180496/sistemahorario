    CREATE DATABASE shorario;
  ------------------ya----------------------  
    CREATE TABLE Aula (
        id_aula SERIAL  PRIMARY KEY,
        desc_aula TEXT NOT NULL,
        ind_mant BOOLEAN NOT NULL,
        f_creacion DATE NOT NULL
    );

------------------ya----------------------
    CREATE TABLE Profesor (
        id_profesor SERIAL  PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        apellido TEXT NOT NULL, 
        f_creacion DATE NOT NULL
    );
---------------------ya-------------------

    CREATE TABLE Carrera (
        id_carrera SERIAL  PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        f_creacion DATE  NOT NULL
    );
-----------------------------------------------
    CREATE TABLE Usuario (
        id_usuario SERIAL  PRIMARY KEY,
        id_profesor INT NOT NULL,
        nom_usr  CHAR(50) NOT NULL, 
        clave CHAR(30) NOT NULL,
        correo TEXT not null,
        ind_rest BOOLEAN NOT NULL,
        ind_adm BOOLEAN NOT NULL,
        f_creacion DATE NOT NULL
    );

------------------ya----------------------
     CREATE TABLE Clase  (
        id_clase SERIAL  PRIMARY KEY ,
        nombre  TEXT NOT NULL, 
        f_creacion DATE  NOT NULL
    );
----------------------------------------

    CREATE TABLE Alumno (
        
        id_alumno SERIAL PRIMARY KEY ,
        carnet CHAR(15) not null ,
        nombre  TEXT NOT NULL, 
        apellido TEXT NOT NULL,
        id_carrera INT NOT NULL,
        f_creacion    DATE  NOT NULL
    );
    CREATE TABLE Grupo (
        id_grupo SERIAL  PRIMARY KEY,
        id_profesor  INT NOT NULL, 
        id_clase INT NOT NULL,
        nombre TEXT NOT NULL,
        f_creacion    DATE  NOT NULL
    );
    CREATE TABLE Det_grupo (
        id_det_grupo SERIAL  PRIMARY KEY,
        carnet CHAR(15)  NOT NULL,
        id_grupo  INT NOT NULL, 
        f_creacion    DATE  NOT NULL
    );

     CREATE TABLE Horario (
        id_horario SERIAL  PRIMARY KEY ,
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
INSERT INTO Profesor(nombre,apellido,f_creacion)
VALUES
    ( 'Rafael','Hidalgo',to_date('20171027','YYYYMMDD'));
INSERT INTO Profesor(nombre,apellido,f_creacion)
VALUES
    ( 'Marvin', 'Hidalgo', to_date('20171027','YYYYMMDD'));
INSERT INTO Profesor(nombre,apellido,f_creacion)
VALUES
    ( 'Kevin', 'Marquez', to_date('20171027','YYYYMMDD'));

/*insert*/

INSERT INTO Usuario(id_profesor,nom_usr,clave,correo ,ind_rest,ind_adm ,f_creacion )
VALUES  (1,'rhidalgo','upoliei','rafael180496@gmail.com',false,true,to_date('20171027','YYYYMMDD'));  


INSERT INTO Usuario(id_profesor,nom_usr,clave,correo ,ind_rest,ind_adm ,f_creacion )
VALUES  (3,'kmarquez','upoliei','kmarquez@thedataage.com',false,true,to_date('20171027','YYYYMMDD'));  

DELETE FROM Usuario
where id_usuario =2;