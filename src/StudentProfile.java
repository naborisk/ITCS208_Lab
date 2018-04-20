// Tussoun Jitpanyoyos 6088030 Section 1

public class StudentProfile {

    private int studentID;
    private String name;
    private int age;
    private String address;
    private static int count = 0;

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    public void getAllInfo(){

        System.out.println(studentID+" : "+name+", "+age+"\n"+address);

    }

    public static int ageDiff(StudentProfile firstProfile, StudentProfile secondProfile){
        return Math.abs(firstProfile.age - secondProfile.age);
    }

    public StudentProfile(){
        count++;
    }
}