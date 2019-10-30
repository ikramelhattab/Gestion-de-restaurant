/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile_food;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Home extends javax.swing.JFrame {
Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String sqr;
    /**
     * Creates new form Home
     */
    public Home() {
       initComponents();
        conn=DBconnect.connect();
        select();
        autoId();
    }
private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        add = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        btnnext = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtcategory = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Show = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblimginsert = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtpid = new javax.swing.JTextField();
        txtpname = new javax.swing.JTextField();
        txtpcategory = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add.setBackground(new java.awt.Color(153, 255, 153));
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 36)); // NOI18N
        jLabel3.setText("My Photo Album");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 850, 60));

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add.add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 114, 590, 350));

        btnnext.setBackground(new java.awt.Color(51, 51, 255));
        btnnext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnext.setText(">>");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        add.add(btnnext, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 60, 350));

        btnback.setBackground(new java.awt.Color(51, 51, 255));
        btnback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnback.setText("<<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, 350));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });
        add.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 480, 120, 40));

        txtname.setEditable(false);
        txtname.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        add.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 480, 200, 40));

        txtcategory.setEditable(false);
        txtcategory.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        add.add(txtcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 480, 160, 40));

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jButton1.setText("clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 483, 110, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 483, 120, 40));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 850, 440));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 870, 530));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 895, 556));

        jTabbedPane1.addTab("Show Images", add);

        Show.setBackground(new java.awt.Color(255, 204, 153));
        Show.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 36)); // NOI18N
        jLabel8.setText("My Photo Album");
        Show.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 320, 30));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Show.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 850, 70));

        lblimginsert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Show.add(lblimginsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 390, 320));

        jButton3.setBackground(new java.awt.Color(51, 255, 51));
        jButton3.setFont(new java.awt.Font("Sitka Text", 3, 36)); // NOI18N
        jButton3.setText("Choose Image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Show.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 390, 40));
        Show.add(txtpid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 170, 30));
        Show.add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 170, 30));
        Show.add(txtpcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 170, 30));

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jButton4.setText("Insert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Show.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 180, 40));

        jLabel15.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel15.setText("ID");
        Show.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 140, 30));

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel16.setText("Name");
        Show.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel17.setText("Category");
        Show.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jButton5.setBackground(new java.awt.Color(51, 255, 51));
        jButton5.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Show.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 170, 40));

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Show.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 850, 430));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Show.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 870, 530));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Show.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 895, 556));

        jTabbedPane1.addTab("Insert Images", Show);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed

        next();
    }//GEN-LAST:event_btnnextActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
         JFileChooser fchoser=new JFileChooser();
        fchoser.showOpenDialog(null);
        File f=fchoser.getSelectedFile();
        fname=f.getAbsolutePath();
        ImageIcon micon=new ImageIcon(fname);       
        try {
            File image=new File(fname);
            FileInputStream fis=new FileInputStream(image);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum; (readnum=fis.read(buf)) !=-1;)
            {           
                baos.write(buf,0,readnum);               
            }
            pinsertimage=baos.toByteArray();
            lblimginsert.setIcon(resizeImage(fname, buf));
        } catch (Exception e) {
        }       
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String pid=txtpid.getText();
        String pname=txtpname.getText();
        String pcate=txtpcategory.getText();
      
         {             
                try {
                String q= "INSERT INTO `image`(`id`, `name`, `category`, `image`) VALUES (?,?,?,?)";             
                pst=conn.prepareStatement(q);               
                pst.setString(1, pid);
                pst.setString(2, pname);
                pst.setString(3, pcate);
              
                pst.setBytes(4, pinsertimage);               
                pst.execute();
                    }
                catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane,e);
                                          } 
                JOptionPane.showMessageDialog(rootPane,"registation success");           
           }
         autoId();
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
    
        back();
      
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased

        btnnext.setEnabled(false);
        btnback.setEnabled(false);
        try {
            String sql="SELECT `id`, `name`, `category`, `image` FROM `image` where id='"+txtid.getText()+"'";         
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
           if(rs.next())
           {
               txtid.setText(rs.getString("id"));
               txtname.setText(rs.getString("name"));
               txtcategory.setText(rs.getString("category"));
              
               byte[] imagedata=rs.getBytes("image");
               format=new ImageIcon(imagedata);
               Image mm=format.getImage();
               Image img2=mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image=new ImageIcon(img2);
               lblimage.setIcon(image);
            }
           else
           {
           clear();
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }     
      
    }//GEN-LAST:event_txtidKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      select();
      btnback.setEnabled(true);
      btnnext.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
         int x=JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete");
         if(x==0)
         {
         try {
                String sql="DELETE FROM `image` WHERE id='"+ txtid.getText() +"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "successfully delete"); 
                clear();
                select();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        ImageIcon img=new ImageIcon();
txtpname.setText("");
txtpcategory.setText("");
lblimginsert.setIcon(img);
autoId();
      
    }//GEN-LAST:event_jButton5ActionPerformed
private void select()
{
try {
    txtid.setText("1");
            String sql="SELECT `id`, `name`, `category`, `image` FROM `image` where id='"+txtid.getText()+"'";         
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
           if(rs.next())
           {
               txtid.setText(rs.getString("id"));
               txtname.setText(rs.getString("name"));
               txtcategory.setText(rs.getString("category"));
              
               byte[] imagedata=rs.getBytes("image");
               format=new ImageIcon(imagedata);
               Image mm=format.getImage();
               Image img2=mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image=new ImageIcon(img2);
               lblimage.setIcon(image);
            }                           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }     
}

private void next()
{
   // String nextid=txtid.getText();
    btnback.setEnabled(true);
    clear();
    int neid=Integer.parseInt(txtid.getText());
    int nextid=neid+1;
    String snid= String.valueOf(nextid);
    txtid.setText(snid);
try {
            String sql="SELECT `id`, `name`, `category`, `image` FROM `image` where id='"+snid+"'";         
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
           if(rs.next())
           {
              
               txtid.setText(rs.getString("id"));
               txtname.setText(rs.getString("name"));
               txtcategory.setText(rs.getString("category"));
              
               byte[] imagedata=rs.getBytes("image");
               format=new ImageIcon(imagedata);
               Image mm=format.getImage();
               Image img2=mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image=new ImageIcon(img2);
               lblimage.setIcon(image);
              
            
            }
           else if(Integer.parseInt(txtid.getText()) == Integer.parseInt(txtpid.getText()))
           {
            btnnext.setEnabled(false);
           }
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }     
}

private void back()
{
   // String nextid=txtid.getText();
    btnnext.setEnabled(true);
    clear();
    int neid=Integer.parseInt(txtid.getText());
    int nextid=neid-1;
    String snid= String.valueOf(nextid);
    txtid.setText(snid);
           try {
            String sql="SELECT `id`, `name`, `category`, `image` FROM `image` where id='"+snid+"'";         
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
           if(rs.next())
           {
               txtid.setText(rs.getString("id"));
               txtname.setText(rs.getString("name"));
               txtcategory.setText(rs.getString("category"));
              
               byte[] imagedata=rs.getBytes("image");
               format=new ImageIcon(imagedata);
               Image mm=format.getImage();
               Image img2=mm.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image=new ImageIcon(img2);
               lblimage.setIcon(image);
            } 
           else if(Integer.parseInt(txtid.getText())==0)
           {
               btnback.setEnabled(false);
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }     
}

private void clear()
{
ImageIcon img=new ImageIcon();
txtname.setText("");
txtcategory.setText("");
lblimage.setIcon(img);

}

 private void autoId()
    {
        try {
            String sql="SELECT `id` FROM `image` ORDER BY id DESC LIMIT 1";         
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
           if(rs.next())
           {
               String rnno=rs.getString("id");
//               int co=rnno.length();
//               String txt= rnno.substring(0, 3);
//               String num=rnno.substring(3, co);
               int n=Integer.parseInt(rnno);
               n++;
               String snum=Integer.toString(n);
             //  String ftxt=txt+snum;
               txtpid.setText(snum);
           }
            else
           {
               txtpid.setText("1");
           }                         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }     
    }
    /**
     * @param args the command line arguments
     */
  
    private ImageIcon format=null;
String fname=null;
int s=0;
byte[] pimage=null;

      public ImageIcon resizeImage(String imagePath, byte[] pic){
        
        ImageIcon myImage=null;
        if(imagePath !=null)
        {
        myImage=new ImageIcon(imagePath);
      
        }else{
         myImage=new ImageIcon(pic);
        }
              
        Image img=myImage.getImage();
        Image img2=img.getScaledInstance(lblimage.getHeight(), lblimage.getWidth(),  Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(img2);
        return image;
    }
    
    
  //  private ImageIcon format=null;
   // String fname=null;
  //  int s=0;
    byte[] pinsertimage=null;

      public ImageIcon resizeImage2(String imagePath, byte[] pic){
        
        ImageIcon myImage=null;
        if(imagePath !=null)
        {
        myImage=new ImageIcon(imagePath);
      
        }else{
         myImage=new ImageIcon(pic);
        }
              
        Image img=myImage.getImage();
        Image img2=img.getScaledInstance(lblimginsert.getHeight(), lblimginsert.getWidth(),  Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(img2);
        return image;
    }
  
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Show;
    private javax.swing.JPanel add;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JLabel lblimginsert;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpcategory;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    // End of variables declaration//GEN-END:variables
        /* Create and display the form */
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
