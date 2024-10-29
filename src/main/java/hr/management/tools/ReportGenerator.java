package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportGenerator {

    public static void generateReport(ArrayList<Employee> employees, ArrayList<Vehicle> vehicles, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("Informe de empleados con vehículos asignados\n");
            writer.write("===========================================\n");

            for (Employee employee : employees) {
                if (employee.getVehiclePlate() != null) {
                    Vehicle assignedVehicle = null;

                    // Buscar el vehículo asignado al empleado
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.getPlate().equals(employee.getVehiclePlate())) {
                            assignedVehicle = vehicle;
                            break;
                        }
                    }

                    // Generar la entrada del informe si el empleado tiene un vehículo asignado
                    if (assignedVehicle != null) {
                        writer.write("Empleado:\n");
                        writer.write("  DNI: " + employee.getDni() + "\n");
                        writer.write("  Nombre: " + employee.getName() + "\n");
                        writer.write("  Año Contratado: " + employee.getYearHired() + "\n");
                        writer.write("  Vehículo:\n");
                        writer.write("    Marca: " + assignedVehicle.getBrand() + "\n");
                        writer.write("    Modelo: " + assignedVehicle.getModel() + "\n");
                        writer.write("    Matrícula: " + assignedVehicle.getPlate() + "\n");
                        writer.write("    Año: " + assignedVehicle.getYearBought() + "\n");
                        writer.write("===========================================\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }
}
