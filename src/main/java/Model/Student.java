package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// POJO class for Student Entity.
public class Student {

    // Attributes of Student.
    private long _id;
    private String _studentType;
    private String _name;
    private String _gender;
    private Date _lastUpdate;

    /**
     *  Constructor.
     */
    public Student(long pId,String pStudentType,String pName,String pGender,Date pLastUpdate){
        this._id=pId;
        this._studentType=pStudentType;
        this._name=pName;
        this._gender=pGender;
        this._lastUpdate=pLastUpdate;
    }

    /**
     * Alternative Constructor.
     */
    public Student(long pId,String pStudentType,String pName,String pGender,String pLastUpdate) throws ParseException {
        this._id=pId;
        this._studentType=pStudentType;
        this._name=pName;
        this._gender=pGender;

        // TODO: Convert in a common util function.
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        this._lastUpdate=format.parse(pLastUpdate);
    }



    // Get Set methods.
    public long getId(){return _id;}
    public void setId(long pId){this._id=pId;}

    public String getStudentType(){return _studentType;}
    public void setStudentType(String pStudentType){this._studentType=pStudentType;}

    public String getName(){return _name;}
    public void setName(String pName){this._name=pName;}

    public String getGender(){return _gender;}
    public void setGender(String pGender){this._gender=pGender;}

    public Date getLastUpdate(){return _lastUpdate;}
    public void setLastUpdate(Date p){this._lastUpdate=p;}
}
