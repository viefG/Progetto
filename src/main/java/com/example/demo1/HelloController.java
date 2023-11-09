package com.example.demo1;

import com.google.gson.JsonArray;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;

public class HelloController {
    @FXML
    private TextField targa_da_inserire;

    @FXML
    private Label showTarga;

    @FXML
    private Label risposta1;

    String testo;




    @FXML
    private void avantiOnClick(){
        String targa = "La targa che hai inseiro e' " +targa_da_inserire.getText();
        showTarga.setText(targa);
        testo=targa_da_inserire.getText();
        System.out.println(targa_da_inserire.getText());
        SitoCom sito = new SitoCom();
        System.out.println(testo);
        String risposta= sito.richiestaAlSito(testo);
        System.out.println(risposta);
        Gson gson=new Gson();
        JsonObject jsonObject = gson.fromJson(risposta,JsonObject.class);


        JsonArray informationsArray = jsonObject.getAsJsonArray("informations");

        for (JsonElement informationElement : informationsArray) {
            JsonObject informationObject = informationElement.getAsJsonObject();
            String numKmiPcsRvs = informationObject.get("numKmiPcsRvs").getAsString();
            System.out.println("numKmiPcsRvs: " + numKmiPcsRvs);
            risposta1.setText(numKmiPcsRvs);
        }




    }






}

