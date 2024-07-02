package client;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class CandidateFile {
  
    public static void pdfgen() throws Exception 
    {
            NodeList Experiences;
            NodeList Study;
            NodeList ref;
            NodeList sign;
            NodeList Attach;
            NodeList persudf;
            NodeList queAns;
            NodeList certin;
            NodeList candidate;
            NodeList Req;
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);      
            
            PdfDocument pdfDoc 
                = new PdfDocument(new PdfWriter(ParsXml.fileName)); 
            //System.out.println(ParsXml.fileName);
           Document doc = new Document(pdfDoc,PageSize.A4);
            float [] pointColumnWidths3 = {160F, 160F, 160F};
            float [] pointColumnWidths2 = {410F, 110F};
            float [] pointColumnWidths2a = {400F, 110F};
            float [] pointColumnWidths1 = {500F}; 
            Table title = new Table(pointColumnWidths1);
            Table sumry = new Table(pointColumnWidths3);
            Table perso = new Table(pointColumnWidths3);
           Table pespro = new Table(pointColumnWidths2);
            Table ques = new Table(pointColumnWidths2a);
            Table exp = new Table(pointColumnWidths2);
            Table stdy = new Table(pointColumnWidths2);
            Table refe = new Table(pointColumnWidths2);
            Table cet = new Table(pointColumnWidths2);
            candidate = ParsXml.eElement.getElementsByTagName("e:Candidate");
            Node cann = candidate.item(0);
            String canfirstname="", canlastname="";
            if (cann.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement2 = (Element) cann;
                canfirstname=eElement2.getElementsByTagName("e:FirstName").item(0).getTextContent();
                canlastname=eElement2.getElementsByTagName("e:LastName").item(0).getTextContent();
            }
            
            Req = ParsXml.eElement.getElementsByTagName("e:Requisition");
            
            Node reqn = Req.item(0);
            
            if (reqn.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement2 = (Element) reqn;
            title.addCell(new Cell().add(canlastname+","+canfirstname+"("+ParsXml.eElement.getElementsByTagName("e:Number").item(0).getTextContent()+") applied for Job: "+eElement2.getElementsByTagName("e:Title").item(0).getTextContent()+"("+ParsXml.eElement.getElementsByTagName("e:ContestNumber").item(0).getTextContent()+")").setFont(font).setBorder(Border.NO_BORDER));
            }
            sumry.addCell(new Cell().add("Step\n "+ParsXml.eElement.getElementsByTagName("e:CSWStep").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("Status\n "+ParsXml.eElement.getElementsByTagName("e:CSWLatestStatus").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("Recruiter\n "+ParsXml.eElement.getElementsByTagName("e:RecruiterOwner").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("HiringManager\n "+ParsXml.eElement.getElementsByTagName("e:HiringManager").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("RecruitmentSource\n "+ParsXml.eElement.getElementsByTagName("e:RecruitmentSource").item(0).getTextContent().trim().replaceAll("\\n","")).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("RecruitmentSourceDetail\n "+ParsXml.eElement.getElementsByTagName("e:RecruitmentSourceDetail").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("Latest Submission Medium\n "+ParsXml.eElement.getElementsByTagName("e:ApplicationMedium").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("Creation Date\n "+ParsXml.eElement.getElementsByTagName("e:CreationDate").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            sumry.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10));
            doc.add(title);           
            doc.add(sumry);
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Note: Due to PDF conversion process, this PDF document may not accurately represent the formatting of the attchments that were converted")); 
            doc.add(new Paragraph("Candidate Attachment List:").setFont(font));
           
            Attach = ParsXml.eElement.getElementsByTagName("e:Attachment");
            for (int temp2 = 0; temp2 < Attach.getLength(); temp2++) {
                    Node nNode2 = Attach.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) nNode2;
                               doc.add(new Paragraph(temp2+1+"."+eElement2.getElementsByTagName("e:FileName").item(0).getTextContent()).setFontSize(10));                     
                        }
                }
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Personal Information").setFont(font));
            candidate = ParsXml.eElement.getElementsByTagName("e:Candidate");//Candidate match
            
                    Node cname = candidate.item(0);
                    if (cname.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) cname;
            perso.addCell(new Cell().add("Candidate Number\n "+eElement2.getElementsByTagName("e:Number").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("Employee Number\n "+eElement2.getElementsByTagName("e:EmployeeNumber").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));


            perso.addCell(new Cell().add("First Name\n "+eElement2.getElementsByTagName("e:FirstName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("Last Name\n "+eElement2.getElementsByTagName("e:LastName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("Middle Initial\n "+eElement2.getElementsByTagName("e:MiddleInitial").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            }     
            perso.addCell(new Cell().add("Address 1\n "+ParsXml.eElement.getElementsByTagName("e:Address").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("Address 2\n "+ParsXml.eElement.getElementsByTagName("e:Address2").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("City\n "+ParsXml.eElement.getElementsByTagName("e:City").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("ZipCode \n "+ParsXml.eElement.getElementsByTagName("e:ZipCode").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            
            if(ParsXml.eElement.getElementsByTagName("e:CountryLocation").getLength()>0)
            perso.addCell(new Cell().add("Place of Residence\n "+ParsXml.eElement.getElementsByTagName("e:CountryLocation").item(0).getTextContent().trim()+">"+ParsXml.eElement.getElementsByTagName("e:StateLocation").item(0).getTextContent().trim()+">"+ParsXml.eElement.getElementsByTagName("e:RegionLocation").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            else
            perso.addCell(new Cell().add("Place of Residence\n ").setBorder(Border.NO_BORDER).setFontSize(10));
            if(ParsXml.eElement.getElementsByTagName("e:PhoneType").getLength()>0)
            perso.addCell(new Cell().add("Primary Number \n "+ParsXml.eElement.getElementsByTagName("e:PhoneType").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            else
            perso.addCell(new Cell().add("Primary Number \n ").setBorder(Border.NO_BORDER).setFontSize(10));
    
            perso.addCell(new Cell().add("MobilePhone \n "+ParsXml.eElement.getElementsByTagName("e:MobilePhone").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("WorkPhone \n "+ParsXml.eElement.getElementsByTagName("e:WorkPhone").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("HomePhone \n "+ParsXml.eElement.getElementsByTagName("e:HomePhone").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("SocialSecurityNumber \n "+ParsXml.eElement.getElementsByTagName("e:SocialSecurityNumber").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("Birthday \n "+ParsXml.eElement.getElementsByTagName("e:Birthday").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("EmailAddress \n "+ParsXml.eElement.getElementsByTagName("e:EmailAddress").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            perso.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10));
           
           doc.add(perso);
           
            persudf = ParsXml.eElement.getElementsByTagName("e:Candidate");
            for (int temp2 = 1; temp2 < persudf.getLength(); temp2++) {
                    Node nNode2 = persudf.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) nNode2;
                            NodeList fieldNodes = eElement2.getElementsByTagName("e:UDF");
                            for(int j = 0; j < fieldNodes.getLength(); j++) {
                                    Node fieldNode = fieldNodes.item(j);
                                        NamedNodeMap attributes = fieldNode.getAttributes();
                                        Node attr = attributes.getNamedItem("name");
                                    if(attr.getTextContent().equals("Gender"))
                                    doc.add(new Paragraph("Gender\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Are_20you_20at_20least_2018_20years_20old_3f"))
                                    doc.add(new Paragraph("Are you atleast 18 years old\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Are_20you_20legally_20eligible_20to_20work_20in_20the_20country_20where_20the_20job_20is_20located_3f"))
                                    doc.add(new Paragraph("Are you legally eligible to work in the country where the job is located?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Are_20you_20under_20any_20contractual_20or_20legal_20obligation_2c_20such_20as_20a_20non_2dsolicitation_20or_20non_2dcompetition_20agreement_20or_20covenant_2c_20that_20would_20prevent_20you_20from_20either_20being_20hired_20by_20_20or_20fulfilling_20the_20job_20responsibilities_20at_20_3f"))
                                    doc.add(new Paragraph("Are you under any contractual or legal obligation, such as a non-solicitation or non-competition agreement or covenant, that would prevent you from either being hired by  or fulfilling the job responsibilities at ?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Clerical_20Skills"))
                                    doc.add(new Paragraph("Clerical Skills\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Deloitte_20Employee_3f"))
                                    doc.add(new Paragraph("Deloitte Employee?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("EDIB_20Question"))
                                    doc.add(new Paragraph("EDIB Question\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("EmployeeWorkCardNumber"))
                                    doc.add(new Paragraph("Employee Work CardNumber\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Have_20you_20ever_20had_20your_20employment_20involuntarily_20terminated_20or_20been_20asked_20to_20resign_20from_20employment_3f"))
                                    doc.add(new Paragraph("Have you ever had your employment involuntarily terminated or been asked to resign from employment?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Have_20you_20ever_20worked_20as_20an_20employee_2c_20consultant_2c_20or_20contractor_20for_20any_20local_2c_20state_2c_20provincial_2c_20or_20federal_20government_20agency_3f"))
                                    doc.add(new Paragraph("Have you ever worked as an employee, consultant, or contractor for any local, state, provincial, or federal government agency?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Have_20you_20ever_20worked_20for_20_20or_20its_20subsidiaries_20or_20affiliates_20in_20a_20capacity_20other_20than_20an_20employee_2c_20such_20as_20an_20independent_20contractor_2c_20temporary_20or_20leased_20employee_3f"))
                                    doc.add(new Paragraph("Have you ever worked for  or its subsidiaries or affiliates in a capacity other than an employee, such as an independent contractor, temporary or leased employee?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("If_20no_2c_20please_20explain_20_28legally_20eligible_20to_20work_20in_20country_29"))
                                    doc.add(new Paragraph("If no, please explain (legally eligible to work in country)\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    
                                    if(attr.getTextContent().equals("If_20yes_2c_20please_20give_20dates_20of_20employment_2c_20position_28s_29_20held_20and_20name_20while_20employed_20if_20different_20from_20present_20name_2e"))
                                    doc.add(new Paragraph("If yes, please give dates of employment, position(s) held and name while employed if different from present name.\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("If_20yes_2c_20please_20explain_2e_20involuntary_20termination"))
                                    doc.add(new Paragraph("If yes, please explain. involuntary termination\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("If_20you_20answered_20_u201cyes_u201d_20and_20this_20work_20experience_20is_20not_20reflected_20in_20the_20_u201cPREVIOUS_20EMPLOYMENT_20RECORD_u201d_20section_20of_20this_20application_2c_20then_20please_20describe_20your_20work_20experience_20for_20the_20government_20agency_20below_2c_20including_20dates_20of_20service_20or_20employment_2e"))
                                    doc.add(new Paragraph("If you answered \"yes\" and this work experience is not reflected in the \"PREVIOUS EMPLOYMENT RECORD\" section of this application, then please describe your work experience for the government agency below, including dates of service or employment.\n"+fieldNode.getTextContent().trim()).setFontSize(10));

                                    
                                    if(attr.getTextContent().equals("Languages_20Read"))
                                    doc.add(new Paragraph("Languages: Read\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Languages_20Spoken"))
                                    doc.add(new Paragraph("Languages: Spoken\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Languages_3a_20Write"))
                                    doc.add(new Paragraph("Languages: Write\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                
                                    if(attr.getTextContent().equals("Previous_20Intern_20Question"))
                                    doc.add(new Paragraph("Previous Intern Question\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Salary_20Expectations"))
                                    doc.add(new Paragraph("Salary Expectations\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("Will_20you_20now_20or_20in_20the_20future_20require_20sponsorship_20for_20employment_20visa_3f"))
                                    doc.add(new Paragraph("Will you now or in the future require sponsorship for employment visa?\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                    if(attr.getTextContent().equals("If_5fYes_5fSponsorship"))
                                    doc.add(new Paragraph("If Yes Explain on Sponsorship\n"+fieldNode.getTextContent().trim()).setFontSize(10));
                                }} }
            
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Profile Information").setFont(font));
           pespro.addCell(new Cell().add("Travel \n "+ParsXml.eElement.getElementsByTagName("e:WillingnessToTravel").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            pespro.addCell(new Cell().add("Job Shifts \n "+ParsXml.eElement.getElementsByTagName("e:JobShifts").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            pespro.addCell(new Cell().add("Job Schedules \n "+ParsXml.eElement.getElementsByTagName("e:JobSchedules").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
            pespro.addCell(new Cell().add("Job Levels \n "+ParsXml.eElement.getElementsByTagName("e:JobLevels").item(0).getTextContent().trim().replaceAll("\n","")).setBorder(Border.NO_BORDER).setFontSize(10));
            doc.add(pespro);
            doc.add(new Paragraph("Questionnaire").setFont(font));
            
            queAns = ParsXml.eElement.getElementsByTagName("e:QuestionAnswer");
            ques.addCell(new Cell().add("Question").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
            ques.addCell(new Cell().add("Answer").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
            
            for (int temp2 = 0; temp2 < queAns.getLength(); temp2++) {
                    Node nNode2 = queAns.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) nNode2;
                              
                            ques.addCell(new Cell().add(temp2+1+"."+eElement2.getElementsByTagName("e:Question").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                           
                            if (eElement2.getElementsByTagName("e:PossibleAnswer").getLength()>0)
                                ques.addCell(new Cell().add(eElement2.getElementsByTagName("e:PossibleAnswer").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                                  
                            else if (eElement2.getElementsByTagName("e:Explanation").getLength()>0)
                           
                            ques.addCell(new Cell().add(eElement2.getElementsByTagName("e:Explanation").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            
                        }
                }
            doc.add(ques);
            
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Submission Information").setFont(font));
            
            if(ParsXml.eElement.getElementsByTagName("e:ElectronicSignature").getLength()>0){
            sign= ParsXml.eElement.getElementsByTagName("e:ElectronicSignature");
            Node signnode = sign.item(0);
            if (signnode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement2 = (Element) signnode;
                        doc.add(new Paragraph("eSignature(By my eSignature below I certify that I have read, fully understand and accept all terms of foregoing statement)"));
                        doc.add(new Paragraph("Name\n"+eElement2.getElementsByTagName("e:Name").item(0).getTextContent()).setFontSize(10));
                        doc.add(new Paragraph("eSignature Date and Time\n"+eElement2.getElementsByTagName("e:DateTimeSigned").item(0).getTextContent()).setFontSize(10));
                        doc.add(new Paragraph("IPAddress\n"+eElement2.getElementsByTagName("e:IPAddress").item(0).getTextContent()).setFontSize(10));
                        doc.add(new Paragraph("Initials\n"+eElement2.getElementsByTagName("e:Initials").item(0).getTextContent()).setFontSize(10));
                        doc.add(new Paragraph("By my eSignature below I certify that I have read, fully understand and accept all terms of foregoing statement").setFontSize(10));
                        
                    }
            }
            
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Source Tracking").setFont(font));    
            doc.add(new Paragraph("Recruitment Source\n "+ParsXml.eElement.getElementsByTagName("e:RecruitmentSource").item(0).getTextContent().trim().replaceAll("\\n","")).setFontSize(10));
            doc.add(new Paragraph("Recruitment Source Detail\n "+ParsXml.eElement.getElementsByTagName("e:RecruitmentSourceDetail").item(0).getTextContent().trim()).setFontSize(10));
            
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Work Experience").setFont(font));      
            if(ParsXml.eElement.getElementsByTagName("e:Experience").getLength()>0){
            Experiences = ParsXml.eElement.getElementsByTagName("e:Experience");
            for (int temp1 = 0; temp1 < Experiences.getLength(); temp1++) {
                    Node nNode1 = Experiences.item(temp1);
                    if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) nNode1;
                           // expres.addCell(exp.addCell(new Cell().add("Experience").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY))+                            exp.addCell(new Cell().add("Experience").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY)));
                            exp.addCell(new Cell().add("Experience").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
                            exp.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));

                        exp.addCell(new Cell().add("Employer \n "+eElement1.getElementsByTagName("e:Employer").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("Other Employer Name \n "+eElement1.getElementsByTagName("e:OtherEmployerName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        
                        exp.addCell(new Cell().add("Other Job Title \n "+eElement1.getElementsByTagName("e:OtherJobTitle").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("Job Function \n "+eElement1.getElementsByTagName("e:JobFunction").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        
                        exp.addCell(new Cell().add("Begin Date \n "+eElement1.getElementsByTagName("e:BeginDate").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("End Date \n "+eElement1.getElementsByTagName("e:EndDate").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        
                        exp.addCell(new Cell().add("Current Employer \n "+eElement1.getElementsByTagName("e:CurrentEmployer").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("Permission To Contact \n "+eElement1.getElementsByTagName("e:PermissionToContact").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                    
                        exp.addCell(new Cell().add("Supervisor Name \n "+eElement1.getElementsByTagName("e:Supervisor").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("Supervisor Email \n "+eElement1.getElementsByTagName("e:SupervisorEmail").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            
                        exp.addCell(new Cell().add("Supervisor Phone \n "+eElement1.getElementsByTagName("e:SupervisorPhone").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("Supervisor Title \n "+eElement1.getElementsByTagName("e:SupervisorTitle").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            
                        exp.addCell(new Cell().add("Responsibility \n "+eElement1.getElementsByTagName("e:Responsibility").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                        exp.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10));
                            
                        }
                }}
            doc.add(exp);
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Education History").setFont(font));
            
            if(ParsXml.eElement.getElementsByTagName("e:Study").getLength()>0){
            Study = ParsXml.eElement.getElementsByTagName("e:Study");
            for (int temp2 = 0; temp2 < Study.getLength(); temp2++) {
                    Node nNode2 = Study.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) nNode2;
                            stdy.addCell(new Cell().add("Education").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
                            stdy.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));

                            stdy.addCell(new Cell().add("Other Course Title \n "+eElement2.getElementsByTagName("e:OtherCourseTitle").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("Other Institution Name \n "+eElement2.getElementsByTagName("e:OtherInstitutionName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("Institution \n "+eElement2.getElementsByTagName("e:Institution").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("Program \n "+eElement2.getElementsByTagName("e:Program").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("StartDate \n "+eElement2.getElementsByTagName("e:StartDate").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("Graduation Date \n "+eElement2.getElementsByTagName("e:GraduationDate").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("Study Level \n "+eElement2.getElementsByTagName("e:StudyLevel").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            stdy.addCell(new Cell().add("Gpa \n "+eElement2.getElementsByTagName("e:Gpa").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));                  
                            
                        }
                }}
            doc.add(stdy);
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Reference").setFont(font));
            
            if(ParsXml.eElement.getElementsByTagName("e:Reference").getLength()>0){
            ref = ParsXml.eElement.getElementsByTagName("e:Reference");
            for (int temp2 = 0; temp2 < ref.getLength(); temp2++) {
                    Node nNode2 = ref.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) nNode2;
                            refe.addCell(new Cell().add("Reference").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
                            refe.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
    
                            refe.addCell(new Cell().add("Company \n "+eElement2.getElementsByTagName("e:Company").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("First Name \n "+eElement2.getElementsByTagName("e:FirstName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("Last Name \n "+eElement2.getElementsByTagName("e:LastName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("Title \n "+eElement2.getElementsByTagName("e:Title").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));

                            refe.addCell(new Cell().add("Relationship \n "+eElement2.getElementsByTagName("e:Relationship").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("Relationship Length \n "+eElement2.getElementsByTagName("e:RelationshipLength").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("Phone Number \n "+eElement2.getElementsByTagName("e:PhoneNumber").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("Email \n "+eElement2.getElementsByTagName("e:EmailAddress").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            
                            refe.addCell(new Cell().add("Reference Type \n "+eElement2.getElementsByTagName("e:ReferenceType").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            refe.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10));
                        }
                }}
            doc.add(refe);
            
            doc.add(new Paragraph("____________________________________________________________________________"));
            doc.add(new Paragraph("Certification").setFont(font));
            if(ParsXml.eElement.getElementsByTagName("e:ApplicationCertification").getLength()>0){
            certin = ParsXml.eElement.getElementsByTagName("e:ApplicationCertification");
            for (int temp2 = 0; temp2 < certin.getLength(); temp2++) {
                    Node nNode2 = certin.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement2 = (Element) nNode2;
                            cet.addCell(new Cell().add("Certification").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
                            cet.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10).setBackgroundColor(Color.GRAY));
            
                            cet.addCell(new Cell().add("Number Id \n "+eElement2.getElementsByTagName("e:NumberId").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            cet.addCell(new Cell().add("Certification Name\n "+eElement2.getElementsByTagName("e:Certification").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            cet.addCell(new Cell().add("Other Certification Name \n "+eElement2.getElementsByTagName("e:OtherCertificationName").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            cet.addCell(new Cell().add("Issuing Organization \n "+eElement2.getElementsByTagName("e:IssuingOrganization").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));

                            cet.addCell(new Cell().add("ExpirationDate \n "+eElement2.getElementsByTagName("e:ExpirationDate").item(0).getTextContent().trim()).setBorder(Border.NO_BORDER).setFontSize(10));
                            cet.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setFontSize(10));
                           
                        }
                }}
            doc.add(cet);
            
        doc.close();
        }

}
