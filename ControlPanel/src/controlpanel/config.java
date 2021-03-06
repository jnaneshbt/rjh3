/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlpanel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jnaneshbt
 */
public class config extends javax.swing.JPanel {

    static IoTpublisher mpub = null;
    static String clientId = "IoT Control Panel";
    /**
     * Creates new form config
     */
    public config() {
       // initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        ipaddress_textField = new javax.swing.JTextField();
        portNo_textEdit = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        connectButton = new javax.swing.JButton();

        jTextField2.setText("jTextField1");

        setBackground(new java.awt.Color(153, 255, 204));

        label.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("IoT BROKER SETUP");

        label1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("Port No. :");

        label2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("IoT Broker IP Address :");

        ipaddress_textField.setText("tcp://127.0.0.1");
        ipaddress_textField.setToolTipText("Enter IoT Gateway IP Address");

        portNo_textEdit.setText("1883");
        portNo_textEdit.setToolTipText("Enter IoT Gateway Port No");
        portNo_textEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portNo_textEditActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearButton.setText("Clear");

        connectButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2)
                            .addComponent(label1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ipaddress_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portNo_textEdit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(connectButton))
                            .addComponent(label))))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipaddress_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(portNo_textEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(connectButton))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    boolean connected = false;
    public static IoTpublisher getPublisher()
    {
        if(mpub == null)
        {
         mpub = new IoTpublisher("tcp://localhost:1883",clientId);
        }
        return mpub;
    }
    
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        
        String broker =  ipaddress_textField.getText() + ":" + portNo_textEdit.getText();
        
        mpub = new IoTpublisher(broker,clientId);
        if(connected)
        {
            connectButton.setText("CONNECT");
        }
        else
        {
//            connectButton.setText("DIS CONNECT");
        }
 //       connected = !connected;
        
    }                                             

    private void portNo_textEditActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               


    // Variables declaration - do not modify                     
    private javax.swing.JButton clearButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JTextField ipaddress_textField;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JTextField portNo_textEdit;
    // End of variables declaration                   
}
