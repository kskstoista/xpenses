package gyakorlas.penz;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Kzfot on 2018. 02. 03..
 */

public class FileMuvelet {

    public static void Kiir(Tranzakcio tr, Context ctx){
        try {
            FileOutputStream fos = ctx.openFileOutput("file1", Context.MODE_APPEND);
            fos.write(tr.toString().getBytes());
            fos.close();
        }catch (Exception e ){
            //todo hibakezeles
            e.printStackTrace();
            Log.e("kiir fugg:  " , e.toString());
        }
    }

    public static ArrayList<Tranzakcio> Kiolvas(Context ctx) {

        String Read;
        ArrayList<Tranzakcio> tranzakcioLista = new ArrayList<Tranzakcio>();

        try {
            FileInputStream fis = ctx.openFileInput("file1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            if (fis!=null) {
                while ((Read = reader.readLine()) != null) {
                    Log.e("While cikélus legelej: ", Read);
                    Tranzakcio tr = new Tranzakcio(Read);
                    tranzakcioLista.add(tr);
                    Log.e("olvastunk valamittttt", tr.toString());
                }
            }
            fis.close();
        }catch (Exception e ){
        //todo hibakezeles
        Log.e("kilvasás" , e.toString());
        }
        return tranzakcioLista;
    }
}
