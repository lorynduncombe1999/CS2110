/*
Loryn Duncombe (ld3dx) Homework 5

My friend gave me these resources ot work from to help build my gui! 
He also assisted my in debugging some  of my methods
Sorry I know it is a lot of sources I just didn't want to forget anything !
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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

// The GPACalculator constructor initializes the window
public class GPACalculator {

    /**
     * Global variables
     * courses is an ArrayList that stores Course objects. This will be the primary data structure for the GPACalculator.
     * frame is the JFrame of the program, and holds all other elements
     * panel is the main container of the program. All other elements fall under the panel element.
     * My friend helped me organize how I wanted it to actually look. I drew it on a piece 
     * of paper which helps a lot. This allowed me to see everything that I wanted to be 
     * included in my GPACalculator
     */
    private ArrayList<Course> courses;

    private JFrame frame;
    private JPanel panel;

    // titlelabel is the title of the GPA Calculator, and appears at the top of the screen.
     
    private JLabel titlelabel;

    /**
     * course panel-holds all elements pertaining to the actual course elements
     * 1. header elements
     * 2. all elements for each course that exists at the time. 
     * 3. scrolling feature through scrollPane this allows for scrolling through a large number of courses.
     */
    private JPanel coursepanel;
    private JScrollPane scrollPane;
    private JLabel j1;
    private JLabel j2;
    private JLabel j3;
    private JLabel j4;

    /**
     * optionspanel-holds all option elements of the program. 
     *  includes:
     *  1.add button
     *  2.add combo box
     *  3.remove
     *  4. remove all
     *  5. edit
     *  6. ok buttons.
     */
    private JPanel optionspanel;
    private JButton edit;
    private JComboBox<Integer> numcourse;
    private JButton add;
    private JButton ok;
    private JButton remove;
    private JButton removeall;

     /**
      * gpapanel-contains all gpa elements of the program
      * includes:(all labels)
      * 1.currentgpa
      * 2.requiredgpa
      * 3.targetgpa labels
      * 4.edit 
      * 5.ok buttons
     */
    private JPanel gpapanel;

    private JLabel gpalabel;
    private JLabel targetgpa;
    private JLabel requiredgpa;
    private JButton edittarget;
    private JButton oktarget;
    private JTextField targetgpafield;


    /**
     * The main constructor- initializes all Java swing components, adding listeners, places
     * them on the panels.
     */
    public GPACalculator() {
    	//sets font
        Font header = new Font("Serif", Font.BOLD, 25);

        //initialized as an empty arraylist(Because you want to add courses to it)
        courses = new ArrayList<Course>();

      // main JFrame
        frame = new JFrame("GPA Calculator");
        frame.setBounds(0, 0, 1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
         //panel 
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        /*
         * titlelabel- initialized,placed at the top center of the panel
         * titlelabel's font is set to "header"
         */
        titlelabel = new JLabel("GPA CALCULATOR", SwingConstants.CENTER);
        titlelabel.setFont(header);

        panel.add(titlelabel, BorderLayout.PAGE_START);


        /**
         * coursepanel  layout is set to GridLayout it can have only 4
         * columns, but an unlimited amount of rows (0,4)
         */
        coursepanel = new JPanel();
        coursepanel.setLayout(new GridLayout(0, 4));


       
       //These labels are header labels, that tell the user which column is which. 
        j1 = new JLabel("Select", SwingConstants.CENTER);
        j1.setFont(header);
        coursepanel.add(j1);

        j2 = new JLabel("Credits", SwingConstants.CENTER);
        j2.setFont(header);
        coursepanel.add(j2);


        j3 = new JLabel("Course Name", SwingConstants.CENTER);
        j3.setFont(header);
        coursepanel.add(j3);


        j4 = new JLabel("GPA", SwingConstants.CENTER);
        j4.setFont(header);
        coursepanel.add(j4);

         // coursepanel is placed inside a scrollpane wrapper. This allows user to scroll on the page
        
        scrollPane = new JScrollPane(coursepanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //optionspanel-grid layout

        optionspanel = new JPanel();
        optionspanel.setLayout(new GridLayout(3,4));

        add = new JButton("Add Courses");
        add.addActionListener(new AddButtonListener());

        edit = new JButton(("Edit"));
        edit.addActionListener(new EditButtonListener());


        ok = new JButton("OK");
        ok.addActionListener(new OKButtonListener());
        ok.setVisible(false);

        numcourse = new JComboBox();

       
         //the following for loop adds options 1-20 to the combobox
        for (int i = 1; i < 21; i++) {
            numcourse.addItem(i);
        }

        numcourse.setPreferredSize( new Dimension( 100, 40 ) );
        optionspanel.add(numcourse);

        add.setPreferredSize(new Dimension(200, 40));
        optionspanel.add(add);

        edit.setPreferredSize(new Dimension(200, 40));
        optionspanel.add(edit);

        ok.setPreferredSize(new Dimension(200, 40));
        optionspanel.add(ok);

        remove = new JButton("Remove");
        remove.addActionListener(new RemoveButtonListener());
        optionspanel.add(remove);

        removeall = new JButton("Clear All");
        removeall.addActionListener(new RemoveAllButtonListener());
        optionspanel.add(removeall);


        optionspanel.setAlignmentY(JPanel.TOP_ALIGNMENT);

    

        // gpapanel- layout is set to box layout
        gpapanel = new JPanel();
        gpapanel.setLayout(new BoxLayout(gpapanel, BoxLayout.Y_AXIS));

        gpalabel = new JLabel("Current GPA: --");
        gpalabel.setFont(header);
        gpapanel.add(gpalabel, Component.CENTER_ALIGNMENT);


        requiredgpa = new JLabel("Required GPA: --");
        requiredgpa.setFont(header);

        oktarget = new JButton("OK");
        oktarget.addActionListener(new TargetOKButtonListener());
        oktarget.setVisible(false);

        edittarget = new JButton("Edit");
        edittarget.addActionListener(new TargetEditButtonListener());

        targetgpa = new JLabel("Target GPA");
        targetgpa.setFont(header);

        targetgpafield = new JTextField();
        targetgpafield.setPreferredSize(new Dimension(200,50));
        targetgpafield.setMaximumSize(new Dimension(300,20));
        targetgpafield.setEditable(false);


        gpapanel.add(requiredgpa, Component.CENTER_ALIGNMENT);
        gpapanel.add(targetgpa, Component.CENTER_ALIGNMENT);
        gpapanel.add(targetgpafield, Component.CENTER_ALIGNMENT);
        gpapanel.add(edittarget, Component.CENTER_ALIGNMENT);
        gpapanel.add(oktarget,Component.CENTER_ALIGNMENT);


        //This is adding all of the subpannels to the main pannels to complete it 
        panel.add(optionspanel, BorderLayout.SOUTH);
        panel.add(scrollPane);
        panel.add(gpapanel,BorderLayout.EAST);


        //adding pannel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * currentGPA- method that calculates the current GPA of the user
     * currentGPA -called every time a course is edited or removed. 
     * currentGPA iterates through the ArrayList of courses and checks to see if the course has a GPA value (the course
     * has been completed). If the course has a GPA of -1, this means the course is incomplete. If the course has been
     * completed, its GPA will be added to be used for current GPA calculations.
     *orginially I was going to use 0 as the default upon talking it out with my friend I realized
     *this would cause errors in my gpa calculation because 0 would be an 'f' not an incomplete course
     */
    public double currentGPA() {

 
        double totalgpa = 0.00;
        int totalcredit = 0;

        
         //Loop through the ArrayList and add completed courses to the totalcredit and totalgpa
         
        for (Course c : courses) {
            if (c.getGpafield().isEditable() == false) {
                if (c.getGpa() != -1) {
                    totalgpa += c.getGpa()*c.getCredithours();
                    totalcredit += c.getCredithours();
                }
            }
        }

        if (totalgpa == 0.00) {
            gpalabel.setText("Current GPA: --");
            return 0;
        }

        else {
            gpalabel.setText("Current GPA: " + (Double) totalgpa/totalcredit);
            return totalgpa/totalcredit;
        }

    }

    /**
     * updateCourse-relist all courses after a course has been edited or removed
     * it clears the coursepanel, then places the headers and all courses in the panel again.
     */
    public void updateCourse() {
        coursepanel.removeAll();
        Font header = new Font("Courier", Font.BOLD, 18);

        j1 = new JLabel("Select", SwingConstants.CENTER);
        j1.setFont(header);
        coursepanel.add(j1);

        j2 = new JLabel("Credits", SwingConstants.CENTER);
        j2.setFont(header);
        coursepanel.add(j2);


        j3 = new JLabel("Course Name", SwingConstants.CENTER);
        j3.setFont(header);
        coursepanel.add(j3);

        j4 = new JLabel("GPA", SwingConstants.CENTER);
        j4.setFont(header);
        coursepanel.add(j4);

        for (Course c : courses) {

            coursepanel.add(c.getCheckbox());
            coursepanel.add(c.getCreditfield());
            coursepanel.add(c.getNamefield());
            coursepanel.add(c.getGpafield());
        }

        coursepanel.revalidate();
    }

    /**
     * requiredGPA- updates the required GPA label.
     * it is called every time the list is modified in anyway
     * it first checks the user's target GPA.then looks at the user's current GPA
     * and the amount of incomplete courses they have listed, and then calculates the minimum required GPA necessary for
     * those incomplete courses in order to reach the target GPA.
     */
    
    public void requiredGPA() {
    	// Required GPA first checks to make sure that a target GPA exists, otherwise no required GPA is needed
           
        if (targetgpafield.getText().isEmpty()) {
            requiredgpa.setText("Required GPA: --");
            return;
        }

        /**
         * local variables
         * freecredits tracks the total amount of incomplete credits
         * totalcredits is the total number of credits
         * coundtedcredits is the number of credits that have been completed
         * Below, these variables are declared and initialized
         */
        
        
        int freecredits = 0;
        int totalcredits = 0;
        int countedcredits = 0;
        for (Course c : courses) {
           if (c.getGpafield().isEditable() == false) {
               if (c.getGpa() == -1) {
                   freecredits += c.getCredithours();
               }
           }
        }

        for (Course c : courses) {
            totalcredits += c.getCredithours();
        }

        countedcredits = totalcredits-freecredits;

        //done to Actually require GPA
        double totaltargetgpa = Double.parseDouble(targetgpafield.getText())*totalcredits;
        double currenttotalgpa = currentGPA()*countedcredits;
        double totalrequiredgpa = totaltargetgpa - currenttotalgpa;
        double therequiredgpa = totalrequiredgpa / freecredits;

        requiredgpa.setText("Required GPA: " + therequiredgpa);

        
         //If the required GPA is above 4 or below 2, the necessary dialog boxes are activated   
        if (therequiredgpa > 4.00) {
            JOptionPane.showMessageDialog(null, "Required GPA is above 4. You must increase your credits in order to meet target GPA.");

        }

        if (therequiredgpa < 2.0) {
            JOptionPane.showMessageDialog(null, "Required GPA is below 2. You may decrease your credits if you wish.");

        }

        
        //updates the panel
        panel.validate();
    }


    // main method
    public static void main(String[] args) {
        new GPACalculator();

    }


   
     //Adds functionality for the edit button implementing the ActionListener interface
 
    private class EditButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            /*
             * didedit boolean value that checks to see if a course was "actually" edited. By actually edited,
             * this means a course was actually selected. If someone pressed the edit button without actually selecting
             * a course, didedit would be false
             * I was told this was a good thing to add because you don't want to be updating unessecarly
             */
            boolean didedit = false;
            /**
             * loops through courses and checks to see if the checkbox was selected. Then changes the textfield elements
             * of that course to be editable. didedit is now true
             */
            for (int i = 0; i < courses.size(); i++) {

                if (courses.get(i).getCheckbox().isSelected()) {

                    courses.get(i).getCheckbox().setSelected(false);
                    courses.get(i).getCreditfield().setEditable(true);
                    courses.get(i).getNamefield().setEditable(true);
                    courses.get(i).getGpafield().setEditable(true);
                    didedit = true;

                }
            }

            coursepanel.revalidate();
            /**
             * If a course was selected to be edited, all other option buttons except the OK button will become disabled
             * until OK is pressed. This prevents people from trying to "break" the program by doing something mid edit.
             * The only thing a user can do while editing is edit.
             */

            if (didedit) {
                ok.setVisible(true);
                edit.setVisible(false);
                remove.setEnabled(false);
                removeall.setEnabled(false);
                numcourse.setEnabled(false);
                add.setEnabled(false);
                edittarget.setEnabled(false);
            }

            optionspanel.revalidate();
        }
    }

    /**
     * Adds functionality for the OK button implementing the ActionListener interface
     * The OK button works by checking the courses that are currently being edited, and confirming or denying these
     * changes. Input validation is also included to make sure that the program is not broken by the user putting
     * a string in the GPA field, for instance. Once input validation is successful, then the OK button makes the edited
     * fields uneditable, and enables all other option buttons.
     */
    private class OKButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            /**
             * Input validation starts
             * If input validation fails, the method will quit and a dialog box will prompt the user to fix the error
             */

            for (Course c : courses) {
                /**
                 * if statement to check that the credit textfield has been filled. The number of credits is mandatory,
                 * so if nothing is entered in the text field, validation will fail.
                 */
            	
            	//a lot of this section contains try and catch exceptions(what if scenario's)
                if (c.getCreditfield().getText().isEmpty()) {
                    System.out.println("Credit field at line " + (courses.indexOf(c)+1) + " is empty. Please enter a number of credits between 0 and 10.");
                    JOptionPane.showMessageDialog(null, "Credit field at line " + (courses.indexOf(c)+1) + " is empty. Please enter a number of credits between 0 and 10.");
                    return;
                }
                /**
                 * once an input is found in the credit textfield, the program will attempt to parse the String as an
                 * int. If this returns a numberformatexception, then validation will fail.
                 */
                else {

                    try {
                        Integer.parseInt(c.getCreditfield().getText());
                    }

                    catch (NumberFormatException n) { // catching the exception 
                        System.out.println("Credit field at line " + (courses.indexOf(c)+1) + " is not formatted correctly. Please enter an integer between 0 and 10");
                        JOptionPane.showMessageDialog(null, "Credit field at line " + (courses.indexOf(c)+1) + " is not formatted correctly. Please enter an integer between 0 and 10");
                        return;
                    }

                }

                
                 //If the number of credits is less than 0, validation will fail.
                 
                if (Integer.parseInt(c.getCreditfield().getText()) < 0) {
                    System.out.println("Credit field at line " + (courses.indexOf(c)+1) + " cannot contain a number less than 0.");
                    JOptionPane.showMessageDialog(null, "Credit field at line " + (courses.indexOf(c)+1) + " cannot contain a number less than 0.");

                    return;
                }

              
                 // If the number of credits is greater than 10, validation will fail.
                 
                else if (Integer.parseInt(c.getCreditfield().getText()) > 10) {
                    System.out.println("Credit field at line " + (courses.indexOf(c)+1) + " cannot contain a number greater than 10");
                    JOptionPane.showMessageDialog(null, "Credit field at line " + (courses.indexOf(c)+1) + " cannot contain a number greater than 10");

                    return;
                }

                
                 // If the GPA textfield is empty, no attempt to validate the input will be made
                if (c.getGpafield().getText().isEmpty()) {

                }

                
                // if the String in the GPA textfield cannot be parsed as a double, validation will fail.
                else {
                    try {
                        Double.parseDouble((c.getGpafield().getText()));
                    }

                    catch (NumberFormatException n) {
                        System.out.println("GPA Field at line " + (courses.indexOf(c)+1) + " is not formatted correctly. Please enter a number between 0.00 and 4.00");
                        JOptionPane.showMessageDialog(null, "GPA Field at line " + (courses.indexOf(c)+1) + " is not formatted correctly. Please enter a number between 0.00 and 4.00");

                        return;
                    }
                }

                
                 // Validation will fail if the GPA is less than 0.0 or greater than 4.0.
                 
                if (c.getGpafield().getText().isEmpty() == false) {
                    if (Double.parseDouble(c.getGpafield().getText()) < 0.00) {
                        if (Double.parseDouble(c.getGpafield().getText()) == -1.00) {

                        } else {
                            System.out.println("GPA Field at line " + (courses.indexOf(c)+1) + " contains a number less than 0.00");
                            JOptionPane.showMessageDialog(null, "GPA Field at line " + (courses.indexOf(c)+1) + " cannot contain a number less than 0.00");

                            return;
                        }
                    } else if (Double.parseDouble(c.getGpafield().getText()) > 4.00) {
                        System.out.println("GPA Field at line " + (courses.indexOf(c)+1) + " contains a number greater than 4.00");
                        JOptionPane.showMessageDialog(null, "GPA Field at line " + (courses.indexOf(c)+1) + " cannot contain a number greater than 4.00");

                        return;
                    }
                }


            }


            /**
             * Input validation is now complete. There is no input validation for the Course Name, because the Course
             * Name can be any type of String.
             *
             * The variables of each Course object are now mutated to their new values based on the textfields, and
             * the textfields are set to be uneditable.
             */

            for (Course c : courses) {

                if (c.getGpafield().isEditable()) {

                    c.getGpafield().setEditable(false);

                    
                     // If the GPA field is empty, GPA will be assigned to -1. This is done for "quality of life" when
                      //making GPA calculations.
                     
                    if (c.getGpafield().getText().isEmpty()) {
                        c.setGpa(-1.00);
                    }
                    else {
                        c.setGpa(Double.parseDouble(c.getGpafield().getText()));
                    }


                    c.getNamefield().setEditable(false);

                    if (c.getNamefield().getText().isEmpty()) {
                        c.setCoursename("");
                    }
                    else {
                        c.setCoursename(c.getNamefield().getText());
                    }

                    c.getCreditfield().setEditable(false);
                    c.setCredithours(Integer.parseInt(c.getCreditfield().getText()));
                }
            }

            coursepanel.revalidate();

            
             //The OK button is made invisible again, and all other buttons are enabled.
             
            ok.setVisible(false);
            edit.setVisible(true);
            remove.setEnabled(true);
            removeall.setEnabled(true);
            numcourse.setEnabled(true);
            add.setEnabled(true);
            edittarget.setEnabled(true);


            
             //Current GPA and required GPA are recalculated based on new data.
             
            currentGPA();
            requiredGPA();

            panel.revalidate();

        }
    }

    /**
     * Adds functionality for the Add button implementing the ActionListener interface
     * Add button works by adding blank, "incomplete" courses with a default of 3 credit hours. The number of courses
     * added at a time can be changed by using the combobox selector, 1-20 courses.
     */
    private class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            /**
             * For loop based on the combobox selector. A new Course is instantiated, added to the courses ArrayList,
             * and the new courses' elements added to the coursepanel.
             */
            for (int i = 0; i < (int) numcourse.getSelectedItem(); i++) {

                Course c = new Course();
                courses.add(c);
                coursepanel.add(c.getCheckbox());
                c.getCheckbox().setPreferredSize(new Dimension(200,40));
                coursepanel.add(c.getCreditfield());
                coursepanel.add(c.getNamefield());
                coursepanel.add(c.getGpafield());
            }

            System.out.println(numcourse.getSelectedItem());

            
             //coursepanel now shows new elements    
            coursepanel.revalidate();

            
             //Required GPA is now updated, based on the new, incomplete courses.
            requiredGPA();

        }
    }

    /**
     * Adds functionality for the Remove All button implementing the ActionListener interface
     * Remove all works by clearing the courses ArrayList, and then calling the updateCourse helper method to
     * "repopulate" the coursepanel with no elements.
     */
    private class RemoveAllButtonListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            courses.clear();
            updateCourse();
            // Current GPA and required GPA are called to update the values, and the panel is updated once again.
            currentGPA();
            requiredGPA();
            panel.revalidate();
        }
    }


    /**
     * Adds functionality for the Remove button implementing the ActionListener interface
     * The Remove button works by removing all courses selected with their respective checkbox.
     */
    private class RemoveButtonListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            
             // loops through the courses ArrayList and removes all Course objects that are currently selected
             
            for (int i = courses.size() - 1; i >  -1; i--) {

                    if (courses.get(i).getCheckbox().isSelected()) {

                        courses.remove(i);

                    }
            }
            coursepanel.revalidate();
            optionspanel.revalidate();

            
            // The updateCourse helper method is called to "repopulate" the coursepanel with only existing Course objects
             
            updateCourse();

            /**
             * currentGPA and requiredGPA are called to update the current GPA and the required GPA based on the
             * remaining courses
             */
            currentGPA();
            requiredGPA();
            panel.revalidate();


        }
    }

    /**
     * Adds functionality for the Edit button in the GPA panel implementing the ActionListener interface
     * The Edit button works by setting the targetGPA textfield to be editable. It also disables every other button
     * except the OK button, in order to prevent tampering with the program.
     */
    private class TargetEditButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            targetgpafield.setEditable(true);
            oktarget.setVisible(true);
            edittarget.setVisible(false);


            edit.setEnabled(false);
            remove.setEnabled(false);
            removeall.setEnabled(false);
            numcourse.setEnabled(false);
            add.setEnabled(false);

            panel.validate();
        }
    }

    /**
     * Adds functionality for the OK button in the GPA panel implementing the ActionListener interface
     * The OK button works by making the targetGPA textfield uneditable again, and reabling all other buttons.
     * The OK button also includes input validation, similar to the main OK button.
     */
    private class TargetOKButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            /*
             * First, the String is parsed into a Double. If there is a numberformatexception, then  user will be
             *  an error message and the method will quit.
             */

            if (targetgpafield.getText().isEmpty() == false) {
                try {

                    Double.parseDouble(targetgpafield.getText());
                }
                catch (NumberFormatException n) { //catching acception
                    System.out.println("Target GPA is formatted incorrectly. Target GPA must contain a value between 0.00 and 4.00");
                    JOptionPane.showMessageDialog(null, "Target GPA is formatted incorrectly. Target GPA must contain a value between 0.00 and 4.00");

                    return;
                }
            }

            /**
             * If the targetgpa textfield is empty, then the Required GPA textfield will be updated appropriately, and
             * all buttons will be enabled as normal.
             */
            if (targetgpafield.getText().isEmpty()) {
                targetgpafield.setEditable(false);
                requiredgpa.setText("Required GPA: --");
                oktarget.setVisible(false);
                edittarget.setVisible(true);

                edit.setEnabled(true);
                remove.setEnabled(true);
                removeall.setEnabled(true);
                numcourse.setEnabled(true);
                add.setEnabled(true);

                panel.validate();
                return;
            }


            
           /* This takes care of human input error  */
             
            if (Double.parseDouble(targetgpafield.getText()) < 0.00) {
                System.out.println("Target GPA cannot be less than 0.00");
                JOptionPane.showMessageDialog(null, "Target GPA cannot be less than 0.00");
                return;
            }

            else if (Double.parseDouble(targetgpafield.getText()) > 4.00) {
                System.out.println("Target GPA cannot be greater than 4.00");
                JOptionPane.showMessageDialog(null, "Target GPA cannot be greater than 4.00");
                return;
            }


            
             // All buttons to work again
             

            targetgpafield.setEditable(false);

            oktarget.setVisible(false);
            edittarget.setVisible(true);

            edit.setEnabled(true);
            remove.setEnabled(true);
            removeall.setEnabled(true);
            numcourse.setEnabled(true);
            add.setEnabled(true);

            gpapanel.validate();

            
             //Required GPA will now be called, to update the Required GPA based on the new Target GPA.
             
            requiredGPA();

        }
    }
    
}

