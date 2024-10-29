package hr.management.tools;

import hr.management.model.Vehicle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLManager {
    //Método readVehicleFromXML
    public static Vehicle readVehicleFromXml(String filePath) {
        try {
            // Configurar el parser de documentos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            // Obtener el elemento raíz
            Element root = document.getDocumentElement();

            // Leer los datos de cada elemento del vehículo en el XML
            String plate = root.getElementsByTagName("plate").item(0).getTextContent();
            String brand = root.getElementsByTagName("brand").item(0).getTextContent();
            String model = root.getElementsByTagName("model").item(0).getTextContent();
            int yearBought = Integer.parseInt(root.getElementsByTagName("yearBought").item(0).getTextContent());

            // Crear y devolver el nuevo objeto Vehicle
            return new Vehicle(plate, brand, model, yearBought);

        } catch (Exception e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
