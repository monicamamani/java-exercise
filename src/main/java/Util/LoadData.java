package Util;



import Model.Student;
import Model.StudentModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class LoadData {

    /**
     * Loads data from file.
     * @param pFileName
     */
    public void Load(String pFileName){

        StudentModel model=new StudentModel();

        try(BufferedReader br = new BufferedReader(new FileReader(pFileName))) {

            long count=0;
            for(String line; (line = br.readLine()) != null; ) {

                String[] arrayLine=line.split(";");

                if(arrayLine.length==4){
                    count++;
                    model.add(new Student(count, arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3]));

                }
            }

            //System.out.println(count+ " lines procesed.");

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
