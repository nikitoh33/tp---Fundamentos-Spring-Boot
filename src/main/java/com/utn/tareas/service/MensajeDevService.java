package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("👋 Bienvenido al entorno de DESARROLLO - ¡Modo debug activo!");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("👨‍💻 Fin de la ejecución en entorno de desarrollo. ¡Buen trabajo!");
    }
}
