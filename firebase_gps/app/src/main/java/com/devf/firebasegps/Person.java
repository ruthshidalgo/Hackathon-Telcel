package com.devf.firebasegps;

/**
 * Created by braulioalejandroramirez on 30/07/16.
 */

//Creamos el modelo de Persona

public class Person {

    //Declaramos las variables tipo String de nombre y dirección
    private String name;
    private String tarifa;
    private String address;
    private String latitude;
    private String longitude;
    private String timeStamp;


    // Declaramos el constructor vacio

    public Person(){

    }

    // Creamos setters y getters de nombre

    public String getname(){
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    // Creamos setters y getters de dirección

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;


    }

    // Creamos setters y getters de Latitude

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    // Creamos setters y getters de Longitude

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;


    }


    // Creamos setters y getters de timeStamp

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;


    }


    public String getTarifa(){
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }



}
