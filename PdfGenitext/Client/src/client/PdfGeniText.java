package client;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;



public class PdfGeniText { 
    public static void pdfgen(String folderpath) throws Exception 
    { 
        String file 
            = folderpath+ParsXmlReport.ContestNumber+"_"+ParsXmlReport.RequisitionTitle.replaceAll("[^a-zA-Z0-9\\s]","")+".pdf"; 
    
        // Step-1 Creating a PdfDocument object 
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);      
       
        PdfDocument pdfDoc 
            = new PdfDocument(new PdfWriter(file)); 
     
        Document doc = new Document(pdfDoc); 
       
        float [] pointColumnWidths3 = {160F, 160F, 160F};
        float [] pointColumnWidths2 = {210F, 210F};
        float [] pointColumnWidths1 = {500F}; 
        Table sumry = new Table(pointColumnWidths3); 
         
        Table ident = new Table(pointColumnWidths2); 
         
        
        Table Collaborators = new Table(pointColumnWidths1); 
        Table Profile = new Table(pointColumnWidths2);    
        Table Compensation = new Table(pointColumnWidths2);        
        Table Other = new Table(pointColumnWidths2);
        Table Question = new Table(pointColumnWidths1);
       
        sumry.addCell(new Cell().add("Status\n "+ParsXmlReport.Status).setBorder(Border.NO_BORDER).setFontSize(10));
        sumry.addCell(new Cell().add("Location\n "+ParsXmlReport.Country+">"+ParsXmlReport.State+">"+ParsXmlReport.WorkLocation).setBorder(Border.NO_BORDER).setFontSize(10)); 
        sumry.addCell(new Cell().add("Department \n"+ParsXmlReport.Department).setBorder(Border.NO_BORDER).setFontSize(10));
        sumry.addCell(new Cell().add("Hiring Manager\n "+ParsXmlReport.HiringManagerName).setBorder(Border.NO_BORDER).setFontSize(10));
        sumry.addCell(new Cell().add("Recruiter\n "+ParsXmlReport.RecruiterName).setBorder(Border.NO_BORDER).setFontSize(10));
        sumry.addCell(new Cell().add("Requisition type\n "+ParsXmlReport.RequisitionType).setBorder(Border.NO_BORDER).setFontSize(10));
        
