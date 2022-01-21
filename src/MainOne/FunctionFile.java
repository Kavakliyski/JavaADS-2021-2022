package MainOne;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {
    App app;

    String fileName;
    String fileDirectory;

    public FunctionFile(App app) {
        this.app = app;
    }

    public void newFile() {
        app.textArea.setText("");
        app.window.setTitle("Untitled");
        fileName = null;
        fileDirectory = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(app.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileDirectory = fd.getDirectory();
            app.window.setTitle(fileName);
        }
        System.out.println("File address and file name: " + fileDirectory + fileName);

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileDirectory + fileName)); // you need to address to read the file
            app.textArea.setText("");

            String line = null;

            while ((line = br.readLine()) != null) {
                app.textArea.append(line + "\n");
            }
            br.close();

        } catch (Exception e){
            System.out.println("File not opened!" + "Something went wrong on open()");
        }
    }

    public void save(){
        if (fileName == null){
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileDirectory + fileName);
                fw.write(app.textArea.getText());
                app.window.setTitle(fileName);
                fw.close();
            } catch (Exception e){
                System.out.println("Something went wrong on save()");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(app.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileDirectory = fd.getDirectory();
            app.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileDirectory + fileName);
            fw.write(app.textArea.getText());
            fw.close();

        } catch (Exception e){

            System.out.println("Something went wrong on saveAs()");
        }
    }

    public void exit() {
        String message = "Да се запазят ли последните промени";
        int reply = JOptionPane.showConfirmDialog(null, message, "Save and Exit", JOptionPane.YES_NO_OPTION);
        switch (reply) {
            case JOptionPane.CLOSED_OPTION -> System.out.println("CLOSED_OPTION");
            case JOptionPane.YES_OPTION -> exitAndSave();
            case JOptionPane.NO_OPTION -> System.exit(0);
        }

/*
        if (reply == JOptionPane.YES_OPTION) {
            save();
            System.exit(0);
        } else if (reply == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
*/
    }

    private void exitAndSave() {
        save();
        System.exit(0);
    }

    public void close(){

    }
}