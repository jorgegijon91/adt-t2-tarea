package hr.management.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManager {
    //Atributo objectMapper
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static boolean saveEmployeesToJson(ArrayList<Employee> employees, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), employees);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static ArrayList<Employee> loadEmployeesFromJson(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static boolean saveVehiclesToJson(ArrayList<Vehicle> vehicles, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), vehicles);
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public static ArrayList<Vehicle> loadVehiclesFromJson(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Vehicle.class));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
