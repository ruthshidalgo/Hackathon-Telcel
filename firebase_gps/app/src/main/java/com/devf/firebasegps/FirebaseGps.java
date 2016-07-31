package com.devf.firebasegps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class FirebaseGps extends AppCompatActivity {

    //Declaramos las variables a utilizar en la app
    //private Button btnShowLocation;
    private GPSTracker gps;
    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextTarifa;
    private TextView textViewPersons;
    private Button buttonSave;
    private EditText latitude;
    private EditText longitude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_gps);

        //Creamos el context global de Firebase
        Firebase.setAndroidContext(this);

        //Asignamos las vistas a cada función
        //btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextTarifa= (EditText) findViewById(R.id.editTextTarifa);
        //textViewPersons = (TextView) findViewById(R.id.textViewPersons);




        // Declaramos función al momento de recibir un click
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                final Firebase ref = new Firebase(Config.FIREBASE_URL);


                //Getting values to store
                final String name = editTextName.getText().toString().trim();
                final String address = editTextAddress.getText().toString().trim();
                final String tarifa = editTextTarifa.getText().toString().trim();



                //Creating Person object
                final Person person = new Person();

                //TimeStamp
                String timeStamp = new Clock().getNow();

                person.setTimeStamp(timeStamp);



                // Obtenemos posición GPS

                //btnShowLocation.setOnClickListener(new View.OnClickListener() {


                        gps = new GPSTracker(FirebaseGps.this);

                        // check if GPS enabled
                        if (gps.canGetLocation()) {

                            //Obtenemos coordenadas en double tyoe
                            double latitude = gps.getLatitude();
                            double longitude = gps.getLongitude();

                            //Convertimos coordenadas de tipo double a tipo String
                            String latitudeString = Double.toString(latitude);
                            String longitudeString = Double.toString(longitude);

                            //Asignamos el valor al modelo persona de la longitud y latitud del GPS
                            person.setLatitude(latitudeString);
                            person.setLongitude(longitudeString);


                            double Distance;
                            Distance = distFrom((float) 36.5925907, 2.9051544f, 36.5805505f, 2.914749f);


                        } else {
                            // can't get location
                            // GPS or Network is not enabled
                            // Ask user to enable GPS/network in settings
                            gps.showSettingsAlert();
                        }

                        //Adding values
                        person.setname(name);
                        person.setAddress(address);
                        person.setTarifa(tarifa);


                        //person.setLatitude(String.valueOf(latitude));
                        //person.setLongitude(String.valueOf(longitude));

                        //Storing values to firebase

                        ref.child("Person").push().setValue(person);

                        //Resetea variables
                        person.setTarifa("");
                        person.setname("");
                        person.setAddress("");
                        person.setLongitude("");
                        person.setLatitude("");
                        person.setTimeStamp("");

                        editTextName.setText("");
                        editTextAddress.setText("");


                /*    }
                });


                observable.subscribe(new Action1<Boolean>(){
                    @Override
                    public void call(Boolean Boolean){

                    }
                }, new Action1<Throwable>(){
                    @Override
                    public void call(Throwable throwable){

                    }
                });



                    //}
                //});


                */








                //Value event listener for realtime data update
                //ref.addValueEventListener(new ValueEventListener() {

                //  @Override
                // DataSnapshot contiene toda la información de Firebase
                //public void onDataChange(DataSnapshot snapshot) {
                //get.Children obtiene los datos de la rama del objeto
                //  for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                //Getting the data from snapshot
                //    Person person = postSnapshot.getValue(Person.class);

                //Adding it to a string
                //  String string = "Name: "+person.getName()+"\nAddress: "+person.getAddress()+"\n\n";

                //Displaying it on textview
                //textViewPersons.setText(string);
                //}
                //}

                //@Override
                //public void onCancelled(FirebaseError firebaseError) {
                //  System.out.println("The read failed: " + firebaseError.getMessage());
                //}
                //});

            }//}
        });
    }

    //Obtenemos posición entre GPS y Network

    public float distFrom(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }

}