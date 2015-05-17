
package fifteenproject;

import java.awt.Font;

public class FifteenGUI extends javax.swing.JFrame
{

    public FifteenGUI()
    {
        initComponents();
        updateUI();
        fifteenBoard1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        MoveTB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fifteenBoard1 = new fifteenproject.FifteenBoard();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fifteen");
        setBounds(new java.awt.Rectangle(0, 22, 510, 430));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 530, 430));
        setMinimumSize(new java.awt.Dimension(509, 429));

        MoveTB.setEditable(false);
        MoveTB.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        MoveTB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MoveTBActionPerformed(evt);
            }
        });

        jLabel1.setText("Square(s) moved:");

        fifteenBoard1.setPreferredSize(new java.awt.Dimension(403, 403));
        fifteenBoard1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                fifteenBoard1MousePressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout fifteenBoard1Layout = new org.jdesktop.layout.GroupLayout(fifteenBoard1);
        fifteenBoard1.setLayout(fifteenBoard1Layout);
        fifteenBoard1Layout.setHorizontalGroup(
            fifteenBoard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 403, Short.MAX_VALUE)
        );
        fifteenBoard1Layout.setVerticalGroup(
            fifteenBoard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 403, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jButton1.setText("New Game");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(fifteenBoard1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(MoveTB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fifteenBoard1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(107, 107, 107)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(MoveTB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(27, 27, 27)
                        .add(jButton1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void MoveTBActionPerformed(java.awt.event.ActionEvent evt)                                       
    {                                           
        
    }                                      

    private void fifteenBoard1MousePressed(java.awt.event.MouseEvent evt)                                           
    {                                               
        updateUI();
    }                                          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)                                         
    {                                             
        fifteenBoard1.newGame();
        updateUI();
    }                                        

    private void updateUI()
    {
        MoveTB.setText(Integer.toString(fifteenBoard1.getNumClicks()));
                    
        repaint();
        
    }
    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new FifteenGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JTextField MoveTB;
    private fifteenproject.FifteenBoard fifteenBoard1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
