package AtGuigu.Project2;


/**
 * @create: 2022-06-23 12:56
 * @Description:
 */
/*
@author: Michael Chan
@create: 2022-06-23 12:56

@Description:
*/
public class Customer {

    private int id;
    private String Name;
    private String Gender;
    private int Age;
    private String Phone;

    static public int maxid = 0;

    public int getId() {
        return id;
    }
    public void setId() {
        this.id = ++maxid;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
}

