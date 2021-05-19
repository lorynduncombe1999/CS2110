/*Loryn Duncombe (ld3dx) Homework 5
 * My friend Murphy helped me conceptually with some of the material and gave me
 * additional sources I could use to help understand gui's better !
 * on this list he gave me but this combined with some that I found helped a lot with this 
 * assignment 
 * Additionally I was given an extension on this assignment because I was in the hospital
 * Sources:
 * https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
 * https://docs.oracle.com/javase/tutorial/uiswing/components/index.html
 * https://www.javatpoint.com/java-swing
 * https://www.tutorialspoint.com/swing/index.htm
 * https://www.guru99.com/java-swing-gui.html
 * https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
 * https://javatutorial.net/java-swing-jframe-layouts
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
 * https://stackoverflow.com/questions/1862169/java-gridlayout
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 */
import javax.swing.*;

public class Course {
	//Course needed to be a separate class because it has a separate characteristics needing to be defined as a separate class
    //  GPACalculator only will manipulate, not create Courses
	
     /*Global variables
     * All Course objects include their own Java Swing elements, so that elements can be associated with a specific
     * Course object.
     * 3 text fields for credits, gpa, and coursename, and a checkbox to "select" the course for editing or removal.
     */
	
    private int credithours;// number of credit hours a course is worth
    private double gpa; // grade received in course
    private String classtitle; //name of class being taken

    private JTextField creditfield;
    private JTextField gpafield;
    private JTextField namefield;
    JCheckBox checkbox;
   
     //Constructor classes
    public Course(int credithours) {
        this.credithours = credithours;
        this.classtitle = ""; //Initialize to "" if no class title is provided
        this.gpa = -1; //Initialized to -1 if no GPA is provided

        //creating new textfields 
        creditfield = new JTextField(((Integer) credithours).toString());
        gpafield = new JTextField();
        namefield = new JTextField();
        checkbox = new JCheckBox();

        //by setting to false you cannot type into the text field
        creditfield.setEditable(false);
        gpafield.setEditable(false);
        namefield.setEditable(false);

    }

    public Course(int credithours, double gpa) {
        this.credithours = credithours;
        this.classtitle = "";
        this.gpa = gpa;

        //to string methods allows this to be seen by readers
        creditfield = new JTextField(((Integer) credithours).toString());
        gpafield = new JTextField(((Double) gpa).toString()); //GPA can be 3.2 etc this is why it needs to be a double
        namefield = new JTextField();
        checkbox = new JCheckBox();

        creditfield.setEditable(false);
        gpafield.setEditable(false);
        namefield.setEditable(false);
    }

    public Course(int credithours, String coursename) {
        this.credithours = credithours;
        this.classtitle = "";
        this.gpa = -1;

        creditfield = new JTextField(((Integer) credithours).toString());
        gpafield = new JTextField();
        namefield = new JTextField();
        checkbox = new JCheckBox();

        creditfield.setEditable(false);
        gpafield.setEditable(false);
        namefield.setEditable(false);

    }

    public Course(int credithours, double gpa, String coursename) {
        this.credithours = credithours;
        this.classtitle = coursename;
        this.gpa = gpa;

        creditfield = new JTextField(((Integer) credithours).toString());
        gpafield = new JTextField(((Double) gpa).toString());
        namefield = new JTextField();
        checkbox = new JCheckBox();

        creditfield.setEditable(false);
        gpafield.setEditable(false);
        namefield.setEditable(false);
    }

    public Course() {
        this.credithours = 3;
        this.classtitle = "";
        this.gpa = -1;

        creditfield = new JTextField(((Integer) credithours).toString());
        gpafield = new JTextField();
        namefield = new JTextField();
        checkbox = new JCheckBox();

        creditfield.setEditable(false);
        gpafield.setEditable(false);
        namefield.setEditable(false);
    }



  //Getter and Setter Methods needed for this class. These were auto-generated 

    public int getCredithours() {
        return credithours;
    }

    public void setCredithours(int credithours) {
        this.credithours = credithours;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getCoursename() {
        return classtitle;
    }

    public void setCoursename(String coursename) {
        this.classtitle = coursename;
    }

    public JTextField getCreditfield() {
        return creditfield;
    }

    public void setCreditfield(JTextField creditfield) {
        this.creditfield = creditfield;
    }

    public JTextField getGpafield() {
        return gpafield;
    }

    public void setGpafield(JTextField gpafield) {
        this.gpafield = gpafield;
    }

    public JTextField getNamefield() {
        return namefield;
    }

    public void setNamefield(JTextField namefield) {
        this.namefield = namefield;
    }

    public JCheckBox getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(JCheckBox checkbox) {
        this.checkbox = checkbox;
    }

}