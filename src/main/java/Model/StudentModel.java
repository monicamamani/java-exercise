package Model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StudentModel {

    // Collection for store data.
    private static ConcurrentHashMap<Long, Student> students;

    // Constructor.
    public StudentModel()
    {
        if(students==null)
            students = new ConcurrentHashMap<Long, Student>();
    }

    /**
     * Add an Student to collection.
     * @param pStudent
     * @return
     */
    public Student add(Student pStudent)
    {
        // Add or update element.
        return students.put(pStudent.getId(), pStudent);
    }

    /**
     * Remove Student from collection.
     * @param pStudent
     * @return
     */
    public Student remove(Student pStudent)
    {
        // Remove element.
        return students.remove(pStudent.getId());
    }

    /**
     * Filters the collection by a criteria.
     * @param pCriteriaList
     * @return
     */
    public List<Student> search(Map<String,String> pCriteriaList)
    {
        // Result List.
        List<Student> filteredList=new ArrayList<>();

            // Filter by criteria.
            if(pCriteriaList.containsKey("name")) {

                filteredList= students.entrySet().stream()
                        .filter(student -> pCriteriaList.get("name").equalsIgnoreCase(student.getValue().getName()))
                        .sorted((s1,s2)->s2.getValue().getName().compareTo(s1.getValue().getName()))
                        .map(e->e.getValue())
                        .collect(Collectors.toList());

            }
            else if(pCriteriaList.containsKey("type")&&!pCriteriaList.containsKey("gender")) {


                filteredList= students.entrySet().stream()
                        .filter(student -> pCriteriaList.get("type").equalsIgnoreCase(student.getValue().getStudentType()))
                        .sorted((s1,s2)->s2.getValue().getLastUpdate().compareTo(s1.getValue().getLastUpdate()))
                        .map(e->e.getValue())
                        .collect(Collectors.toList());
            }

            else if(pCriteriaList.containsKey("gender")&&pCriteriaList.containsKey("type")) {

                filteredList= students.entrySet().stream()
                        .filter(student -> pCriteriaList.get("gender").substring(0,1).equalsIgnoreCase(student.getValue().getGender()))
                        .filter(student -> pCriteriaList.get("type").equals(student.getValue().getStudentType()))
                        .sorted(Map.Entry.comparingByValue((s1,s2)->s2.getLastUpdate().compareTo(s1.getLastUpdate())))
                        .map(e->e.getValue())
                        .collect(Collectors.toList());

            }



        return filteredList;
    }

    /**
     * Gets the actual size of collectión.
     * @return
     */
    public long getSize(){
        return students.size();
    }
}

