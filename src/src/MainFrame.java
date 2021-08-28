package src;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Cris John Alonzaga
 */
public class MainFrame extends javax.swing.JFrame {
    
    private Timer time;
    private int num_rows , diseases_rows, selectedrow;
    private int patient_numrows;
    //private final CheckBoxEventPatient patientEvt = new CheckBoxEventPatient();
    private final ButtonGroup grp = new ButtonGroup();
    private final ArrayList<Integer> ids = new ArrayList<>();
    //String URL for search online , patientname for combox autocomplete
    private String url , patientname;
    private HashMap<String , Integer > dis_map = new HashMap<>();
    private ArrayList<Integer> diseaseId = new ArrayList<>();
    //private HashMap<String , Integer > patient_map  = new HashMap<>();
    //private final CheckBoxEventPatient delP = new CheckBoxEventPatient();
    private final DiseaseSymptomsHashMapData dshmd = new DiseaseSymptomsHashMapData();
    
    private Boolean ifSelectedRow;

    public MainFrame() {
        initComponents();
        setTheDate();
        theTimer();
        layerPanels.removeAll();
        setupDynamicCheckBoxes();
        tabPanel.setEnabledAt(0, true);
        tabPanel.setEnabledAt(1, false);
        tabPanel.setEnabledAt(2, false);
        firstNextBtn.setEnabled(false);
        
        viewDetails.setEnabled(false);
        
        //Modal center
        showRecordsModal.setLocationRelativeTo(null);
        popupmodal.setLocationRelativeTo(null);
        
        enableButton();
        date_today.setEditable(false);
        id_field.setEditable(false);
        
        populateTableData();
        
        makeAutocomplete();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PatientListGroup = new javax.swing.ButtonGroup();
        popupmodal = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        causetextarea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        treatmenttextarea = new javax.swing.JTextArea();
        diseaselabel = new javax.swing.JLabel();
        moreinformationonline = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptiontextarea = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        showRecordsModal = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timelabel = new javax.swing.JLabel();
        clockLabel = new javax.swing.JLabel();
        layerPanels = new javax.swing.JLayeredPane();
        diagnosePanel = new javax.swing.JPanel();
        diagnoseDiseaseBTN = new javax.swing.JButton();
        saveRecord = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
        patient_info = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        owners_name_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        patient_name = new javax.swing.JTextField();
        pet_breed = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        firstNextBtn = new javax.swing.JButton();
        date_today = new javax.swing.JTextField();
        symptomsPanel = new javax.swing.JPanel();
        scrollSymptoms = new javax.swing.JScrollPane();
        symptomsScrollPanel = new javax.swing.JPanel();
        resetBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listposibledisease = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        patient_list_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkbox_patientlist_Panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableListPatients = new javax.swing.JTable();
        refresh_btn = new javax.swing.JButton();
        dateTo = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        fromDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id_field = new javax.swing.JTextField();
        name_field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        date_field = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        viewRecords = new javax.swing.JButton();
        viewDetails = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        startDiagnoses = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        patientlist_btn = new javax.swing.JMenuItem();

        popupmodal.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        popupmodal.setTitle("Disease Information");
        popupmodal.setLocation(new java.awt.Point(0, 0));
        popupmodal.setSize(new java.awt.Dimension(580, 580));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        causetextarea.setEditable(false);
        causetextarea.setBackground(new java.awt.Color(51, 51, 51));
        causetextarea.setColumns(20);
        causetextarea.setForeground(new java.awt.Color(204, 204, 204));
        causetextarea.setLineWrap(true);
        causetextarea.setRows(5);
        causetextarea.setTabSize(1);
        jScrollPane4.setViewportView(causetextarea);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        treatmenttextarea.setEditable(false);
        treatmenttextarea.setBackground(new java.awt.Color(51, 51, 51));
        treatmenttextarea.setColumns(20);
        treatmenttextarea.setForeground(new java.awt.Color(204, 204, 204));
        treatmenttextarea.setLineWrap(true);
        treatmenttextarea.setRows(5);
        jScrollPane5.setViewportView(treatmenttextarea);

        diseaselabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diseaselabel.setForeground(new java.awt.Color(255, 255, 255));

        moreinformationonline.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        moreinformationonline.setForeground(new java.awt.Color(102, 153, 255));
        moreinformationonline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moreinformationonline.setText("Click Here For More Info Online");
        moreinformationonline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moreinformationonline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreinformationonlineMouseClicked(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descriptiontextarea.setEditable(false);
        descriptiontextarea.setBackground(new java.awt.Color(51, 51, 51));
        descriptiontextarea.setColumns(20);
        descriptiontextarea.setForeground(new java.awt.Color(204, 204, 204));
        descriptiontextarea.setLineWrap(true);
        descriptiontextarea.setRows(5);
        descriptiontextarea.setTabSize(1);
        jScrollPane3.setViewportView(descriptiontextarea);

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Treatment Information:");

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("What causes the illness?");

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Disease information: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(diseaselabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(moreinformationonline, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moreinformationonline, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diseaselabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout popupmodalLayout = new javax.swing.GroupLayout(popupmodal.getContentPane());
        popupmodal.getContentPane().setLayout(popupmodalLayout);
        popupmodalLayout.setHorizontalGroup(
            popupmodalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        popupmodalLayout.setVerticalGroup(
            popupmodalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        showRecordsModal.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        showRecordsModal.setTitle("Patient Records");
        showRecordsModal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        showRecordsModal.setLocation(new java.awt.Point(0, 0));
        showRecordsModal.setSize(new java.awt.Dimension(450, 300));

        jLabel15.setText("Some Records Here");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout showRecordsModalLayout = new javax.swing.GroupLayout(showRecordsModal.getContentPane());
        showRecordsModal.getContentPane().setLayout(showRecordsModalLayout);
        showRecordsModalLayout.setHorizontalGroup(
            showRecordsModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        showRecordsModalLayout.setVerticalGroup(
            showRecordsModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medical Diagnoses for Dog Diseases");
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("System Date and Time:");

        timelabel.setBackground(new java.awt.Color(102, 102, 102));
        timelabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        timelabel.setForeground(new java.awt.Color(204, 204, 204));
        timelabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timelabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        clockLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        clockLabel.setForeground(new java.awt.Color(204, 204, 204));
        clockLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timelabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layerPanels.setLayout(new java.awt.CardLayout());

        diagnosePanel.setBackground(new java.awt.Color(51, 51, 51));

        diagnoseDiseaseBTN.setText("Diagnose");
        diagnoseDiseaseBTN.setBorderPainted(false);
        diagnoseDiseaseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnoseDiseaseBTNActionPerformed(evt);
            }
        });

        saveRecord.setText("Save Record");
        saveRecord.setBorderPainted(false);
        saveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRecordActionPerformed(evt);
            }
        });

        patient_info.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Owner's Full Name: ");

        jLabel3.setText("Patient Name:");

        pet_breed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Breed...", "Aspin", "Labrador", "Chitzu", "Poodle", "Pomeranian", "Ayam Buang" }));

        jLabel4.setText("Date:");

        firstNextBtn.setText("Next");
        firstNextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patient_infoLayout = new javax.swing.GroupLayout(patient_info);
        patient_info.setLayout(patient_infoLayout);
        patient_infoLayout.setHorizontalGroup(
            patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pet_breed, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patient_infoLayout.createSequentialGroup()
                            .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patient_infoLayout.createSequentialGroup()
                                    .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(patient_infoLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)))
                            .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(owners_name_field)
                                .addComponent(patient_name, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addComponent(date_today))))
                    .addComponent(firstNextBtn))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        patient_infoLayout.setVerticalGroup(
            patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_infoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(owners_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(patient_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patient_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(date_today, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(pet_breed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(firstNextBtn)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        tabPanel.addTab("Patient Informations", patient_info);

        symptomsPanel.setBackground(new java.awt.Color(153, 153, 153));
        symptomsPanel.setEnabled(false);

        scrollSymptoms.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        symptomsScrollPanel.setLayout(new java.awt.GridLayout(this.getNumRows(), 1));
        scrollSymptoms.setViewportView(symptomsScrollPanel);

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout symptomsPanelLayout = new javax.swing.GroupLayout(symptomsPanel);
        symptomsPanel.setLayout(symptomsPanelLayout);
        symptomsPanelLayout.setHorizontalGroup(
            symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symptomsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollSymptoms)
                    .addGroup(symptomsPanelLayout.createSequentialGroup()
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 549, Short.MAX_VALUE)))
                .addContainerGap())
        );
        symptomsPanelLayout.setVerticalGroup(
            symptomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, symptomsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSymptoms, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPanel.addTab("Symptoms", symptomsPanel);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("Consolas", 2, 14)); // NOI18N
        jLabel5.setText("These are the posible illnesses base from checked symptoms:");

        listposibledisease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listposiblediseaseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listposibledisease);

        jLabel8.setText("Please double click disease name for more information");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 160, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        tabPanel.addTab("Posible Diseases", jPanel6);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagnosePanelLayout = new javax.swing.GroupLayout(diagnosePanel);
        diagnosePanel.setLayout(diagnosePanelLayout);
        diagnosePanelLayout.setHorizontalGroup(
            diagnosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagnosePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagnosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diagnoseDiseaseBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveRecord, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(tabPanel)
                .addContainerGap())
        );
        diagnosePanelLayout.setVerticalGroup(
            diagnosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagnosePanelLayout.createSequentialGroup()
                .addGroup(diagnosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diagnosePanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(diagnoseDiseaseBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(diagnosePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        layerPanels.add(diagnosePanel, "card2");

        patient_list_Panel.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        checkbox_patientlist_Panel.setLayout(new java.awt.GridLayout(this.patient_numrows, 1));

        tableListPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        tableListPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListPatientsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableListPatients);

        checkbox_patientlist_Panel.add(jScrollPane6);

        jScrollPane1.setViewportView(checkbox_patientlist_Panel);

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });

        dateTo.setDateFormatString("yyyy- MM - d");

        jButton3.setText("Filter By Date");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        fromDate.setDateFormatString("yyyy- MM - d");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("to");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("From:");

        jButton1.setText("Clear");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID :");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NAME :");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DATE :");

        jButton4.setText("DELETE");

        jButton5.setText("EDIT");

        viewRecords.setText("VIEW RECORDS");
        viewRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRecordsActionPerformed(evt);
            }
        });

        viewDetails.setText("View Details");
        viewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patient_list_PanelLayout = new javax.swing.GroupLayout(patient_list_Panel);
        patient_list_Panel.setLayout(patient_list_PanelLayout);
        patient_list_PanelLayout.setHorizontalGroup(
            patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patient_list_PanelLayout.createSequentialGroup()
                .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patient_list_PanelLayout.createSequentialGroup()
                        .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_field, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(name_field)
                            .addComponent(date_field)))
                    .addGroup(patient_list_PanelLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewRecords)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35)
                .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewDetails)
                    .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(patient_list_PanelLayout.createSequentialGroup()
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(refresh_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, patient_list_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(122, 122, 122))
        );
        patient_list_PanelLayout.setVerticalGroup(
            patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_list_PanelLayout.createSequentialGroup()
                .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(refresh_btn)
                    .addComponent(jButton1)
                    .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patient_list_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(patient_list_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(viewRecords))
                        .addGap(234, 234, 234))
                    .addGroup(patient_list_PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewDetails)
                        .addContainerGap())))
        );

        layerPanels.add(patient_list_Panel, "card4");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layerPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layerPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Start");

        startDiagnoses.setText("New Diagnoses");
        startDiagnoses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDiagnosesActionPerformed(evt);
            }
        });
        jMenu1.add(startDiagnoses);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("About");
        jMenuBar1.add(jMenu3);

        jMenu2.setText("Settings");

        jMenuItem1.setText("Manage Diseases");
        jMenu2.add(jMenuItem1);

        jMenuItem4.setText("Manage Symptoms");
        jMenu2.add(jMenuItem4);

        patientlist_btn.setText("Patient List");
        patientlist_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientlist_btnActionPerformed(evt);
            }
        });
        jMenu2.add(patientlist_btn);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startDiagnosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDiagnosesActionPerformed
        layerPanels.setVisible(true);
        switchPanels(diagnosePanel);
    }//GEN-LAST:event_startDiagnosesActionPerformed

    private void diagnoseDiseaseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnoseDiseaseBTNActionPerformed
        DataBaseQueries inf = new DataBaseQueries();
        try {
            if(!this.ids.isEmpty()){
                inf.generatePosibleDiseases(ids);
                System.out.println(inf.preventDuplicates());
                setFinalRowDiseases(inf.preventDuplicates().size());
                showFinalDiagnoses(inf.preventDuplicates());
                //System.out.println(inf.getDiseasesMapping());
                this.dis_map = inf.getDiseasesMapping();
                setDiseaseIdToSave(this.dis_map);
                
                
                listposibledisease.setEnabled(true);
                tabPanel.setEnabledAt(2, true);
                tabPanel.setSelectedIndex(2);
            }
            else{
                showPopUpMessage("Please select symptoms first?");
            }
            //System.out.println(inf.getDiseasesMapping());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_diagnoseDiseaseBTNActionPerformed
    public void setDiseaseIdToSave(HashMap<String, Integer> dis){
        for(String disease : dis.keySet()){
            this.diseaseId.add(dis.get(disease));
        }
    }
    public ArrayList<Integer> getDiseaseIdToSave(){
        return this.diseaseId;
    }
    //Method setters and getters for disease id from HashMap
    //Disease id to be use for database table diagnose_disease column id 
    
    //-------------------------
    public void showFinalDiagnoses(ArrayList<String> str){
        int num = str.size();
        DefaultListModel model = new DefaultListModel();
        for(int i = 0 ; i < num ; i++){
            model.addElement(str.get(i));
        }
        
        listposibledisease.setModel(model);
    }
    public void showPopUpMessage(String msg){
        //JOptionPane modal = new JOptionPane();
        JOptionPane.showMessageDialog(null,msg);
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void patientlist_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientlist_btnActionPerformed
        layerPanels.setVisible(true);
        switchPanels(patient_list_Panel);
    }//GEN-LAST:event_patientlist_btnActionPerformed

    //---------------end patient-----------------//
    
    private void firstNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNextBtnActionPerformed
         tabPanel.setEnabledAt(1, true);
         tabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_firstNextBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
       symptomsScrollPanel.removeAll();
       setupDynamicCheckBoxes();
       //SymptomsData data = new SymptomsData();
       this.ids.clear();
       //clearFinalDiagnoses();
       listposibledisease.setEnabled(false);
       System.out.println(ids);
       dshmd.getSymptomsKeyValues().clear();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void listposiblediseaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listposiblediseaseMouseClicked
       if(evt.getClickCount() == 2){
           try {
               DataBaseQueries datas = new DataBaseQueries();
               String name = listposibledisease.getSelectedValue();
               
               String id = getDiseaseMapping().get(name).toString();
              
               HyperLinkLabel link = new HyperLinkLabel();
               
               link.setLinkDisease(name);
               setTheURI(link.getLinkOfDisease());
               
               datas.queryDiseaseInformation(id);
               
               diseaselabel.setText(datas.getDisease());
               descriptiontextarea.setText(datas.getDiseaseDescription());
               causetextarea.setText(datas.getDiseaseCause());
               treatmenttextarea.setText(datas.getDiseaseTreatment());
               popupmodal.setVisible(true);
               
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_listposiblediseaseMouseClicked
    public HashMap<String , Integer> getDiseaseMapping(){
        return this.dis_map;
    }
    private void moreinformationonlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moreinformationonlineMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com/search?q="+getTheURI()));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_moreinformationonlineMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
       
       QueriesFilterSearch filter = new QueriesFilterSearch();
       
       String[] column = {"ID", "Owners Name", "Date"};
       DefaultTableModel model = new DefaultTableModel(column, 0){
           @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
       };
       
       if(fromDate.getDate() != null && dateTo != null){
         
           String from = sdf.format(fromDate.getDate());
           String to = sdf.format(dateTo.getDate());
           
           if(!"".equals(from) && !"".equals(to)){
                filter.getFilterData(from, to);
               
                Object rowData[][] = filter.getpopulatableJTable();
        
                for (Object[] rowDatas : rowData) {
                    model.addRow(rowDatas);
                }

                tableListPatients.setModel(model);
                settingTableRowsSize();
   
           }
           
       } 
       else {
           showPopUpMessage("Please enter date..");
       }     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void saveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRecordActionPerformed
        DataBaseQueries dbq = new DataBaseQueries();
        ArrayList<String> p_info = new ArrayList<>();
        
        String choosen = pet_breed.getSelectedItem().toString();
        
        if(!"".equals(owners_name_field.getText()) && !"".equals(patient_name.getText()) && !getDiseaseIdToSave().isEmpty()){
            String name = owners_name_field.getText();
            boolean ifuserexist = dbq.checkIfUserExist(name);
            //System.out.println(ifuserexist);
            if(!"Choose Breed...".equals(choosen)){
                if(ifuserexist != true){
                    p_info.add(owners_name_field.getText());
                    p_info.add(patient_name.getText());
                    p_info.add(choosen);
                    dbq.insertDataRecords(p_info);
                    dbq.insertDataRecords(dshmd.getSymptomsKeyValues());
                    dbq.saveDiagnoseData(this.diseaseId);
                    showPopUpMessage("Diagnosed data and patient information saved!");
                }
                else{
                    dbq.insertDataRecords(dshmd.getSymptomsKeyValues());
                    dbq.saveDiagnoseData(this.diseaseId);
                    showPopUpMessage("Diagnosed data and patient information saved!");
                }
            }
            else{
                showPopUpMessage("Please choose a breed?");
            }
        }
        else{
            showPopUpMessage("No symptoms selected please select atleast one?");
        }
        System.out.println(ids);
    }//GEN-LAST:event_saveRecordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        resetClearInputDatas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        populateTableData();
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String[] column = {"ID","Owners Name", "Date"};
        DefaultTableModel model = new DefaultTableModel(column, 0){
            //disable button editing removing this will cause out of bounds error 
            //this code can be found on method populateTableData()
            //getting Vector data on method getJTableRowDatas
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        QueriesFilterSearch filter = new QueriesFilterSearch();
        
        if(!"".equals(searchField.getText())){
            String name = searchField.getText();
            filter.getFilterData(name);
            
            Object[][] datas = filter.getpopulatableJTable();
            
            for (Object[] rowDatas : datas) {
                model.addRow(rowDatas);
            }
            
            tableListPatients.setModel(model);
            settingTableRowsSize();
        }
        else{
            showPopUpMessage("Please enter owners name");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void tableListPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListPatientsMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableListPatients.getModel();
        
        this.selectedrow =  tableListPatients.getSelectedRow();
        
        id_field.setText(model.getValueAt(this.selectedrow, 0).toString());
        name_field.setText(model.getValueAt(this.selectedrow, 1).toString());
        date_field.setText(model.getValueAt(this.selectedrow, 2).toString());
        
    }//GEN-LAST:event_tableListPatientsMouseClicked
    
    private void viewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsActionPerformed
       if(this.selectedrow > -1){
           
           showRecordsModal.setVisible(true);
       }
       else{
           showPopUpMessage("Please select patient row");
       }
    }//GEN-LAST:event_viewDetailsActionPerformed

    private void viewRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRecordsActionPerformed
        QueriesFilterSearch qfs = new QueriesFilterSearch();
        viewDetails.setEnabled(true);
        String[] column = {"ID","Owners Name", "Diagnose Date"};
        DefaultTableModel model = new DefaultTableModel(column, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        if(!"".equals(id_field.getText())){
            qfs.personsTableData(id_field.getText());
            this.selectedrow = -1;
            Object[][] datas = qfs.getpopulatableJTable();
            if(datas != null){
                for (Object[] rowDatas : datas) {
                    model.addRow(rowDatas);
                }
                tableListPatients.setModel(model);
                settingTableRowsSize();
            }
        }
    }//GEN-LAST:event_viewRecordsActionPerformed
    
    public void refreshSelectedRow(){
        
    }
    
    public void setTheURI(String url){
        this.url = url;
    }
    public String getTheURI(){
        return this.url;
    } 
    
    public final void setTheDate(){
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int day = date.getDayOfMonth();
        String month = date.getMonth().toString().toLowerCase();
        String m = month.substring(0,1).toUpperCase() + month.substring(1);
        String thedate = ""+m+", "+day+" "+year;
        timelabel.setText(thedate);
        date_today.setText(thedate);
    }
    
    public void switchPanels(JPanel panel){
        layerPanels.removeAll();
        layerPanels.add(panel);
        layerPanels.repaint();
        layerPanels.revalidate();
    }
    
    public final void theTimer(){
        SystemClock clk = new SystemClock();
        int delay = 1000;
        
        ActionListener taskPerform = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clk.setTimeNow();
                clockLabel.setText(clk.getTheTime());
            }
        };
        time = new Timer(delay, taskPerform);
        time.setRepeats(true);
        time.start();
    }
    
    //Set up dynamic checkbox for symptoms list
    public final void setupDynamicCheckBoxes(){
        TestDataBaseConnection test = new TestDataBaseConnection();
        //HyperLinkLabel data = new HyperLinkLabel();
        test.testConnection();
        int num = test.getSymptoms().size();
        setNumRows(num);
        JCheckBox[] checkboxes = new JCheckBox[num];
        //System.out.println(checkboxes.length);
        for(int i=0; i<checkboxes.length; i++){
            //System.out.println(test.getSymptoms().get(i));
            checkboxes[i] = new JCheckBox(test.getSymptoms().get(i));
            //.setText(test.getSymptoms().get(i));
            //data.setActionForSymptomsCheckBoxes(checkboxes[i]);
            setActionSymptomsCheckbox(checkboxes[i]);
            symptomsScrollPanel.add(checkboxes[i]);
            symptomsScrollPanel.repaint();
            symptomsScrollPanel.revalidate();
        }
    }
    
    //-------------functionality method to call if user clear everything----//
    public void resetClearInputDatas(){
        owners_name_field.setText("");
        patient_name.setText("");
        pet_breed.setSelectedIndex(0);
        this.ids.clear();
        listposibledisease.removeAll();
        tabPanel.setSelectedIndex(0);
        tabPanel.setEnabledAt(1, false);
        tabPanel.setEnabledAt(2, false);
        symptomsScrollPanel.removeAll();
        setupDynamicCheckBoxes();
    }
    //-----------end here ---------------//
    
    //----------------------------------------------------------
    public void setActionSymptomsCheckbox(JCheckBox checkbox){
        //DiseaseSymptomsHashMapData dshm =new DiseaseSymptomsHashMapData();
        checkbox.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange() == 1){
                   try {
                       setCheckString(checkbox.getText());
                       dshmd.pullOutString(checkbox.getText());
                       //System.out.println(dshmd.getSymptomsKeyValues());
                   } catch (ClassNotFoundException | SQLException ex) {
                       Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else{
                   removeSymptomsIdFromList(checkbox.getText());
               }
            }
        });
    }
    
    public void setCheckString(String name){
        DataBaseQueries symp = new DataBaseQueries();
        try {
            int symptoms = symp.getSymptomsId(name);
            ids.add(symptoms);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeSymptomsIdFromList(String name){
        DataBaseQueries symp = new DataBaseQueries();
        try {
            int symptoms = symp.getSymptomsId(name);
            int index = this.ids.indexOf(symptoms);
            ids.remove(index);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------------------------------------------
    
    //-----------Method for autocomplete textfield ---------------//
    public void makeTextFieldAutoComplete(JTextField txtfields){
        ArrayList<String> items;
        
        DataBaseQueries dbq = new DataBaseQueries();
        items = dbq.returnTextFromDataBase();
        
        boolean strictMatching = false;
        
        AutoCompleteDecorator.decorate(txtfields, items, strictMatching);
        
        txtfields.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE ){
                    //txtfields.setText("");
                    owners_name_field.setText("");
                    patient_name.setText("");
                    searchField.setText("");
                    pet_breed.setSelectedIndex(0);
                    //showPopUpMessage("Please enter patient information");
                }
                else if(e.getKeyChar() == KeyEvent.VK_ENTER && !"".equals(txtfields.getText())){
                    populateIfUserExist(dbq.populateFormFields(txtfields.getText()));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    public final void makeAutocomplete(){
        makeTextFieldAutoComplete(owners_name_field);
        makeTextFieldAutoComplete(searchField);
    }
    
    // -------------End of autocomplete textfield------------------//
    
    
    // Set Text data if user press enter key populate form if user already exist
    public void populateIfUserExist(String[] patient_datas){
        patient_name.setText(patient_datas[1]);
        for(int i = 0 ; i < pet_breed.getItemCount() ; i++){
            if(pet_breed.getItemAt(i).equals(patient_datas[2])){
                pet_breed.setSelectedIndex(i);
                
                break;
            }
        }
    }
    
    public final void enableButton(){
         getTextField(owners_name_field);
         getTextField(patient_name);
         makeTextFieldAutoComplete(owners_name_field);
    }
   
   public void getTextField(JTextField field){
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
              checkTextFieldIsBlank();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTextFieldIsBlank();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTextFieldIsBlank();
            }
        });
    }
   
    public void checkTextFieldIsBlank(){
        boolean bool, bool1;
        bool = !owners_name_field.getText().equals("");
        bool1 = !patient_name.getText().equals(""); 
        String breed = pet_breed.getSelectedItem().toString();
        if(bool && bool1){
            firstNextBtn.setEnabled(true);
        }
        else{
            firstNextBtn.setEnabled(false);
        }
    }
    //------------------------------------------------
    
    //Populating JTable from database
    public final void populateTableData(){
        String[] column = {"ID", "Owners Name" , "Date"};
        DefaultTableModel model = new DefaultTableModel(column, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        QueriesFilterSearch datas = new QueriesFilterSearch();
        Object rowData[][] = datas.populateTableData();
        
        for (Object[] rowDatas : rowData) {
            model.addRow(rowDatas);
        }
        
        tableListPatients.setModel(model);
        settingTableRowsSize();
    }
    public void settingTableRowsSize(){
        tableListPatients.getColumnModel().getColumn(0).setPreferredWidth(1);
        tableListPatients.getColumnModel().getColumn(1).setPreferredWidth(250);
        tableListPatients.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    // ---End
    
    //For Dynamic grid row layout
    public void setFinalRowDiseases(int row){
        this.diseases_rows = row;
    }
    public int getFinalRowDiseases(){
        return this.diseases_rows;
    }
    public void setNumRows(int rows){
        this.num_rows = rows;
    }
    public int getNumRows(){
        return this.num_rows;
    }
    public void setPatientNumRows(int pnum_rows){
        this.patient_numrows = pnum_rows;
    }
    public int getPatientNumRows(){
        return this.patient_numrows;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup PatientListGroup;
    private javax.swing.JTextArea causetextarea;
    private javax.swing.JPanel checkbox_patientlist_Panel;
    private javax.swing.JLabel clockLabel;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JTextField date_field;
    private javax.swing.JTextField date_today;
    private javax.swing.JTextArea descriptiontextarea;
    private javax.swing.JButton diagnoseDiseaseBTN;
    private javax.swing.JPanel diagnosePanel;
    private javax.swing.JLabel diseaselabel;
    private javax.swing.JButton firstNextBtn;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JTextField id_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLayeredPane layerPanels;
    private javax.swing.JList<String> listposibledisease;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel moreinformationonline;
    private javax.swing.JTextField name_field;
    private javax.swing.JTextField owners_name_field;
    private javax.swing.JPanel patient_info;
    private javax.swing.JPanel patient_list_Panel;
    private javax.swing.JTextField patient_name;
    private javax.swing.JMenuItem patientlist_btn;
    private javax.swing.JComboBox<String> pet_breed;
    private javax.swing.JDialog popupmodal;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveRecord;
    private javax.swing.JScrollPane scrollSymptoms;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JDialog showRecordsModal;
    private javax.swing.JMenuItem startDiagnoses;
    private javax.swing.JPanel symptomsPanel;
    private javax.swing.JPanel symptomsScrollPanel;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable tableListPatients;
    private javax.swing.JLabel timelabel;
    private javax.swing.JTextArea treatmenttextarea;
    private javax.swing.JButton viewDetails;
    private javax.swing.JButton viewRecords;
    // End of variables declaration//GEN-END:variables
}
