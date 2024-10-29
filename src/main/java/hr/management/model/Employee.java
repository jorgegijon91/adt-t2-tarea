package hr.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    //Atributos
    private String dni;
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("añoContratado")
    private int yearHired;
    @JsonProperty("matriculaVehiculo")
    private String vehiclePlate;

    //Constructor vacío
    public Employee() {

    }
    //Constructor
    public Employee(String dni, String name, int yearHired, String vehiclePlate) {
        this.dni = dni;
        this.name = name;
        this.yearHired = yearHired;
        this.vehiclePlate = vehiclePlate;
    }

    //Getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getYearHired() {
        return yearHired;
    }

    public void setYearHired(int yearHired) {
        this.yearHired = yearHired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }


    //Método assignVehicleWithPlate
    public void assignVehicleWithPlate(String plate) {
        this.vehiclePlate = plate;
        System.out.println("Vehículo con matrícula " + plate + " asignado a " + name);
    }

    //Método unassignVehicle
    public void unassignVehicle() {
        if (this.vehiclePlate != null) {
            System.out.println("Vehículo con matrícula " + vehiclePlate + " desasignado de " + name);
            this.vehiclePlate = null;
        } else {
            System.out.println(name + " no tiene un vehículo asignado.");
        }
    }

    //toString
    @Override
    public String toString() {
        return "Empleado [DNI: " + dni + ", Nombre: " + name + ", Año Contratado: " + yearHired +
                ", Matrícula del Vehículo: " + (vehiclePlate != null ? vehiclePlate : "Ninguno") + "]";
    }

}
