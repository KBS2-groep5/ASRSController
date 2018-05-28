package ASRSController;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptWriter {

    private static void writeReceipt(String box, String orderNr, String firstName, String lastName, String adress, String postalCode, String place, String date, List<Package> packages) {
        try {
            List<String> lines = new ArrayList<>();
            lines.add("Ordernr: "  + orderNr);
            lines.add("First name: " + firstName);
            lines.add("Last name: " + lastName);
            lines.add("Adress: " + adress);
            lines.add("Postal code: " + postalCode);
            lines.add("Place: " + place);
            lines.add("Date: " + date);
            lines.add(" ");
            lines.add("Products: ");
            for (Package p: packages) {
                lines.add(" - Name: " + p.getName());
                lines.add("   Productnr: " + p.getProductNr());
            }
            String filePath = "././receipts/";
            String fileName = filePath + "receiptBox" + box + ".txt";
            Path file = Paths.get(fileName);
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeReceipts(List<Container> containers, String path){
        try {
            JSONReadFromFile JSON = new JSONReadFromFile(path);
            for (int i = 0; i < containers.size(); i++) {
                Container container = containers.get(i);
                List tempList = new ArrayList<>();
                tempList.addAll(container.getPackages());
                ReceiptWriter.writeReceipt(Integer.toString(i + 1), JSON.getOrdernr(), JSON.getFirstName(), JSON.getLastName(), JSON.getAdress(), JSON.getPostcode(), JSON.getPlace(), JSON.getDate(), tempList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
