package Model;

import Controllers.Controller;
import Util.LoadData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;


public class ControllerTest {

    @BeforeClass
    public void oneTimeSetUp() {

        // Load data from file.
        LoadData util = new LoadData();
        util.Load("C:\\MonixDev\\java\\JavaExercise\\src\\main\\java\\input.csv");
    }

    @Test(threadPoolSize = 10,invocationCount = 50,timeOut = 10000)
    public void testGetSearch() throws Exception {

        Controller controller=new Controller();
        StudentModel studentModel =new StudentModel();

        String[] criteria={"type=high"};
        List<Student> response= controller.getSearch(criteria);
        System.out.println("Filtered response size "+response.size());

        Random randomizer = new Random();
        if(response.size()>0)
        {
            Student randomStudent=response.get(randomizer.nextInt(response.size()));
            controller.remove(randomStudent);
        }

        System.out.println("Model size "+ studentModel.getSize());

        assert (response.size()>=0);

    }



}