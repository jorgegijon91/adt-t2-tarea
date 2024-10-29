package hr.management.model;

public class Vehicle {
    //Atributos
    private String plate;
    private String brand;
    private String model;
    private int yearBought;

    public Vehicle(String plate, String brand, String model, int yearBought) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.yearBought = yearBought;
    }

    // Getters, setters y método toString

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearBought() {
        return yearBought;
    }

    public void setYearBought(int yearBought) {
        this.yearBought = yearBought;
    }

    @Override
    public String toString() {
        return "Vehículo [Marca: " + brand + ", Modelo: " + model + ", Matrícula: " + plate + ", Año de Compra: " + yearBought + "]";
    }
}
