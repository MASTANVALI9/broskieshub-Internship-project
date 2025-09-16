package project1Learning;
import java.io.*;

public class ProductFilter {
    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "expensive_products.csv";

        // 1. Create sample products.csv file
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("Laptop,75000\n");
            writer.write("Mouse,500\n");
            writer.write("Keyboard,1500\n");
            writer.write("Monitor,12000\n");
            writer.write("Pen,50\n");
            System.out.println("Sample products.csv file created successfully.");
        } catch (IOException e) {
            System.out.println("Error while creating products.csv: " + e.getMessage());
        }

        // 2. Read file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter fw = new FileWriter(outputFile)) {

            String line;
            while ((line = br.readLine()) != null) {
                // 3. Split each line by comma
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);

                // 4. Check if price > 1000
                if (price > 1000) {
                    // 5. Write to new file
                    fw.write(name + "," + price + "\n");
                }
            }

            // 6. Success message
            System.out.println("Filtered products saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
