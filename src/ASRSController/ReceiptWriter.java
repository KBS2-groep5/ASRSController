package ASRSController;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReceiptWriter {

    public static void writeReceipt(String box, String orderNr, String firstName, String lastName, String adress, String postalCode, String place, String date, List<Package> packages) {
        try {
            List<String> lines = Arrays.asList();
            lines.add("Ordernr: " + orderNr);
            lines.add("First name: " + firstName);
            lines.add("Adress: " + adress);
            lines.add("Postal code: " + postalCode);
            lines.add("Place: " + place);
            lines.add("Date: " + date);
            lines.add("");
            lines.add("Products: ");
            for (Package p: packages){
                lines.add(" - Name: " + p.getName());
                lines.add("   Productnr: " + p.getProductNr());
            }

            String fileName = "receiptBox" + box + ".txt";
            Path file = Paths.get(fileName);
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
