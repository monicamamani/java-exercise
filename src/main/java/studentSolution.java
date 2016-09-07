import Controllers.Controller;
import Model.Student;
import Util.LoadData;

import java.util.Arrays;
import java.util.List;

public class studentSolution {


    public static void main(String... args){

        // Class to handle request.
        Controller controller=new Controller();

        // Only if at least the file of data has been provided.
        if(args.length>0) {

            // Load data from file.
            LoadData util = new LoadData();
            util.Load(args[0]);


            // Build the criteria array.
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);

            // Gets the list filtered by criteria.
            List<Student> list = controller.getSearch(parameters);


            // Shows the found items.
            if (list.size() > 0) {
                for (Student item : list) {
                    System.out.println(item.getStudentType() + " " +
                            item.getName() + " " +
                            item.getGender() + " " +
                            item.getLastUpdate()
                    );
                }
            } else
                System.out.println("No data found for this criteria");
        }

    }
}
