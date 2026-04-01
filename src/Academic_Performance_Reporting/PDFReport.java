/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academic_Performance_Reporting;

// Import classes
import Classes.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDFReport {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ExportPDF_Confirmation_Page.class.getName());

    public String fileName;
    
    //Method 1: Checks whether a grade is considered a passing grade.
    private boolean passCheck(String grade) {
        //Check whether student passed the module or not
        //Grades from D and below are considered fail
        return !(grade.equalsIgnoreCase("D") ||
                 grade.equalsIgnoreCase("F+") ||
                 grade.equalsIgnoreCase("F") ||
                 grade.equalsIgnoreCase("F-"));
    }
    
    //Method 2: Generates a PDF academic transcript for a student for a selected year/semester.
    public void export(String studentID, String studentName, String yearSem) {
        
        //Try-catch method is used so if something failed, the whole PDF export process won't crash
        try {
            //Assigning year and semester value to the variable
            String[] ys = yearSem.replace("(", "").replace(")", "").split(":");
            String selectedYear = ys[0].trim();
            String selectedSem = ys[1].trim();
            
            //Check if selected semester is "all"
            boolean annualCheck = selectedSem.equals("All");
            
            //Getting values and initializing variables
            StudentService ss = new StudentService();
            Student student = ss.getStudentByID(studentID);

            StudentGradeService sgs = new StudentGradeService();
            StudentGrade[] grades = sgs.loadData();

            CourseService cs = new CourseService();
            Course[] courses = cs.loadData();
            
            //Creating PDF document and setting page size and margin
            Document doc = new Document(PageSize.A4);
            //Create a PdfWriter that links this Document to an output PDF file
            //Setting format for file name
            fileName = "Report_" + studentID + "_" + selectedSem + "_" + selectedYear +".pdf";
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();     //Open the document
            
            //Try loading the logo image into the {DF
            try {
                //Get the image from the directory
                Image logo = Image.getInstance("images/logo.png");
                logo.scaleToFit(150, 150);                  //Set image size
                logo.setAlignment(Image.ALIGN_CENTER);      //Align image to center
                doc.add(logo);                              //Add logo to document
            } catch (Exception e) {}
            
            
            Paragraph title = new Paragraph("TRANSCRIPT");  //Declare variable
            title.setAlignment(Element.ALIGN_CENTER);       //Align title to center
            doc.add(title);                                 //Adding title to document
            doc.add(new Paragraph(" "));                    //Adding line break
            
            //Adding labels and its' values
            doc.add(new Paragraph("Student Name: " + studentName)); 
            doc.add(new Paragraph("Student ID: " + studentID));
            doc.add(new Paragraph("Major: " + student.getMajor()));
            doc.add(new Paragraph("Year: " + selectedYear));
            doc.add(new Paragraph("Semester: " + selectedSem));
            doc.add(new Paragraph(" "));
            
            //Declaring the order of semester
            String[] semOrder = {"Spring", "Summer", "Fall"};
            
            //Declaring and initializing variables
            double overallCredits = 0;
            double overallPoints = 0;
            int overallPassed = 0;
            
            //For every semester according to the semester order
            for (String sem : semOrder) {
                
                //If a specific semester is selected and the current semester does not match it, skip it
                if (!selectedSem.equals("All") &&
                    !sem.equals(selectedSem)) {
                    continue;
                }
                
                //Create table in PDF document with 5 columns
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);      //Stretch table to fill page
                //Setting column names
                table.addCell("Course ID");
                table.addCell("Course Name");
                table.addCell("Credits");
                table.addCell("Grade");
                table.addCell("Grade Point");
                
                //Declare and initialize variables
                boolean hasCourses = false;
                double semCredits = 0;
                double semGpa = 0;
                int semPassed = 0;
                
                //For every student grade from StudentGrade
                for (StudentGrade sg : grades) {
                    
                    //If the record’s studentID and year is not equal to the selected studentID and year then skip
                    if (!sg.getStudentID().equals(studentID)) continue;
                    if (!sg.getYear().equals(selectedYear)) continue;
                    
                    //For every course obtained from Course
                    for (Course c : courses) {
                        
                        //If the record’s courseID and semeste and is not equal to the selected courseID and semester then skip
                        if (!c.getCourseID().equals(sg.getCourseID())) continue;
                        if (!c.getSemester().equalsIgnoreCase(sem)) continue;
                        
                        
                        hasCourses = true;

                        //Convert data type, get and assign it to variable
                        int credits = Integer.parseInt(c.getCredits());
                        double gpa = sg.getGradePoint();
                        String grade = sg.getGrade();
                        
                        //Add row with values
                        table.addCell(c.getCourseID());
                        table.addCell(c.getCourseName());
                        table.addCell(String.valueOf(credits)); 
                        table.addCell(grade);
                        table.addCell(String.valueOf(gpa));

                        //Calculate credit and gpa 
                        semCredits += credits;
                        semGpa += credits * gpa;

                        //Check if modules passed, add to count
                        if (passCheck(grade)) {
                            semPassed++;
                        }
                    }
                }
                
                //Only run the code inside this block if at least one course was found for this semester.”
                if (hasCourses) {
                    
                    //Add label and values
                    doc.add(new Paragraph("Semester: " + sem, new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
                    doc.add(new Paragraph(" "));
                    //Create table
                    doc.add(table);
                    doc.add(new Paragraph(" "));    //line break
                    
                    //Calculate GPA
                    double semGPA;              //Declare variable
                    if (semCredits == 0) {      //if no credits then no gpa
                        semGPA = 0;
                    } else {
                        semGPA = semGpa / semCredits;
                    }

                    //Add label and value
                    doc.add(new Paragraph("Semester Summary:"));
                    doc.add(new Paragraph("Modules Passed:  " + semPassed));
                    doc.add(new Paragraph("Credit Hours:    " + semCredits));
                    doc.add(new Paragraph("GPA:             " + String.format("%.2f", semGPA)));
                    doc.add(new Paragraph(" "));
                    
                    //Calcuate total credit, gpa and passed modules of all semesters
                    overallCredits += semCredits;
                    overallPoints += semGpa;
                    overallPassed += semPassed;
                }
            }
            
            //Only run the block below if user is printing annual report
            if (annualCheck) {
                
                //Declare varible
                double cgpa;
                //Same thing, no credit = no gpa
                if (overallCredits == 0) {
                    cgpa = 0;
                } else {
                    cgpa = overallPoints / overallCredits;      //Calculte cgpa
                }
                
                String award;   //Declare variable
                //Setting rule for award type
                if (cgpa >= 3.70) award = "Distinction";
                else if (cgpa >= 3.00) award = "Credit";
                else if (cgpa >= 2.00) award = "Pass";
                else award = "None";
                
                //Adding label and values
                doc.add(new Paragraph("Overall Grade: " , new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD + Font.UNDERLINE)));
                doc.add(new Paragraph("Total Modules Passed: " + overallPassed));
                doc.add(new Paragraph("Total Credit Hours: " + overallCredits));
                doc.add(new Paragraph("CGPA: " + String.format("%.2f", cgpa)));
                doc.add(new Paragraph("Award: " + award));
                doc.add(new Paragraph(" "));
                
                //Adding text and aligning to center
                Paragraph signedBy = new Paragraph("Signed by: ");
                signedBy.setAlignment(Element.ALIGN_CENTER);
                doc.add(signedBy);       
                //Adding image of signature with try catch method and aligning to center                
                try {
                    Image signature = Image.getInstance("images/signature.png");
                    signature.scaleToFit(100, 100);
                    signature.setAlignment(Image.ALIGN_CENTER);
                    doc.add(signature);
                } catch (Exception e) {}    
                
                //Adding text and aligning to center                
                Paragraph position = new Paragraph("(Registrar)");
                position.setAlignment(Element.ALIGN_CENTER);
                doc.add(position);                
                
                //Add a horizontal line
                doc.add(new Chunk(new LineSeparator()));
                
                //// Add the current date and time showing when the report was generated
                String dateGenerated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss"));
                doc.add(new Paragraph("Data Created: "+ dateGenerated));
                
                //Add texts
                doc.add(new Paragraph(" "));                
                doc.add(new Paragraph("Asia Pacific University of Technology & Innovation"));
                doc.add(new Paragraph("Jalan Teknologi 5, Taman Teknologi Malaysia, 57000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur"));
                doc.add(new Paragraph("Tel: 03-8996 1001"));
                doc.add(new Paragraph("Email: verify@apu.edu.my"));
                doc.add(new Paragraph("Website: www.apu.edu.my"));
            }
            doc.close();        //Close document after done editing so user can open on their device
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



