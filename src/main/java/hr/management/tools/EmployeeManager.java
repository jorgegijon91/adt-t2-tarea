package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.File;
import java.util.ArrayList;

public class EmployeeManager {
    //Array de Employee y Vehicle
    private ArrayList<Employee> employees;
    private ArrayList<Vehicle> vehicles;

    //Constructor
    public EmployeeManager(ArrayList<Employee> employees, ArrayList<Vehicle> vehicles) {
        this.employees = employees;
        this.vehicles = vehicles;
    }

    //Método findEmployeeByDni
    public Employee findEmployeeByDni(String dni) {
        for (Employee employee : employees) {
            if (employee.getDni().equals(dni)) {
                return employee;
            }
        }
        return null; //null si no encuentra el Empleado
    }

    //Método findVehicleByPlate
    public Vehicle findVehicleByPlate(String plate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }
        return null; //null si no encuentra el Vehículo
    }

    //Método assignVehicleToEmploye
    public boolean assignVehicleToEmployee(String dni, String plate) {
        Employee employee = findEmployeeByDni(dni);
        Vehicle vehicle = findVehicleByPlate(plate);

        if (employee != null && vehicle != null && vehicle.getPlate() != null) {
            employee.assignVehicleWithPlate(plate);
            return true;
        }
        return false;
    }

    //Método unassignVehicleFromEmployee
    public boolean unassignVehicleFromEmployee(String dni) {
        Employee employee = findEmployeeByDni(dni);
        if (employee != null) {
            employee.unassignVehicle();
            return true;
        }
        System.out.println("Empleado no encontrado.");
        return false;
    }

    //Método printAllEmployees
    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //Método createEmployeeFolders
    public void createEmployeeFolders() {
        File folder = new File("data/employeeDocuments");
        if (folder.mkdir()) {
            System.out.println("Carpeta 'employeeDocuments' creada.");
            employees.forEach(employee -> {
                File employeeFolder = new File(folder, employee.getDni());
                if (employeeFolder.mkdir()) {
                    System.out.println("Carpeta creada para el empleado con DNI: " + employee.getDni());
                } else {
                    System.out.println("Error al crear la carpeta para el empleado: " + employee.getDni());
                }
            });
        } else {
            System.out.println("Error al crear la carpeta 'employeeDocuments'.");
        }
    }

    //Método removeEmploye
    public boolean removeEmployee(String dni) {
        Employee employee = findEmployeeByDni(dni);
        if (employee != null) {
            employees.remove(employee);
            File employeeFolder = new File("data/employeeDocuments/" + dni);
            if (employeeFolder.exists() && employeeFolder.delete()) {
                System.out.println("Carpeta del empleado con DNI " + dni + " eliminada.");
            } else {
                System.out.println("La carpeta del empleado con DNI " + dni + " no existe.");
            }
            System.out.println("Empleado con DNI " + dni + " eliminado de la lista.");
            return true;
        }
        return false;
    }

}
