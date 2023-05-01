import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AddDeleteModel {
    // Add project - by MD Hasan Uddin Mahi
    public static void addDataToCSV(String output, String id, String name, String describe) {

        File file = new File(output);
        Scanner sc = new Scanner(System.in);
        try {
            if (file.exists()) {

                FileWriter fileWriter = new FileWriter(file, true);

                fileWriter.write(id + "," + name + "," + describe + ",Deactivated\n");

                fileWriter.close();
                JOptionPane.showMessageDialog(
                        null,
                        "Added Successfully",
                        "Status",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "File not Found... ",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        }

        catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    // Delete project - by MD Hasan Uddin Mahi
    public static void removeProject(String filepath, String removeId) {
        Scanner sc;
        String tempfile = "ProjectDetails.csv"; // creating a temp file for data
        String id = "";
        String name = "";// initiailizing the fields
        String describe = "";
        String status = "";

        try {

            // create FileWriter object with file as parameter
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw); // using the buffered for converting
            PrintWriter pw = new PrintWriter(bw); // usinig to write in file
            sc = new Scanner(new File(filepath));

            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {
                id = sc.next().trim();
                name = sc.next().trim();
                describe = sc.next().trim();
                if (!id.equals(removeId)) { // if the id doesnot matches with the id that needs to removed if moved
                                            // forward
                    pw.println(id + "," + name + "," + describe + "," + status); // writing in the file

                }

            }

            PrintWriter writer = new PrintWriter(filepath);
            writer.print("");

            writer.close();
            sc.close(); // closning the scannner

            pw.flush(); // flushing it

            pw.close(); // closing the writer
            JOptionPane.showMessageDialog(
                    null,
                    "Project deleted...",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    // view project - by MD Hasan Uddin Mahi
    public static void read(String csvFile) {
        try {
            String[] data = new String[100];
            int i = 0;
            File file = new File(csvFile); // storing filepath in a variable
            FileReader fr = new FileReader(file);// reading the file
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr; // declaring an array
            while ((line = br.readLine()) != null) { // while data is not finished
                tempArr = line.split(","); // split the data with comma
                for (String tempStr : tempArr) {
                    System.out.print(tempStr + " "); // printing from the file
                    data[i] = tempStr;
                    i++;

                }
                JOptionPane.showMessageDialog(
                        null,
                        data,
                        "Showing Projects",
                        JOptionPane.INFORMATION_MESSAGE);

            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void assign(int lec_id, int project_id) throws IOException{

        Boolean valid = true;

        ArrayList<LecturerDetails> lecturer_details = LecturerDetails.readLecturerDetails();

        for (LecturerDetails l: lecturer_details){
            if (project_id == l.getProjectID() && lec_id == l.getLecturerID()){
                valid = false;
            }
        }

        if (valid){
            lecturer_details.add (new LecturerDetails(lec_id, project_id) );
            LecturerDetails.saveLecturerDetails(lecturer_details);
        }
    }
}
