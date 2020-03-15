package VIVA_1_FRIDAY;

public class Student implements Comparable<Student>{

    private String name;
    private int year;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        System.out.println(toString());
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Student : %-10s", name) + "Year of Study : " + year + " register into the course";
    }
     static char[] firstLetterSort = {'A', 'Z', 'B', 'Y', 'C', 'X', 'D', 'W',
        'E', 'V', 'F', 'U', 'G', 'T', 'H', 'S',
        'I', 'R', 'J', 'Q', 'K', 'P', 'L', 'O', 'M', 'N'};

    public int getFirstLetterRank(char firstLetter) {
        for (int i = 0; i < firstLetterSort.length; i++) {
            if (firstLetter == firstLetterSort[i]) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public int compareTo(Student o) {
            int myFirstLetterRank = getFirstLetterRank(this.name.charAt(0));
            int thatFirstLetterRank = getFirstLetterRank(o.name.charAt(0));
//            System.out.println(this.name.charAt(0) + " " + o.name.charAt(0));
            char myFirstLetter = this.name.charAt(0);
            if (myFirstLetterRank > thatFirstLetterRank) {
                return 1;
            } else if (myFirstLetterRank < thatFirstLetterRank) {
                return -1;
            } else {
                char mySecLetter = this.name.charAt(1);
                char thatSecLetter = o.name.charAt(1);
//                System.out.println(mySecLetter + " " + thatSecLetter);
                if ((int) myFirstLetter >= 65 && (int) myFirstLetter <= 77) {
                    if((int)mySecLetter > (int)thatSecLetter){
//                        System.out.println("he");
                        return 1;
                    }else if((int)mySecLetter < (int)thatSecLetter){
//                        System.out.println("she");
                        return -1;
                    }else{
//                        System.out.println("it");
                        return 0;
                    }
                } else if ((int) myFirstLetter >= 78 && (int) myFirstLetter <= 90) {
                    if(mySecLetter < thatSecLetter){
                        return 1;
                    }else if(mySecLetter > thatSecLetter){
//                        System.out.println(mySecLetter + " " + thatSecLetter);
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        return 0;
    }
}
