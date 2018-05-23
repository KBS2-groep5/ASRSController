package ASRSController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONReadFromFile {
    private String firstName;
    private String lastName;
    private String ordernr;
    private String adress;
    private String postcode;
    private String place;
    private String date;
    private JSONArray ProductList;

    JSONReadFromFile(String filePath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;

            this.firstName = (String) jsonObject.get("Voornaam");
            this.lastName = (String) jsonObject.get("Achternaam");
            this.ordernr = (String) jsonObject.get("OrderNummer");
            this.adress = (String) jsonObject.get("Adres");
            this.postcode = (String) jsonObject.get("Postcode");
            this.place = (String) jsonObject.get("Plaats");
            this.date = (String) jsonObject.get("Datum");

            this.ProductList = (JSONArray) jsonObject.get("Artikelen");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getOrdernr() {
        return ordernr;
    }

    String getAdress() {
        return adress;
    }

    String getPostcode() {
        return postcode;
    }

    String getPlace() {
        return place;
    }

    String getDate() {
        return date;
    }

    JSONArray getProductList() {
        return ProductList;
    }

}
