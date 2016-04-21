package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;




public class MainGUI {
 
 JFrame mainFrame= new JFrame();
 
 MainGUI(){
  
  mainFrame.setVisible(true);
  //DIMENSIONE PROGRAMMA ADATTABILE ALLO SCHERMO 
  final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  final int width = (int)screenSize.getWidth();
  final int height = (int)screenSize.getHeight();
  this.mainFrame.setSize(width, height);
  
  this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  //CREAZIONE PANNELLO PER GRIGLIA
  JPanel mainPanel= new JPanel(new GridBagLayout());
  
  
  //CREAZIONE PANEL BOTTONI
  JPanel buttonPanel= new JPanel(new GridBagLayout());
  //CREAZIONE BOTTONI
  JButton button1= new JButton("Undo/Redo");
  JButton button2= new JButton("Modifica");
  JButton button3= new JButton("Salva");
  
  
  //POSIZIONO I BOTTONI IN LINEA VERTICALE
  GridBagConstraints cnst= new GridBagConstraints();
  
  cnst.gridx=0;
  cnst.gridy=1;
  buttonPanel.add(button2,cnst);
  cnst.gridx=0;
  cnst.gridy=2;
  buttonPanel.add(button3,cnst);
  cnst.gridx=0;
  cnst.gridy=0;
  buttonPanel.add(button1);
  
  //AGGIUNGO I PANNELLI AL FRAME
  mainFrame.add(buttonPanel,BorderLayout.WEST);
  mainFrame.add(mainPanel);
  
  //INSERISCO UN NOME AI PANNELLI
  mainPanel.setBorder(new TitledBorder("Main Panel"));
  buttonPanel.setBorder(new TitledBorder("Panel Button"));
  buttonPanel.setBackground(Color.pink);
  
  
 }
 
 public static void main(String[] args){
  new MainGUI();
 }

}