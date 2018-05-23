/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRSController;

import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadFromFile {
        private String firstName;
        private String lastName;
        private String ordernr;
        private String adress;
        private String postcode;
        private String place;
        private String date;
	private JSONArray ProductList;
        
    public JSONReadFromFile(String filePath){
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getOrdernr() {
		return ordernr;
	}

	public String getAdress() {
		return adress;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getPlace() {
		return place;
	}

	public String getDate() {
		return date;
	}

        public JSONArray getProductList() {
            return ProductList;
        }
	
}
