package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Constant {

    WebDriver driver;
    public Constant(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//form/div[1]//input")
    public WebElement userName;

    @FindBy (xpath = "//form/div[2]//input")
    public WebElement password;

    @FindBy (xpath = "//span/h6")
    public WebElement dashboard_text;

    @FindBy (xpath = "//*[@id=\"app\"]//p")
    public WebElement Invalid_Credentials;

    @FindBy(xpath = "//div[2]/button")
    public WebElement start_time;

    @FindBy(xpath = "//div[2]/div/div[2]//input")
    public WebElement set_time;

    @FindBy(xpath = "//div[3]/button")
    public WebElement punchIN_OUT;

    @FindBy(xpath = "//*[@id=\"oxd-toaster_1\"]")
    public WebElement toaster;

    @FindBy(xpath = "//li[4]//span")
    public WebElement time;

    @FindBy (xpath = "//span/h6[1]")
    public WebElement time_dashboard;
    @FindBy(xpath = "//header//nav//li[2]/span")
    public WebElement Attendance;
    @FindBy(xpath = "//*[@role=\"menu\"]/li[1]")
    public WebElement Attend_myRecords;

    @FindBy(xpath = "//*[@role=\"menu\"]/li[2]")
    public WebElement Attend_PunchIn_PunchOut;
    @FindBy(xpath = "//*[@role=\"menu\"]/li[3]")
    public WebElement Attend_Employ_record;
    @FindBy(xpath = "//*[@role=\"menu\"]/li[4]")
    public WebElement Attend_Configuration;

    @FindBy(xpath = "//header//nav//li[3]/span")
    public WebElement Reports;

    @FindBy(xpath = "//header//nav//li[4]/span")
    public WebElement Project_info;

    @FindBy(xpath = "//div[2]/ul/li[3]")
    public WebElement Leave;

    @FindBy(xpath = "//div[1]/span/h6")
    public WebElement Leave_header;

    @FindBy(xpath = "//*[@class=\"orangehrm-header-container\"]/span")
    public WebElement Leave_list;

    @FindBy(xpath = "//nav/ul/li[1]")
    public WebElement Leave_apply;



    @FindBy(xpath = "//*[@id=\"app\"]//div[2]/i")
    public WebElement leave_type;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")
    public WebElement leave_option;

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input")
    public WebElement apply_leave_date_from;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input")
    public WebElement apply_leave_date_till;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement apply_leave_button;

    @FindBy(xpath = "//*[@class=\"oxd-topbar-body\"]/nav/ul/li[2]")
    public WebElement myLeave;

    @FindBy(xpath = "//div[1]/h5")
    public WebElement MyleaveList_text;

    @FindBy(xpath = "//button[2]")
    public WebElement search_Holiday;



    @FindBy(xpath = "//nav/div[2]/ul/li[1]")
    public WebElement Admin;

    @FindBy(xpath = "//div[1]//h6[1]")
    public WebElement Admin_txt;

    @FindBy(xpath = "//div[2]/div[1]/button")
    public WebElement add_user;

    @FindBy(xpath = "//div/div/h6")
    public WebElement add_user_text;


    @FindBy(xpath = "//form//div/input")
    public WebElement employee_name;

    @FindBy(xpath = "//div[1]/div[2]//button")
    public WebElement add_Job_Title;

    @FindBy(xpath = "//div/h6")
    public WebElement title_text;

    @FindBy(xpath = "//form/div[1]//input")
    public WebElement Job_title_input;

    @FindBy(xpath = "//form/div[3]//input")
    public WebElement file_Input;


    @FindBy(xpath = "//div[2]//textarea")
    public WebElement Job_description;

    @FindBy(xpath = "//div[5]/button[2]")
    public WebElement save_job_data;

    @FindBy(xpath = "//form//input")
    public WebElement add_pay_grade_input;

    @FindBy(xpath = "//button[2]")
    public WebElement save_pay_grade;

    public String status="//form//div[3]//div[2]/div";

    public String User_Role="//form//div[2]/div";

    @FindBy(xpath = "//aside/nav//li[2]")
    public WebElement click_PIM;

    @FindBy(xpath = "//div[2]/div[1]/button")
    public WebElement click_add_employee;

    @FindBy(xpath = "//*[@class=\"--name-grouped-field\"]/div[1]//input")
    public WebElement firstName;

    @FindBy(xpath = "//*[@class=\"--name-grouped-field\"]/div[3]//input")
    public WebElement LastName;

    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]/div[2]//input")
    public WebElement employeeID;

    @FindBy(xpath = "//div[2]/div[1]/h6")
    public WebElement personal_details_text;
    @FindBy(xpath = "//div[2]/button[2]")
    public WebElement save_button;

    @FindBy(xpath = "//form/div[2]/div[2]/div[1]/div/div[2]/input")
    public WebElement driver_license_number;

    @FindBy(xpath = "//form/div[2]/div[2]/div[2]//input")
    public WebElement license_expiry_date;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/label/input")
    public WebElement employee_gender;

    @FindBy(xpath = "//form//button")
    public WebElement save_details;

    @FindBy(xpath = "//div[3]//form//button[2]")
    public WebElement save_3_details;

    @FindBy(xpath = "//div[3]/div[2]/div/span")
    public WebElement record_data;

    @FindBy(xpath = "//*[@role=\"tablist\"]/div[3]/a")
    public WebElement Emergency_contact;

    @FindBy(xpath = "//div[2]/div[1]/div/h6")
    public WebElement assigned_em_contact_text;

    @FindBy(xpath = "//div/div[2]//div/button")
    public WebElement add_contact_button;

    @FindBy(xpath = "//form//div[1]//div[2]/input")
    public WebElement name_Contact_number;

    @FindBy(xpath = "//form//div[2]//div[2]/input")
    public WebElement relation_contact_number;

    @FindBy(xpath = "//form/div[2]//div[2]//div[2]/input")
    public WebElement emergency_number;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button[2]")
    public WebElement save_emergency_contact;

    @FindBy(xpath = "//div[2]/div/span")
    public WebElement em_contact_record_txt;

    public String Nationality="//form/div[3]/div[1]/div[1]/div/div[2]/div";
    public String Marital_status="//form/div[3]/div[1]/div[2]/div/div[2]/div";

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//h6")
    public WebElement user_name;

    @FindBy(xpath = "//span/p")
    public WebElement dashboard_userName;

    @FindBy(xpath = "//div/div[1]/div[2]//input")
    public WebElement Employee_name_input;

    @FindBy(xpath = "//form/div[2]/button[2]")
    public WebElement search_employee;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div/span")
    public WebElement search_emyployee_records;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]")
    public WebElement employee_name_suggestions;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[2]")
    public WebElement confirm_password;


    @FindBy(xpath = "//div/div[2]/div[1]/button")
    public WebElement recruitment_add;

    @FindBy(xpath = "//form/div[3]//div[1]//div[2]/input")
    public WebElement recruitment_email;
    @FindBy(xpath = "//form/div[3]//div[2]//div[2]/input")
    public WebElement recruitment_phone_number;

    @FindBy(xpath = "//form/div[4]//div[2]/input")
    public WebElement recruitment_file_input;

    @FindBy(xpath = "//form//div[2]/button[2]")
    public WebElement recruitment_shortlist;

    @FindBy(xpath = "//form//button[2]")
    public WebElement save_form_data;

    @FindBy(xpath = "//form/div[2]/div/div[1]//input")
    public WebElement recruitment_sch_title;

    @FindBy(xpath = "//form/div[2]/div/div[2]//input")
    public WebElement recruitment_sch_interviewer;

    @FindBy(xpath = "//form/div[2]/div/div[3]//input")
    public WebElement recruitment_sch_date;

    @FindBy(xpath = "//form/div[2]/div/div[4]//input")
    public WebElement recruitment_sch_time;

    @FindBy(xpath = "//form/div[1]/div[1]//div[2]/input")
    public WebElement recrut_vacancyName;

    @FindBy(xpath = "//form/div[3]/div[1]//div[2]//input")
    public WebElement recrut_HiringManager;

    @FindBy(xpath = "//form/div[3]/div[2]//div[2]/input")
    public WebElement recrut_No_of_positions;

    @FindBy(xpath = "//div[2]/form/div[1]//div[2]/input")
    public WebElement vacancy_form2_filepath;

    @FindBy(xpath = "//div[2]/form/div[3]/button[2]")
    public WebElement save_form2;

    @FindBy(xpath = "//div[2]/div[2]/div/span")
    public WebElement vacancy_attachment_records;

    public String File_path="\\src\\TextDocument.txt";
    public String image_path="\\src\\button.png";

}