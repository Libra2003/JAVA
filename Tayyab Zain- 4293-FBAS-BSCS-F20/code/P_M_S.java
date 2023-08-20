//Sir kuch students ne mera copy paste kea hua h but mine is the original one and if u want proof i can give u demo
// and i apologize time ki kummy ki wjha se main complete nhi kr ska but i will complete it after the exams cause i
//will be pushing it on my github
// and i have used MYSQL instead of access of oracle cause they wren't working on my computer for some reason and i couldn't fighure out why

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import java.util.List;


public class P_M_S {
    public static  JFrame mainFrame;
    public static JPanel mainPanel; //mainPanel upon which all the other panels will be shown
    public static JPanel main;  //Panel for the starting window
    public static JPanel adminPanel,guestPanel;//Admin and gust panel for admin and guest

    public static String disease;
    static CardLayout layout = new CardLayout();    //Card layout helps us to display one panel over the other
    static ImageIcon icon = new ImageIcon("images.png");//Backward icon
    static JButton backward = new JButton(icon);//This button used to go back in menu bar

    static boolean found;
    static int diseaseID = 0;

    static Connection con = null;

    public static void main(String[] args) throws SQLException {

        //Database Connection
//Establishing Connections
        String dburl = "jdbc:mysql://127.0.0.1/patient_mangement_system";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dburl,"root","kuchbhi");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //End Connection
        //Creating Databases
        //Disease Table

        String query1 = "create table if not exists disease_info(Disease_ID Integer primary key auto_increment, Disease_Name varchar(100) not null, Disease_description varchar(100) not null)";
        Statement stmt1 = con.createStatement();
        stmt1.executeUpdate(query1);

        //Doctor Table

        String query2 = "create table if not exists Doctor_info(Doctor_Name varchar(100), Doctor_ID Integer primary key auto_increment, Disease_ID Integer, FOREIGN KEY fk_disease_id (Disease_ID) REFERENCES disease_info(Disease_ID))";
        Statement stmt2 = con.createStatement();
        stmt2.executeUpdate(query2);


        String query3 ="create table if not exists Patient_info(Patient_ID Integer primary key auto_increment, Patient_Name varchar(100) not null, PF_Name varchar(100) not null," +
                " Sex varchar(100) not null, Doctor_ID Integer, FOREIGN KEY (Doctor_ID) REFERENCES Doctor_info(Doctor_ID), Disease_History varchar(100) not null" +
                ", Prescription varchar(100) not null)";

        Statement stmt3 = con.createStatement();
        stmt3.executeUpdate(query3);

        //end

        Image resizeimage = icon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon resizedicon = new ImageIcon(resizeimage);
        backward.setIcon(resizedicon);


        // Creating a JFrame and set its layout to a CardLayout
        mainFrame = new JFrame("Patient Management System");
        mainFrame.setSize(500,500);
        //Card Layout to add multiple panels to one Frame
        JPanel mainPanel = new JPanel(layout);  //set its layout to a CardLayout
        mainFrame.add(mainPanel);

        //New Panel for starting window
        JPanel main = new JPanel();
        main.setLayout(null);//Null Layout
        mainPanel.add(main,"Panel");

        JButton adminbtn,guestbtn;
        adminbtn = new JButton("Administrator");
        adminbtn.setBounds(150,100,200,80);
        guestbtn = new JButton("Guest");
        guestbtn.setBounds(150,200,200,80);
        main.add(adminbtn);
        main.add(guestbtn);

        //Guest and Administrator panel
        JPanel adminPanel,guestPanel;

        //Admin
        adminPanel = new JPanel();
        adminPanel.setLayout(null);

        adminbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(adminPanel, "Admin");
                layout.show(mainPanel,"Admin");
                found = true;
                administration ad = new administration(adminPanel,mainPanel);
            }
        });

        //guest
        guestPanel = new JPanel();
        guestPanel.setLayout(null);

        guestbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(guestPanel,"Guest");
                layout.show(mainPanel,"Guest");
                administration ad = new administration(guestPanel,mainPanel);

            }
        });

        mainFrame.setVisible(true);

    }
}

