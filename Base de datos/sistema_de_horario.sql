    CREATE DATABASE shorario;
    
    CREATE TABLE aula (
        id_aula SERIAL PRIMARY KEY,
        desc_aula TEXT,
        ind_mant BOOLEAN,
        f_creacion DATE
    );


    CREATE TABLE profesor (
        id_profesor SERIAL PRIMARY KEY,
        nombre  TEXT, 
        apellido TEXT,
        f_creacion DATE 
    );


