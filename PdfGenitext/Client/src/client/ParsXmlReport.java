package client;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.io.FileReader;

import java.util.Properties;

import org.w3c.dom.NamedNodeMap;

public class ParsXmlReport {
    static String ContestNumber,RequisitionTitle,LegalEmployer,NumberofOpenings,DiversityOutreach,RemoteTelework,Justification,ProposalBasedPosition,Internship,JobTitle,ApplicantTracking,AAPImpactedJob,TACTForm,UserGroup,RequisitionType,Unit,BusinessUnit,Country,State,City,WorkLocation,JobFamily,Department,RequisitionTemplateUsed,RequisitionTemplateUsedName,RecruiterName,RecruiterAssistantName,HiringManagerName,HiringManagerAssistantName,Collaborators,CSWName,AdditionalInformation,BGCChargeCode,EmployeeStatus,VisaSponsor,JobLevel,TravelWillingness,JobShift,JobSchedule,TargetStartDate,Currency,Grade,MinimumSalary,MaximumSalary,OvertimeStatus,JobFunctionName,JobFunctionCode,ManagerLevelName,ManagerLevelCode,OccupationalName,OccupationalCode,ExternalDesc,ExternalQual,InternalDesc,InternalQual,Status,QN1,QN2,QN3,QN4,QN5,QN6,QN7,QN8,QN9,QN10;

    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public static void main(String args[]) {
        
            try {
                    FileReader reader1=new FileReader("config.properties");  
                          
                        Properties p=new Properties();  
                        p.load(reader1);
                    PdfGeniText gen= new PdfGeniText();
                    File fXmlFile = new File(p.getProperty("filename"));
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(fXmlFile);
                    doc.getDocumentElement().normalize();                
                    NodeList nList = doc.getElementsByTagName("record");
                
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element eElement = (Element) nNode;
                                    NodeList fieldNodes = eElement.getElementsByTagName("field");
                                    for(int j = 0; j < fieldNodes.getLength(); j++) {
                                        Node fieldNode = fieldNodes.item(j);
                                            NamedNodeMap attributes = fieldNode.getAttributes();
                                            Node attr = attributes.getNamedItem("name");
                                        if(attr.getTextContent().equals("ContestNumber")) {
                                              ContestNumber=  fieldNode.getTextContent();//1
                                                                                        }
                                            if(attr.getTextContent().equals("RequisitionTitle")) {
                                                  RequisitionTitle=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("Status")) {
                                                  Status=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("WorkLocation")) {
                                                  WorkLocation=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("RecruiterName")) {
                                                  RecruiterName=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("RequisitionType")) {
                                                  RequisitionType=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("HiringManagerName")) {
                                                  HiringManagerName=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("Department")) {
                                                  Department=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("ExternalDesc")) {
                                                  ExternalDesc=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("ExternalQual")) {
                                                  ExternalQual=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("InternalDesc")) {
                                                  InternalDesc=  fieldNode.getTextContent();
                                                                                            }
                                            if(attr.getTextContent().equals("InternalQual")) {
                                                  InternalQual=  fieldNode.getTextContent();
                                                                                            }

                                            if(attr.getTextContent().equals("UserGroup")) {
                                                  UserGroup=  fieldNode.getTextContent();
                                                                                            }   
                                            if(attr.getTextContent().equals("Unit")) {
                                                  Unit=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("BusinessUnit")) {
                                                  BusinessUnit=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("JobFamily")) {
                                                  JobFamily=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("RecruiterAssistantName")) {
                                                  RecruiterAssistantName=  fieldNode.getTextContent();
                                                                                     }
                                        
                                            if(attr.getTextContent().equals("CSWName")) {
                                                  CSWName=  fieldNode.getTextContent();
                                                                                     }
                                        
                                            if(attr.getTextContent().equals("EmployeeStatus")) {
                                                  EmployeeStatus=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("JobShift")) {
                                                  JobShift=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("JobSchedule")) {
                                                  JobSchedule=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("Currency")) {
                                                  Currency=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("OvertimeStatus")) {
                                                  OvertimeStatus=  fieldNode.getTextContent();
                                                                                     }
                                            if(attr.getTextContent().equals("LegalEmployer"))
                                            LegalEmployer=  fieldNode.getTextContent();
                                            
                                            if(attr.getTextContent().equals("NumberofOpenings"))
                                            NumberofOpenings=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("DiversityOutreach"))
                                            DiversityOutreach=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("RemoteTelework"))
                                            RemoteTelework=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("Justification"))
                                            Justification=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("ProposalBasedPosition"))
                                            ProposalBasedPosition=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("Internship"))
                                            Internship=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("ApplicantTracking"))
                                            ApplicantTracking=fieldNode.getTextContent();//31
                                        
                                            if(attr.getTextContent().equals("QN1"))
                                            QN1=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN2"))
                                            QN2=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN3"))
                                            QN3=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN4"))
                                            QN4=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN5"))
                                            QN5=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN6"))
                                            QN6=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN7"))
                                            QN7=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN8"))
                                            QN8=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN9"))
                                            QN9=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("QN10"))
                                            QN10=fieldNode.getTextContent();//41
                                            
                                            if(attr.getTextContent().equals("AAPImpactedJob"))
                                            AAPImpactedJob=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("TACTForm"))
                                            TACTForm=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("City"))
                                            City=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("Country"))
                                            Country=fieldNode.getTextContent();
                                        
                                            if(attr.getTextContent().equals("State"))
                                            State=fieldNode.getTextContent();
                                        
                                        
                                             if(attr.getTextContent().equals("RequisitionTemplateUsed"))
                                            RequisitionTemplateUsed=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("RequisitionTemplateUsedName"))
                                            RequisitionTemplateUsedName=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("HiringManagerAssistantName"))
                                            HiringManagerAssistantName=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("Collaborators"))
                                            Collaborators=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("AdditionalInformation"))
                                            AdditionalInformation=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("BGCChargeCode"))
                                            BGCChargeCode=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("VisaSponsor"))
                                            VisaSponsor=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("JobLevel"))
                                            JobLevel=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("TravelWillingness"))
                                            TravelWillingness=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("Grade"))
                                            Grade=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("MinimumSalary"))
                                            MinimumSalary=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("MaximumSalary"))
                                            MaximumSalary=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("JobFunctionName"))
                                            JobFunctionName=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("ManagerLevelName"))
                                            ManagerLevelName=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("ManagerLevelCode"))
                                            ManagerLevelCode=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("OccupationalName"))
                                            OccupationalName=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("OccupationalCode"))
                                            OccupationalCode=fieldNode.getTextContent();//63
                                            if(attr.getTextContent().equals("JobTitle"))
                                            JobTitle=fieldNode.getTextContent();
                                            if(attr.getTextContent().equals("JobFunctionCode"))
                                            JobFunctionCode=fieldNode.getTextContent();
   

                                        }
                                
                                }
                            gen.pdfgen(p.getProperty("destfolderpath"));
                        }
                
                }
             catch (Exception e) {
            e.printStackTrace();
            }
        
        }
}
