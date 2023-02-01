//Bernard Franco Ramiscal

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class frmViewCargoo extends javax.swing.JFrame {
    static Connection con = null;
    static PreparedStatement stmnt = null;
    static ResultSet rs = null;
    static Statement st = null;
    private String selectedItem = null;
   
    public frmViewCargoo() {
        initComponents();
        findCargoInfo();
        showCargoInTable(query);
        ShowTable();
        SetIcon();
    }
    frmShowDetails jtRowData = new frmShowDetails();
    
    String query = "SELECT * FROM `tbl_cargo1`";
    public  Connection getConnetion(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/franz","root","root");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }

    public ArrayList<Cargo>ListCargo(String ValToSearch){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        String searchQuery = "SELECT * FROM `tbl_cargo1` WHERE CONCAT(`id`, `s_name`, `r_name`, `trackingno`, `typeofcargo`, `origin`, `destination`)LIKE '%"+ValToSearch+"%'";
        try{
            
            st=con.createStatement();
            rs = st.executeQuery(searchQuery);
            
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void findCargoInfo(){
        if(this.Search.getSelectedItem().toString().equals("All")){
        ArrayList<Cargo> cargo = ListCargo(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
}
    public ArrayList<Cargo>SenderName(String ValToSearch){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        String searchQuery = "SELECT * FROM `tbl_cargo1` WHERE CONCAT(`s_name`)LIKE '%"+ValToSearch+"%'";
        try{
            Connection  con = getConnetion();
            st=con.createStatement();
            rs = st.executeQuery(searchQuery);
            
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void SenderName(){
        if(this.Search.getSelectedItem().toString().equals("Sender Name")){
        ArrayList<Cargo> cargo = SenderName(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
}
    public ArrayList<Cargo>RecieverName(String ValToSearch){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        String searchQuery = "SELECT * FROM `tbl_cargo1` WHERE CONCAT(`r_name`)LIKE '%"+ValToSearch+"%'";
        try{
            
            st=con.createStatement();
            rs = st.executeQuery(searchQuery);
            
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void RecieverName(){
        if(this.Search.getSelectedItem().toString().equals("Reciever Name")){
        ArrayList<Cargo> cargo = RecieverName(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
}
    public ArrayList<Cargo>TrackingNo(String ValToSearch){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        String searchQuery = "SELECT * FROM `tbl_cargo1` WHERE CONCAT(`trackingno`)LIKE '%"+ValToSearch+"%'";
        try{
            Connection  con = getConnetion();
            st=con.createStatement();
            rs = st.executeQuery(searchQuery);
            
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void TrackingNo(){
        if(this.Search.getSelectedItem().toString().equals("Tracking No.")){
        ArrayList<Cargo> cargo = TrackingNo(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
}
    public ArrayList<Cargo>Origin(String ValToSearch){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        String searchQuery = "SELECT * FROM `tbl_cargo1` WHERE CONCAT(`origin`)LIKE '%"+ValToSearch+"%'";
        try{
            Connection  con = getConnetion();
            st=con.createStatement();
            rs = st.executeQuery(searchQuery);
            
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void Origin(){
        if(this.Search.getSelectedItem().toString().equals("Origin")){
        ArrayList<Cargo> cargo = Origin(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
}
    public ArrayList<Cargo>Destination(String ValToSearch){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        String searchQuery = "SELECT * FROM `tbl_cargo1` WHERE CONCAT(`destination`)LIKE '%"+ValToSearch+"%'";
        try{
            Connection  con = getConnetion();
            st=con.createStatement();
            rs = st.executeQuery(searchQuery);
            
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void Destination(){
        if(this.Search.getSelectedItem().toString().equals("Destination")){
        ArrayList<Cargo> cargo = Destination(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
}
    public ArrayList<Cargo>SortCargo(String query){
        ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
        Statement st;
        ResultSet rs;
        try{
            Connection  con = getConnetion();
            st=con.createStatement();
            rs = st.executeQuery(query);
            Cargo cargo;
            while(rs.next()){
                cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("s_name"),
                 rs.getString("r_name"),
                  rs.getString("trackingno"),
                   rs.getString("typeofcargo"),
                    rs.getString("origin"),
                     rs.getString("destination")
                   );
                     cargoList.add(cargo);
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cargoList;
         }
    public void showCargoInTable(String OrderQuery){
        ArrayList<Cargo> cargo = SortCargo(OrderQuery);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Sender Name","Reciever Name","Tracking No","Type of Cargo", "Origin","Destination"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < cargo.size(); i++)
        {
            row[0] = cargo.get(i).getId();
            row[1] = cargo.get(i).getSendername();
            row[2] = cargo.get(i).getRecievername();
            row[3] = cargo.get(i).getTrackingno();
            row[4] = cargo.get(i).getTypeofcargo();
            row[5] = cargo.get(i).getOrigin();
            row[6] = cargo.get(i).getDestination();
            model.addRow(row);
        }
       tblCargo.setModel(model);
    }
    
    public ArrayList<Views> getMessage(){
        ArrayList<Views> messages = new ArrayList <Views>();
        String USER = "root";
        String PASS = "root";
        
        try{
            Connection conn  =DriverManager.getConnection("jdbc:mysql://localhost:3308/franz","root","root");
            Statement stmt = conn.createStatement();
            stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_cargo1` ORDER BY 's_name'");
            Views view;
            
            while(rs.next()){
                
                view = new Views(
                        rs.getInt("id"),
                        rs.getString("s_name"),
                        rs.getString("s_phone"),
                        rs.getString("s_email"),
                        rs.getString("s_address"),
                        rs.getString("r_name"),
                        rs.getString("r_phone"),
                        rs.getString("r_email"),
                        rs.getString("r_address"),
                        rs.getString("trackingno"),
                        rs.getString("typeofcargo"),
                        rs.getString("weight"),
                        rs.getString("depttime"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getString("pickupdate"),
                        rs.getString("pickuptime")
                );
                messages.add(view);
                
                }
        }catch(Exception error){
            System.out.println(error);
        }
        return messages;
    }
    
    private void ShowTable(){
        ArrayList<Views> show = getMessage();
        DefaultTableModel model = (DefaultTableModel)tblCargo.getModel();
        Object[] rowData = new Object[17];
        for(int i = 0; i < getMessage().size(); i++){
            
            rowData[0] = getMessage().get(i).getId();
            rowData[1] = getMessage().get(i).getSendername();
            //rowData[2] = getMessage().get(i).getSenderphone();
            //rowData[3] = getMessage().get(i).getSenderemail();
            //rowData[4] = getMessage().get(i).getSenderaddress();
            rowData[5] = getMessage().get(i).getRecievername();
            //rowData[6] = getMessage().get(i).getRecieverphone();
            //rowData[7] = getMessage().get(i).getRecieveremail();
            //rowData[8] = getMessage().get(i).getRecieveraddress();
            rowData[9] = getMessage().get(i).getTrackingno();
            rowData[10] = getMessage().get(i).getTypeofcargo();
            //rowData[11] = getMessage().get(i).getWeight();
            //rowData[12] = getMessage().get(i).getDepttime();
            rowData[13] = getMessage().get(i).getOrigin();
            rowData[14] = getMessage().get(i).getDestination();
            //rowData[15] = getMessage().get(i).getPickupdate();
            //rowData[16] = getMessage().get(i).getPickuptime();
               model.addRow(rowData);
               
               
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        Search = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnUpdateCargo = new javax.swing.JButton();
        btnCancelCargo = new javax.swing.JButton();
        btnAscending = new javax.swing.JButton();
        combSearchType = new javax.swing.JComboBox<>();
        btnviewdetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 0, 102));
        jPanel3.setForeground(new java.awt.Color(102, 255, 255));

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cargo ID", "Sender Name", "Reciver Name", "Tracking No", "Type of Cargo", "Origin", "Destination"
            }
        ));
        tblCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCargoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCargo);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search :");

        txtSearch.setToolTipText("");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconSearch.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        Search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Sender Name", "Reciever Name", "Tracking No.", "Origin", "Destination" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Search, 0, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        btnUpdateCargo.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdateCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconAdd.png"))); // NOI18N
        btnUpdateCargo.setText("Update");
        btnUpdateCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCargoActionPerformed(evt);
            }
        });

        btnCancelCargo.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCancel.png"))); // NOI18N
        btnCancelCargo.setText("Cancel Cargo");
        btnCancelCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCargoActionPerformed(evt);
            }
        });

        btnAscending.setText("Ascending");
        btnAscending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscendingActionPerformed(evt);
            }
        });

        combSearchType.setBackground(new java.awt.Color(255, 51, 51));
        combSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sender Name", "Reciever Name", "Tracking No.", "Type of Cargo", "Origin", "Destination" }));

        btnviewdetails.setText("View Details");
        btnviewdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewdetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAscending)
                        .addGap(18, 18, 18)
                        .addComponent(combSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnviewdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnUpdateCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelCargo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdateCargo)
                        .addComponent(btnAscending)
                        .addComponent(combSearchType)
                        .addComponent(btnviewdetails))
                    .addComponent(btnCancelCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCargoActionPerformed
            try{
                con = getConnetion();
                String sql = "DELETE FROM `tbl_cargo1` WHERE id = '"+selectedItem+"'";
                Statement stmnt = con.createStatement();
                stmnt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cargo canceled successfully", "Cancel Cargo", JOptionPane.INFORMATION_MESSAGE);
                findCargoInfo();
                }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Cargo cancelation failed", "Cancel Cargo", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_btnCancelCargoActionPerformed

    private void btnUpdateCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCargoActionPerformed
         try{
            con = getConnetion();
            String sql = "UPDATE `tbl_cargo1` SET `s_name`=?,`s_phone`=?,`s_email`=?,`s_address`=?,`r_name`=?,`r_phone`=?,`r_email`=?,`r_address`=?,`tracking#`=?,`typeofcargo`=?,`weight`=?,`depttime`=?,`origin`=?,`destination`=?,`pickupdate`=?,`pickuptime`=?  WHERE id='"+selectedItem+"'";
            Statement stmnt = con.createStatement();
                stmnt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cargo update successfully", "Cancel Cargo", JOptionPane.INFORMATION_MESSAGE);
                findCargoInfo();
             
         }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "Cancel Cargo", JOptionPane.ERROR_MESSAGE);
                }
         
        
    }//GEN-LAST:event_btnUpdateCargoActionPerformed
    private void tblCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargoMouseClicked
        try{
            if(tblCargo.getModel().getValueAt(0, 0)!=null){
                     this.btnCancelCargo.setEnabled(true);
                     this.btnviewdetails.setEnabled(true);
                  int row = tblCargo.getSelectedRow();
                 selectedItem = tblCargo.getModel().getValueAt(row, 0).toString();
                }
            }
        catch(ArrayIndexOutOfBoundsException e){
              this.btnCancelCargo.setEnabled(false);
              this.btnviewdetails.setEnabled(false);
            //do nothing
            }
    }//GEN-LAST:event_tblCargoMouseClicked
        
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            findCargoInfo();
            SenderName();
            RecieverName();
            TrackingNo();
            Origin();
            Destination();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
            findCargoInfo();
            SenderName();
            RecieverName();
            TrackingNo();
            Origin();
            Destination();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAscendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscendingActionPerformed
        if(this.combSearchType.getSelectedItem().toString().equals("Sender Name")){
            query = "SELECT * FROM `tbl_cargo1` ORDER BY s_name ASC";
        }
        if(this.combSearchType.getSelectedItem().toString().equals("Reciever Name")){
            query = "SELECT * FROM `tbl_cargo1` ORDER BY r_name ASC";
        }
        if(this.combSearchType.getSelectedItem().toString().equals("Tracking No.")){
            query = "SELECT * FROM `tbl_cargo1` ORDER BY trackingno ASC";
        }
        if(this.combSearchType.getSelectedItem().toString().equals("Type of Cargo")){
            query = "SELECT * FROM `tbl_cargo1` ORDER BY typeofcargo ASC";
        }
        if(this.combSearchType.getSelectedItem().toString().equals("Origin")){
            query = "SELECT * FROM `tbl_cargo1` ORDER BY origin ASC";
        }
        if(this.combSearchType.getSelectedItem().toString().equals("Destination")){
            query = "SELECT * FROM `tbl_cargo1` ORDER BY destination ASC";
        }
        showCargoInTable(query);
    }//GEN-LAST:event_btnAscendingActionPerformed

    private void btnviewdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewdetailsActionPerformed
        ShowTable();        
    }//GEN-LAST:event_btnviewdetailsActionPerformed

    private void tblCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargoMousePressed
       
        int i = tblCargo.getSelectedRow();
        TableModel model = tblCargo.getModel();
        
        String id = model.getValueAt(i, 0).toString();
        String sname = model.getValueAt(i, 1).toString();
        String sphone = model.getValueAt(i, 2).toString();
        String semail = model.getValueAt(i, 3).toString();
        String saddress = model.getValueAt(i, 4).toString();
        String rname = model.getValueAt(i, 5).toString();
        String rphone = model.getValueAt(i, 6).toString();
        String remail = model.getValueAt(i, 7).toString();
        String raddress = model.getValueAt(i, 8).toString();
        String trackingno = model.getValueAt(i, 9).toString();
        String typeofcargo = model.getValueAt(i, 10).toString();
        String weight = model.getValueAt(i, 11).toString();
        String depttime = model.getValueAt(i, 12).toString();
        String origin = model.getValueAt(i, 13).toString();
        String destination = model.getValueAt(i, 14).toString();
        String pickupdate = model.getValueAt(i, 15).toString();
        String pickuptime = model.getValueAt(i, 16).toString();
        
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setLocationRelativeTo(null);
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.sname.setText(sname);
        jtRowData.sphone.setText(sphone);
        jtRowData.semail.setText(semail);
        jtRowData.saddress.setText(saddress);
        jtRowData.rname.setText(rname);
        jtRowData.rphone.setText(rphone);
        jtRowData.remail.setText(remail);
        jtRowData.raddress.setText(raddress);
        jtRowData.trackingno.setText(trackingno);
        jtRowData.typeofcargo.setText(typeofcargo);
        jtRowData.weight.setText(weight);
        jtRowData.depttime.setText(depttime);
        jtRowData.origin.setText(origin);
        jtRowData.destination.setText(destination);
        jtRowData.pickupdate.setText(pickupdate);
        jtRowData.pickuptime.setText(pickuptime);
    }//GEN-LAST:event_tblCargoMousePressed

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmViewCargoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmViewCargoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmViewCargoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmViewCargoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmViewCargoo().setVisible(true);
            }
        });
    }

    private void SetIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Search;
    private javax.swing.JButton btnAscending;
    private javax.swing.JButton btnCancelCargo;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateCargo;
    private javax.swing.JButton btnviewdetails;
    private javax.swing.JComboBox<String> combSearchType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCargo;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}