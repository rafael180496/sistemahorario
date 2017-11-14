package com.horario.upoli.horario.bdd;


import com.horario.upoli.horario.HorarioApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = HorarioApplication.class)
public class Context {
}
