package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public TareaRepository() {
        // Inicializamos con tareas de ejemplo
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Comprar comida", false, Prioridad.ALTA));
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Estudiar Spring Boot", false, Prioridad.MEDIA));
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Lavar el auto", true, Prioridad.BAJA));
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Hacer ejercicio", false, Prioridad.MEDIA));
    }

    public List<Tarea> obtenerTodas() {
        return tareas;
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Tarea guardar(Tarea tarea) {
        tarea.setId(contadorId.getAndIncrement());
        tareas.add(tarea);
        return tarea;
    }

    public void eliminarPorId(Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }
}
