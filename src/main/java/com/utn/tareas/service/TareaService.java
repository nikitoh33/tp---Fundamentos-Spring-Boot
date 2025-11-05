package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Value("${app.nombre}")
    private String nombreApp;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        if (tareaRepository.obtenerTodas().size() >= maxTareas) {
            throw new IllegalStateException("⚠️ Se alcanzó el límite máximo de tareas permitidas (" + maxTareas + ")");
        }
        Tarea nueva = new Tarea(null, descripcion, false, prioridad);
        return tareaRepository.guardar(nueva);
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas()
                .stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas()
                .stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public boolean marcarComoCompletada(Long id) {
        return tareaRepository.buscarPorId(id)
                .map(t -> {
                    t.setCompletada(true);
                    return true;
                })
                .orElse(false);
    }

    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) {
            return "🔕 Las estadísticas están deshabilitadas.";
        }

        List<Tarea> todas = tareaRepository.obtenerTodas();
        long total = todas.size();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;

        return String.format(
                "📊 Estadísticas: Total=%d, Completadas=%d, Pendientes=%d",
                total, completadas, pendientes
        );
    }

    // Método nuevo: mostrar propiedades de configuración
    public void mostrarConfiguracion() {
        System.out.println("🧩 Configuración actual:");
        System.out.println("Aplicación: " + nombreApp);
        System.out.println("Máximo de tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
    }
}
