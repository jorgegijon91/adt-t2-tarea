package hr.management.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class JsonManager {
    //Atributo objectMapper
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Guarda una lista de empleados en un archivo JSON
    public static boolean saveEmployeesToJson(ArrayList<Employee> employees, String filePath) {
        try {
            File file = new File(filePath);
            File directory = file.getParentFile();

            if (directory != null && !directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directorio creado: " + directory.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el directorio: " + directory.getAbsolutePath());
                    return false;
                }
            }

            objectMapper.writeValue(file, employees);
            System.out.println("Empleados guardados exitosamente en JSON.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar empleados en JSON: " + e.getMessage());
            return false;
        }
    }

    // Carga una lista de empleados desde un archivo JSON
    public static ArrayList<Employee> loadEmployeesFromJson(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
            } else {
                System.out.println("El archivo " + filePath + " no existe.");
                return new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar empleados desde JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Guarda una lista de vehículos en un archivo JSON
    public static boolean saveVehiclesToJson(ArrayList<Vehicle> vehicles, String filePath) {
        try {
            File file = new File(filePath);
            File directory = file.getParentFile();

            if (directory != null && !directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directorio creado: " + directory.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el directorio: " + directory.getAbsolutePath());
                    return false;
                }
            }

            objectMapper.writeValue(file, vehicles);
            System.out.println("Vehículos guardados exitosamente en JSON.");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar vehículos en JSON: " + e.getMessage());
            return false;
        }
    }

    // Carga una lista de vehículos desde un archivo JSON
    public static ArrayList<Vehicle> loadVehiclesFromJson(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Vehicle.class));
            } else {
                System.out.println("El archivo " + filePath + " no existe.");
                return new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar vehículos desde JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
