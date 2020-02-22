package tech.henning.fourthreefive.OldEngine;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelLoader {

    public static List<Integer> models = null;

    public ModelLoader() {
        loadArray();
    }

    public static byte[] loadNewModel(int i) throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("data/models/" + i + ".dat"));
        byte[] buffer = new byte[(int) new File("data/models/" + i + ".dat").length()];
        dis.readFully(buffer);
        dis.close();
        System.out.println("Loading model: " + i + ", lenght: "+ buffer.length);
        return buffer;
    }

    public void loadArray() {
        models = new ArrayList<Integer>();
        File[] m = new File("data/models").listFiles();
        for(File model : m)
            if(model.getName().contains(".dat"))
                models.add(Integer.parseInt(model.getName().substring(0, model.getName().indexOf(".dat"))));
    }
}