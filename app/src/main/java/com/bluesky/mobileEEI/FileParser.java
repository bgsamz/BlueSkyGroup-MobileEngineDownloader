package com.bluesky.mobileEEI;

import android.content.Context;
import android.widget.TextView;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by bgsamz on 2/15/18.
 */

public class FileParser {

    public String run(Context context) {
        try {
            File file = new File(context.getFilesDir(), "test.yaml");
            if(!file.exists())
            {
                file.createNewFile();
            }
            InputStream input = new FileInputStream(file);
            Yaml yaml = new Yaml();
            DownloadFile testMaint = yaml.loadAs(input, DownloadFile.class);

            File test_file = new File(context.getFilesDir(), "yamlTest.txt");
            if(!test_file.exists())
            {
                test_file.createNewFile();
            }
            OutputStream output = new FileOutputStream(test_file, true);

            output.write((testMaint.toString() + "\n").getBytes());

            output.close();
            input.close();

            return testMaint.toString();

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return "Error: " + e;
        }

//        return "ERROR";
    }
}
