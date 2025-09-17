package project1Learning;

import java.io.*;

// Step 4: Custom Exception
class InvalidProductDataException extends Exception {
    public InvalidProductDataException(String message) {
        super(message);
    }
}

public class ProductCSVReader {

    public static void main(String[] args) {
        // Change this path to where your CSV is located
        String fileName = "C:\\Users\\masta\\OneDrive\\drive\\OneDrive\\Desktop\\programming\\internshipProject\\task4\\products.csv";
        BufferedReader reader = null;

        try {
            // Step 1 & 2: Open file (may throw FileNotFoundException)
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                try {
                    // Skip header row if present
                    if (isFirstLine && line.toLowerCase().contains("product")) {
                        isFirstLine = false;
                        continue;
                    }
                    isFirstLine = false;

                    // Split CSV into parts
                    String[] parts = line.split(",");

                    // Step 4: Check for missing fields
                    if (parts.length < 4) {
                        throw new InvalidProductDataException("Missing fields in row: " + line);
                    }

                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());  // Step 3
                    int quantity = Integer.parseInt(parts[3].trim());

                    System.out.println("Product: " + id + " | " + name + " | Price: " + price + " | Qty: " + quantity);

                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in row: " + line);
                } catch (InvalidProductDataException e) {
                    System.err.println("Invalid data: " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Step 5: Ensure file is closed
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File closed successfully.");
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
