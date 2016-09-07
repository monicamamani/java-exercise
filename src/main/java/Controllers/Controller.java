package Controllers;

import Model.StudentModel;
import Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    // Class attribute.
    private StudentModel _Student_model;

    // Contructor.
    public Controller(){
        this._Student_model = new StudentModel();
    }

    /**
     *
     * @param pStudent
     * @return
     */
    public boolean add(Student pStudent){

        return (this._Student_model.add(pStudent) != null);
    }

    public boolean remove(Student pStudent){

        return (this._Student_model.remove(pStudent) != null);
    }

    public List<Student> getSearch(String[] pRequestString){

        Map<String,String> criteriaList=new HashMap<>();

        for(int i=0;i<pRequestString.length;i++){

            String[] criteria=pRequestString[i].split("=");


            if(criteria.length==2)
                criteriaList.put(criteria[0],criteria[1]);
        }

        return this._Student_model.search(criteriaList);
    }
}
