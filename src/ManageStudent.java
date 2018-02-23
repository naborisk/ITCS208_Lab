// Tussoun Jitpanyoyos 6088030 Section 1

public class ManageStudent {

    public static void main(String[] args){

        StudentProfile myInfo = new StudentProfile();
        StudentProfile friendInfo = new StudentProfile();

        myInfo.setStudentID(6088030);
        myInfo.setName("Tussoun Jitpanyoyos");
        myInfo.setAge(18);
        myInfo.setAddress("1 infinite loop Cupertino, CA");

        friendInfo.setStudentID(688044);
        friendInfo.setName("Prawit Wongsuwan");
        friendInfo.setAge(72);
        friendInfo.setAddress("Military Base");

        myInfo.getAllInfo();

        System.out.println();

        friendInfo.getAllInfo();

        System.out.println("\nStudent Count: "+ StudentProfile.getCount());
        System.out.println("Age difference: "+ StudentProfile.ageDiff(myInfo, friendInfo));

    }
}