class administration extends P_M_S{
    JMenuBar bar = new JMenuBar();

    JMenu menu1 = new JMenu("Menu");
    JMenu menu2 = new JMenu("help");

    JPanel homePanel;//Panel for administration class for Home


    public administration(JPanel loginPanel,JPanel mainPanel){
        homePanel = new JPanel();

        if(found){
            adminlogin(loginPanel,mainPanel,homePanel);
        }
        else{
            guestlogin(loginPanel,mainPanel,homePanel);
        }


        mainFrame.setVisible(true);
    }

    void guestlogin( JPanel startPanel, JPanel mainPanel, JPanel homePanel){


        //Log in Panel
        JLabel adminlabel = new JLabel("Guest");
        adminlabel.setBounds(200,5,200,200);
        startPanel.add(adminlabel);
        //Username
        JLabel U_name1 = new JLabel("Username");
        U_name1.setBounds(70,150,200,30);
        startPanel.add(U_name1);
        JTextField U_name2 = new JTextField();
        U_name2.setBounds(150,150,200,30);
        startPanel.add(U_name2);
        //Password
        JLabel pass1 = new JLabel("Password");
        JTextField pass2 = new JTextField();
        pass1.setBounds(70,210,200,30);
        pass2.setBounds(150,210,200,30);
        startPanel.add(pass1);
        startPanel.add(pass2);

        JButton loginbtn = new JButton("Login");
        JButton backbtn = new JButton("go back");
        loginbtn.setBounds(150,270,100,30);
        backbtn.setBounds(250,270,100,30);
        startPanel.add(loginbtn);
        startPanel.add(backbtn);


        //Login button action prmotes into admin gui or go back

        JLabel warning = new JLabel("Wrong UserName or Password was given");
        warning.setBounds(130,230,300,30);

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(U_name2.getText().equals("1")&&(pass2.getText().equals("1"))){

                    mainPanel.add(homePanel,"Login");
                    layout.show(mainPanel,"Login");
                    admin_GUI(homePanel,mainPanel);
                }
                else{
                    mainPanel.add(startPanel,"Warning");
                    layout.show(mainPanel,"Warning");
                    startPanel.add(warning);
                }
            }
        });
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(startPanel,"Main Panel");
                layout.show(mainPanel,"Main");
            }
        });
    }
    void adminlogin( JPanel startPanel, JPanel mainPanel, JPanel homePanel){


        //Log in Panel
        JLabel adminlabel = new JLabel("Administration");
        adminlabel.setBounds(200,5,200,200);
        startPanel.add(adminlabel);
        //Username
        JLabel U_name1 = new JLabel("Username");
        U_name1.setBounds(70,150,200,30);
        startPanel.add(U_name1);
        JTextField U_name2 = new JTextField();
        U_name2.setBounds(150,150,200,30);
        startPanel.add(U_name2);
        //Password
        JLabel pass1 = new JLabel("Password");
        JTextField pass2 = new JTextField();
        pass1.setBounds(70,210,200,30);
        pass2.setBounds(150,210,200,30);
        startPanel.add(pass1);
        startPanel.add(pass2);

        JButton loginbtn = new JButton("Login");
        JButton backbtn = new JButton("go back");
        loginbtn.setBounds(150,270,100,30);
        backbtn.setBounds(250,270,100,30);
        startPanel.add(loginbtn);
        startPanel.add(backbtn);


        //Login button action prmotes into admin gui or go back

        JLabel warning = new JLabel("Wrong UserName or Password was given");
        warning.setBounds(130,230,300,30);

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(U_name2.getText().equals("1")&&(pass2.getText().equals("1"))){

                    mainPanel.add(homePanel,"Login");
                    layout.show(mainPanel,"Login");
                    admin_GUI(homePanel,mainPanel);
                }
                else{
                    mainPanel.add(startPanel,"Warning");
                    layout.show(mainPanel,"Warning");
                    startPanel.add(warning);
                }
            }
        });
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(startPanel,"Main Panel");
                layout.show(mainPanel,"Main");
            }
        });
    }

    JMenuItem add_patient = new JMenuItem("Add Patient");
    JMenuItem add_doc = new JMenuItem("Add Doctor");
    JMenu searchMenu= new JMenu("Search");
    JMenuItem del_pat = new JMenuItem("Delete Patient");
    JMenuItem dise = new JMenuItem("Add Disease");
    JMenu upd = new JMenu("update");
    JMenuItem upd_pat = new JMenuItem("Update Patient");
    JMenuItem upd_doc = new JMenuItem("Update Doctor");


    //Search items start

    JMenuItem S_P_Name = new JMenuItem("Search Patient By Name");
    JMenuItem S_P_ID = new JMenuItem("Search Patient By ID");
    JMenuItem S_P_Age = new JMenuItem("Search Patient By Age");
    JMenuItem S_P_Disease = new JMenuItem("Search Patient By Disease");
    JMenuItem S_P_Doctor = new JMenuItem("Search Patient By Name");
    JMenuItem S_D_Name = new JMenuItem("Search Doctor by Name");
    JMenuItem S_D_Specializ = new JMenuItem("Search Doctor by Specialization");
    //Search items end

    //Help
    JMenuItem aboutUsItem = new JMenuItem("About Us");
    JMenuItem changepassItem = new JMenuItem("Change Password");

    void admin_GUI(JPanel panel, JPanel mainPanel){

        bar.setBounds(10,50,500,80);
        bar.add(backward);
        bar.add(menu1);
        bar.add(menu2);
        mainFrame.setJMenuBar(bar);
        manage(mainPanel, panel);
        homePanel.setVisible(true);
    }

    void manage(JPanel mainPanel, JPanel panel){

        menu1.add(add_patient);
        menu1.add(add_doc);
        menu1.add(del_pat);
        searchMenu.add(S_P_Name);
        searchMenu.add(S_P_Age);
        searchMenu.add(S_P_Disease);
        searchMenu.add(S_P_Doctor);
        searchMenu.add(S_P_Doctor);
        searchMenu.add(S_D_Specializ);
        menu1.add(searchMenu);
        menu1.add(upd);
        menu1.add(dise);
        upd.add(upd_doc);
        upd.add(upd_pat);
        menu1.add(upd);

        menu2.add(aboutUsItem);
        menu2.add(changepassItem);
        backward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(panel, "Admin");
                layout.show(mainPanel,"Admin");
            }
        });

        JPanel adddoc = new JPanel();//Panel for adding doctor info
        adddoc.setLayout(null);
        JPanel addPat = new JPanel();//Panel for adding patient info
        addPat.setLayout(null);

        add_doc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainPanel.add(adddoc,"Doctor info");
                layout.show(mainPanel,"Doctor info");
                try {
                    add_Dcotor(adddoc,mainPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        add_patient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainPanel.add(addPat,"Adding Panel");
                layout.show(mainPanel,"Adding Panel");
                add_Patient(addPat,mainPanel);

            }
        });

        JPanel disePanel = new JPanel();
        disePanel.setLayout(null);
        dise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(disePanel,"Disease");
                layout.show(mainPanel,"Disease");
                try {
                    add_Disease(disePanel, mainPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }

    void add_Disease(JPanel addDiesePanel, JPanel mainPanel) throws SQLException {

        //title
        JLabel title1 = new JLabel("ADD Disease ");
        title1.setBounds(200,2,80,30);
        addDiesePanel.add(title1);

        //Name
        JLabel namelabel = new JLabel("Disease Name ");
        namelabel.setBounds(30,30,120,20);
        addDiesePanel.add(namelabel);
        JTextField nametext = new JTextField();
        nametext.setBounds(150,30,100,20);
        addDiesePanel.add(nametext);

        //Description
        JLabel deslabel = new JLabel("Description ");
        deslabel.setBounds(30,100,80,20);
        addDiesePanel.add(deslabel);
        JTextField destext = new JTextField();
        destext.setBounds(150,100,200,150);
        addDiesePanel.add(destext);

        //ID
        //getting id from the table and showing the increment
        int getid = 0;
        String idQuery = "select * FROM disease_info";
        Statement stmt = con.createStatement();
        ResultSet set = stmt.executeQuery(idQuery);
        int i =1;
        while (set.next()){
            getid = set.getInt("Disease_id");
            i++;
        }
        getid++;

        JLabel idlabel = new JLabel("ID ");
        idlabel.setBounds(30,60,80,20);
        addDiesePanel.add(idlabel);
        JTextField idtext = new JTextField();
        idtext.setBounds(150,60,80,20);
        idtext.setText(String.valueOf(getid));
        addDiesePanel.add(idtext);

        JButton savebtn1,cancelbtn1;
        savebtn1 = new JButton("Save");
        savebtn1.setBounds(150,260,100,40);
        cancelbtn1 = new JButton("cancel");
        cancelbtn1.setBounds(260,260,100,40);
        addDiesePanel.add(savebtn1);
        addDiesePanel.add(cancelbtn1);

        savebtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String I_D = "insert into disease_info (Disease_Name, Disease_description) values (?, ?)";                PreparedStatement stmt = null;
                try {
                    stmt = con.prepareStatement(I_D);
                    stmt.setString(1, nametext.getText());
                    stmt.setString(2, destext.getText());
                    nametext.setText("");
                    destext.setText("");

                    stmt.executeUpdate();


                    mainPanel.add(homePanel,"Home");
                    layout.show(mainPanel,"Home");


                    mainPanel.add(addDiesePanel,"Disease");
                    layout.show(mainPanel,"Disease");
                    add_Disease(addDiesePanel,mainPanel);


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cancelbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(homePanel,"home");
                layout.show(mainPanel,"home");
            }
        });
        mainFrame.setVisible(true);
    }

    //This function return the doctor ID from the doctor_info table
    private List<String> retrieveValuesFromDatabase_doc() {
        List<String> values = new ArrayList<>();
        String idQuery3 = "select * FROM doctor_info";
        Statement stmt3 = null;
        try {
            stmt3 = con.createStatement();
            ResultSet set1 = stmt3.executeQuery(idQuery3);
            int i = 1;
            //This loops keep adding the rows into the string until it ends
            while (set1.next()) {
                values.add(set1.getString(2));
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return values;
    }

    //This function return the diseasse_ID from the disease_info table
    private List<String> retrieveValuesFromDatabase_dise() {
        List<String> values = new ArrayList<>();
        String idQuery3 = "select * FROM disease_info";
        Statement stmt3 = null;
        try {
            stmt3 = con.createStatement();
            ResultSet set1 = stmt3.executeQuery(idQuery3);
            int i =1;
            //This loops keep adding the rows into the string until it ends
            while (set1.next()){
                values.add(set1.getString(2));
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return values;
    }

//This code returns the relevant id against the given name from the disease info table
    int storeIDinDiseaseinfo(String comboname) throws SQLException {
        //comboname is the name aginst which we will check the ids
        String selectQuery = "SELECT Disease_ID FROM disease_info WHERE Disease_Name = ?";
        PreparedStatement stmt = con.prepareStatement(selectQuery);
        stmt.setString(1, comboname);
        ResultSet diseaseIdResultSet = stmt.executeQuery();

        //diseaseResult is being stored in a list of integer
        int getint = 0;
        if (diseaseIdResultSet.next()) {
            getint = diseaseIdResultSet.getInt("Disease_ID");
        }
        return getint;
    }

    int storeIDinDoctorinfo(String comboname) throws SQLException {
        //comboname is the name aginst which we will check the ids
        String selectQuery = "SELECT Doctor_ID FROM doctor_info WHERE Disease_Name = ?";
        PreparedStatement stmt = con.prepareStatement(selectQuery);
        stmt.setString(1, comboname);
        ResultSet diseaseIdResultSet = stmt.executeQuery();

        //diseaseResult is being stored in a list of integer
        int getint = 0;
        if (diseaseIdResultSet.next()) {
            getint = diseaseIdResultSet.getInt("Doctor_ID");
        }
        return getint;
    }

    void add_Patient(JPanel addPat, JPanel mainPanel){
        //title
        JLabel title1 = new JLabel("ADD Patient ");
        title1.setBounds(200,2,80,30);
        addPat.add(title1);

        //Name
        JLabel namelabel = new JLabel("Name ");
        namelabel.setBounds(30,30,80,20);
        addPat.add(namelabel);
        JTextField nametext = new JTextField();
        nametext.setBounds(150,30,100,20);
        addPat.add(nametext);

        //ID
        JLabel idlabel = new JLabel("ID ");
        idlabel.setBounds(30,60,20,20);
        addPat.add(idlabel);
        JTextField idtext = new JTextField();
        idtext.setBounds(150,60,100,20);
        addPat.add(idtext);

        //Father Name
        JLabel f_N_label = new JLabel("Father Name ");
        f_N_label.setBounds(30,90,80,20);
        addPat.add(f_N_label);
        JTextField f_N_text = new JTextField();
        f_N_text.setBounds(150,90,100,20);
        addPat.add(f_N_text);

        //sex
        JLabel S_label = new JLabel("Sex ");
        S_label.setBounds(30,120,100,20);
        addPat.add(S_label);
        JRadioButton malbtn = new JRadioButton("Male");
        ButtonGroup group = new ButtonGroup();
        malbtn.setBounds(150,120,80,20);
        JRadioButton femalbtn = new JRadioButton("Female");
        femalbtn.setBounds(210,120,80,20);
        JRadioButton otherbtn = new JRadioButton("other");
        otherbtn.setBounds(290,120,80,20);
        group.add(malbtn);
        group.add(femalbtn);
        group.add(otherbtn);
        addPat.add(femalbtn);
        addPat.add(malbtn);
        addPat.add(otherbtn);
        String sex = "";
        if( malbtn.isSelected()){
            sex = "Male";
        }
        else if( femalbtn.isSelected()){
            sex = "Female";
        }
        else if( otherbtn.isSelected()){
            sex = "Other";
        }

        //Doctor Name
        JLabel doc_label = new JLabel("Dcotor Name ");
        doc_label.setBounds(30,150,100,20);
        addPat.add(doc_label);

        List<String> values = retrieveValuesFromDatabase_doc();
// Retrieve values from the database and store them in a list

        // Create a DefaultComboBoxModel and add the values to it
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (int i = 0; i < values.size(); i++) {
            model.addElement(values.get(i));
        }

        // Create the JComboBox and set its model
        JComboBox comboBox = new JComboBox(model);

        // Add the combo box to your GUI
        comboBox.setBounds(150,150,100,40);
        addPat.add(comboBox);

        //Disease History

        JLabel d_h_label = new JLabel("Disease ");
        d_h_label.setBounds(30,200,80,20);
        addPat.add(d_h_label);
        JTextField d_h_text = new JTextField();
        d_h_text.setBounds(150,200,100,20);
        addPat.add(d_h_text);

        //Prescription
        JLabel P_label = new JLabel("Prescription ");
        P_label.setBounds(30,230,80,20);
        addPat.add(P_label);
        JTextField P_text = new JTextField();
        P_text.setBounds(150,230,200,40);
        addPat.add(P_text);

        JButton savebtn2,cancelbtn2;
        savebtn2 = new JButton("Save");
        savebtn2.setBounds(130,300,100,20);
        addPat.add(savebtn2);
        cancelbtn2 = new JButton("Cancel");
        cancelbtn2.setBounds(240,300,100,20);
        addPat.add(cancelbtn2);
        String finalSex = sex;
        savebtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String I_D = "insert into patient_info (Doctor_ID,Doctor_Name,PF_Name,Sex,Doctor_ID,Disease_History,Prescription) values (?,?,?,?,?,?,?)";
                PreparedStatement stmtpatient = null;
                String comboint = (String) comboBox.getSelectedItem();//This line of code returns the the thing that is selected in the jcombobox
                int getid = 0;
                try {
                    getid =  storeIDinDiseaseinfo(comboint);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                        stmtpatient = con.prepareStatement(I_D);

                    stmtpatient.setString(2, nametext.getText());
                    stmtpatient.setString(1, (String) comboBox.getSelectedItem());
                    stmtpatient.setString(3,f_N_text.getText() );
                    stmtpatient.setString(4, finalSex);
                    stmtpatient.setString(6, d_h_text.getText());
                    stmtpatient.setString(7, P_text.getText());

                    stmtpatient.setInt(5, getid);
                    nametext.setText("");
                    idtext.setText("");
                    f_N_text.setText("");
                    d_h_text.setText("");
                    P_text.setText("");
                    stmtpatient.executeUpdate();

                    mainPanel.add(homePanel, "home");
                    layout.show(mainPanel, "home");

                    mainPanel.add(addPat, "Doctor Panel");
                    layout.show(mainPanel, "Doctor Panel");

                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                manage(mainPanel,homePanel);

            }
        });
        cancelbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(homePanel,"home");
                layout.show(mainPanel,"home");
            }
        });


        mainFrame.setVisible(true);

    }


    void add_Dcotor( JPanel add_Docpanel,JPanel mainPanel) throws SQLException {

//title
        JLabel title1 = new JLabel("ADD Doctor ");
        title1.setBounds(200,2,80,30);
        add_Docpanel.add(title1);

        //Name
        JLabel namelabel = new JLabel("Doctor Name ");
        namelabel.setBounds(30,30,80,20);
        add_Docpanel.add(namelabel);

        JTextField nametext = new JTextField();
        nametext.setBounds(150,30,200,20);
        add_Docpanel.add(nametext);

        //idTable
        JLabel idlabel = new JLabel("Doctor ID ");
        idlabel.setBounds(30,60,80,20);
        add_Docpanel.add(idlabel);

        //Retriving id from doctor table

        int getid = 0;

            String idQuery = "select * FROM doctor_info";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(idQuery);
            int i = 1;
            while (set.next()) {
                getid = set.getInt("Doctor_ID");
                i++;
            }
            getid++;




        JTextField idtext = new JTextField(getid);
        idtext.setText(String.valueOf(getid));
        idtext.setBounds(150,60,200,20);
        add_Docpanel.add(idtext);


        JLabel desi_label = new JLabel("Diseases Name: ");
        desi_label.setBounds(30,120,100,40);
        add_Docpanel.add(desi_label);

        List<String> values = retrieveValuesFromDatabase_dise();
// Retrieve values from the database and store them in a list

    // Create a DefaultComboBoxModel and add the values to it
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (i = 0; i < values.size(); i++) {
            model.addElement(values.get(i));
        }

        // Create the JComboBox and set its model
        JComboBox comboBox = new JComboBox(model);

        // Add the combo box to your GUI
        comboBox.setBounds(150,120,100,40);
   add_Docpanel.add(comboBox);
        JButton savebtn1,cancelbtn1;
        savebtn1 = new JButton("Save");
        savebtn1.setBounds(150,250,100,40);
        cancelbtn1 = new JButton("cancel");
        cancelbtn1.setBounds(260,250,100,40);
        add_Docpanel.add(savebtn1);
        add_Docpanel.add(cancelbtn1);

        int finalId = 0;
        savebtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String I_D = "insert into doctor_info (Doctor_Name,Disease_ID) values (?, ?)";
                PreparedStatement stmt = null;
                String comboint = (String) comboBox.getSelectedItem();//This line of code returns the the thing that is selected in the jcombobox
                int getid = 0;
                try {
                   getid =  storeIDinDiseaseinfo(comboint);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                try {
                    stmt = con.prepareStatement(I_D);
                    stmt.setString(1, nametext.getText());
                    stmt.setInt(2, getid);
                    nametext.setText("");
                    stmt.executeUpdate();

                    mainPanel.add(homePanel,"home");
                    layout.show(mainPanel,"home");

                    mainPanel.add(add_Docpanel,"Doctor Panel");
                    layout.show(mainPanel,"Doctor Panel");

                    add_Dcotor(add_Docpanel,mainPanel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        cancelbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(homePanel,"home");
                layout.show(mainPanel,"home");
            }
        });

        mainFrame.setVisible(true);

    }


}