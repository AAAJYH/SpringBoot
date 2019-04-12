package customannotation;

/**
 * User实体
 */
public class User {

    @ValidateAnnotation(min = 2,max = 5)
    private String name;
    @ValidateAnnotation(isNotNull = false)
    private String age;

    public String getName(){
        return name;
    }

    @InitAnnotation(value = "liang")
    public void setName(String name){
        this.name=name;
    }

    public String getAge(){
        return age;
    }

    @InitAnnotation(value = "23")
    public void setAge(String age){
        this.age=age;
    }

}
