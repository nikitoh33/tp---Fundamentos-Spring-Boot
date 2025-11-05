package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

	private final TareaService tareaService;
	private final MensajeService mensajeService;

	// Inyección por constructor
	public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
		this.tareaService = tareaService;
		this.mensajeService = mensajeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// 1️⃣ Mostrar mensaje de bienvenida
		mensajeService.mostrarBienvenida();

		// 2️⃣ Mostrar configuración actual
		tareaService.mostrarConfiguracion();

		// 3️⃣ Listar todas las tareas iniciales
		System.out.println("\n📋 Tareas iniciales:");
		tareaService.listarTodas().forEach(System.out::println);

		// 4️⃣ Agregar una nueva tarea
		System.out.println("\n➕ Agregando una nueva tarea...");
		tareaService.agregarTarea("Terminar el TP de Spring Boot", Prioridad.ALTA);

		// 5️⃣ Listar tareas pendientes
		System.out.println("\n🕒 Tareas pendientes:");
		tareaService.listarPendientes().forEach(System.out::println);

		// 6️⃣ Marcar una tarea como completada
		System.out.println("\n✅ Marcando la tarea con ID 1 como completada...");
		tareaService.marcarComoCompletada(1L);

		// 7️⃣ Mostrar estadísticas
		System.out.println("\n📊 " + tareaService.obtenerEstadisticas());

		// 8️⃣ Listar tareas completadas
		System.out.println("\n🏁 Tareas completadas:");
		tareaService.listarCompletadas().forEach(System.out::println);

		// 9️⃣ Mostrar mensaje de despedida
		System.out.println();
		mensajeService.mostrarDespedida();
	}
}