        ident.addCell(new Cell().add("Title\n "+ParsXmlReport.RequisitionTitle).setBorder(Border.NO_BORDER).setFontSize(10));
        ident.addCell(new Cell().add("Number of Openings\n "+ParsXmlReport.NumberofOpenings).setBorder(Border.NO_BORDER).setFontSize(10));
        ident.addCell(new Cell().add("Proposal-based position?\n "+ParsXmlReport.ProposalBasedPosition).setBorder(Border.NO_BORDER).setFontSize(10));
        ident.addCell(new Cell().add("Internship?\n "+ParsXmlReport.Internship).setBorder(Border.NO_BORDER).setFontSize(10));
        ident.addCell(new Cell().add("Job Title\n "+ParsXmlReport.JobTitle).setBorder(Border.NO_BORDER).setFontSize(10));
        ident.addCell(new Cell().add("Applicant Tracking Form Completed?\n "+ParsXmlReport.ApplicantTracking).setBorder(Border.NO_BORDER).setFontSize(10));
        ident.addCell(new Cell().add("Fusion Legal Employer\n "+ParsXmlReport.LegalEmployer).setBorder(Border.NO_BORDER).setFontSize(10));
        
        
        
        
        doc.add(new Paragraph(ParsXmlReport.RequisitionTitle+"("+ParsXmlReport.ContestNumber+")").setFont(font));
        doc.add(sumry);
        doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("Requisition Structure").setFont(font));
        doc.add(new Paragraph("Identification").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________")); 
        doc.add(ident);
        doc.add(new Paragraph("\n"));
        
        doc.add(new Paragraph("Group").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________")); 
        doc.add(new Paragraph("User Group:\n "+ParsXmlReport.UserGroup).setFontSize(10));
        doc.add(new Paragraph("\n"));
        
        doc.add(new Paragraph("Structure").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________")); 
        doc.add(new Paragraph("Organization").setFontColor(Color.GRAY).setFontSize(10));
        doc.add(new Paragraph("Unit  "+ParsXmlReport.Unit).setFontSize(10));
        doc.add(new Paragraph("Business Unit  "+ParsXmlReport.BusinessUnit).setFontSize(10));
        doc.add(new Paragraph("Primary Location").setFontColor(Color.GRAY).setFontSize(10));
        doc.add(new Paragraph("Country  "+ParsXmlReport.Country).setFontSize(10));
        doc.add(new Paragraph("State/Province  "+ParsXmlReport.State).setFontSize(10));
        doc.add(new Paragraph("City  "+ParsXmlReport.City).setFontSize(10));
        doc.add(new Paragraph("Work Location  "+ParsXmlReport.WorkLocation).setFontSize(10));
        doc.add(new Paragraph("Job Field").setFontColor(Color.GRAY).setFontSize(10).setFontSize(10));
        doc.add(new Paragraph("Job Family  "+ParsXmlReport.JobFamily).setFontSize(10));
        doc.add(new Paragraph("Department  "+ParsXmlReport.Department).setFontSize(10));
        doc.add(new Paragraph("Requisition Template  "+ParsXmlReport.RequisitionTemplateUsedName).setFontSize(10));
        doc.add(new Paragraph("Requisition Template Code "+ParsXmlReport.RequisitionTemplateUsed).setFontSize(10));
        doc.add(new Paragraph("\n"));
        
        doc.add(new Paragraph("Owners").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________")); 
        
        doc.add(new Paragraph("Recruiter  \n"+ParsXmlReport.RecruiterName).setFontSize(10));
        doc.add(new Paragraph("Hiring Manager  \n"+ParsXmlReport.HiringManagerName).setFontSize(10));
        doc.add(new Paragraph("Recruiter Assistant  \n"+ParsXmlReport.RecruiterAssistantName).setFontSize(10));
        doc.add(new Paragraph("Hiring Manager Assistant  \n"+ParsXmlReport.HiringManagerAssistantName).setFontSize(10));
        Collaborators.addCell(new Cell().add("Collaborators").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
        if(!ParsXmlReport.Collaborators.contains(";")&&!ParsXmlReport.Collaborators.equals("")){
               Collaborators.addCell(new Cell().add(ParsXmlReport.Collaborators).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
            
            }
        else if(ParsXmlReport.Collaborators.contains(";")){
            String[] colb=ParsXmlReport.Collaborators.split(";");
            for(int k=0;k<colb.length;k++){
            Collaborators.addCell(new Cell().add(colb[k]).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));                                
                                               }
            
            }
        
       
        
        doc.add(Collaborators);
        doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("Process").setFont(font).setFontSize(12));
        doc.add(new Paragraph("Candidate Selection Workflow \n"+ParsXmlReport.CSWName).setFontSize(10));
        
        doc.add(new Paragraph("Job Information").setFont(font).setFontSize(12));
        doc.add(new Paragraph("Profile").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________"));
        Profile.addCell(new Cell().add("Employee Status \n"+ParsXmlReport.EmployeeStatus).setBorder(Border.NO_BORDER).setFontSize(10));
        Profile.addCell(new Cell().add("Offering Visa Sponsorship? \n"+ ParsXmlReport.VisaSponsor).setBorder(Border.NO_BORDER).setFontSize(10));
        Profile.addCell(new Cell().add("Shift \n"+ ParsXmlReport.JobShift).setBorder(Border.NO_BORDER).setFontSize(10));
        Profile.addCell(new Cell().add("Schedule \n"+ ParsXmlReport.JobSchedule).setBorder(Border.NO_BORDER).setFontSize(10));
        
        
        doc.add(Profile);
        
        
        doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("Compensation").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________"));
        Compensation.addCell(new Cell().add("Currency \n"+ ParsXmlReport.Currency).setBorder(Border.NO_BORDER).setFontSize(10));
        Compensation.addCell(new Cell().add("MinimumSalary \n"+ ParsXmlReport.MinimumSalary).setBorder(Border.NO_BORDER).setFontSize(10));
        Compensation.addCell(new Cell().add("MaximumSalary \n"+ ParsXmlReport.MaximumSalary).setBorder(Border.NO_BORDER).setFontSize(10));
        Compensation.addCell(new Cell().add("Grade \n"+ ParsXmlReport.Grade).setBorder(Border.NO_BORDER).setFontSize(10));
        doc.add(Compensation);
        doc.add(new Paragraph("\n"));
        
        doc.add(new Paragraph("Other").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________"));
        
        Other.addCell(new Cell().add("Overtime Status \n"+ ParsXmlReport.OvertimeStatus).setBorder(Border.NO_BORDER).setFontSize(10));
        Other.addCell(new Cell().add("Job Function \n"+ ParsXmlReport.JobFunctionName).setBorder(Border.NO_BORDER).setFontSize(10));
        Other.addCell(new Cell().add("Manager Level \n"+ ParsXmlReport.ManagerLevelName).setBorder(Border.NO_BORDER).setFontSize(10));
        Other.addCell(new Cell().add("Job Function Code \n"+ ParsXmlReport.JobFunctionCode).setBorder(Border.NO_BORDER).setFontSize(10));
        Other.addCell(new Cell().add("Manager Level Code \n"+ ParsXmlReport.ManagerLevelCode).setBorder(Border.NO_BORDER).setFontSize(10));
        Other.addCell(new Cell().add("Occupational Description \n"+ ParsXmlReport.OccupationalName).setBorder(Border.NO_BORDER).setFontSize(10));
        Other.addCell(new Cell().add("Occupational Code \n"+ ParsXmlReport.OccupationalCode).setBorder(Border.NO_BORDER).setFontSize(10));
        doc.add(Other);
        doc.add(new Paragraph("\n"));
        
        doc.add(new Paragraph("Job Description\n").setFont(font));
        doc.add(new Paragraph("External Description").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________"));
        doc.add(new Paragraph("Description - External").setFontColor(Color.GRAY));
        doc.add(new Paragraph(ParsXmlReport.ExternalDesc).setFontSize(10));
        doc.add(new Paragraph("Qualification - External").setFontColor(Color.GRAY));
        doc.add(new Paragraph(ParsXmlReport.ExternalQual).setFontSize(10));
        doc.add(new Paragraph("Internal Description").setFontSize(12));
        doc.add(new Paragraph("____________________________________________________________________________"));
        doc.add(new Paragraph("Description - Internal").setFontColor(Color.GRAY));
        doc.add(new Paragraph(ParsXmlReport.InternalDesc).setFontSize(10));
        doc.add(new Paragraph("Qualification - Internal").setFontColor(Color.GRAY));
        doc.add(new Paragraph(ParsXmlReport.InternalQual).setFontSize(10));
        doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("Questionnaire").setFont(font));
        Question.addCell(new Cell().add("Question").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
        if(!ParsXmlReport.QN1.equals(""))
        Question.addCell(new Cell().add("1. "+ParsXmlReport.QN1).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN2.equals(""))
        Question.addCell(new Cell().add("2. "+ParsXmlReport.QN2).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN3.equals(""))
        Question.addCell(new Cell().add("3. "+ParsXmlReport.QN3).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN4.equals(""))
        Question.addCell(new Cell().add("4. "+ParsXmlReport.QN4).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN5.equals(""))
        Question.addCell(new Cell().add("5. "+ParsXmlReport.QN5).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN6.equals(""))
        Question.addCell(new Cell().add("6. "+ParsXmlReport.QN6).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN7.equals(""))
        Question.addCell(new Cell().add("7. "+ParsXmlReport.QN7).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN8.equals(""))
        Question.addCell(new Cell().add("8. "+ParsXmlReport.QN8).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN9.equals(""))
        Question.addCell(new Cell().add("9. "+ParsXmlReport.QN9).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        if(!ParsXmlReport.QN10.equals(""))
        Question.addCell(new Cell().add("10. "+ParsXmlReport.QN10).setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.LIGHT_GRAY));
        doc.add(Question);
        
        doc.close(); 
        System.out.println("Table created successfully.."); 
    } 
}