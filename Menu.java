import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends World
{
    public Menu()
    {   
        super(1000, 800, 1);
        openMenu();

    }
    public void act()
    {
    }
    
    public void openMenu(){
        JDialog meinJDialog = new JDialog();
        meinJDialog.setTitle("");
        meinJDialog.setSize(450,300);
        meinJDialog.setLocationRelativeTo(null);
        meinJDialog.setModal(true);
        meinJDialog.setAlwaysOnTop(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
            
        JLabel lMenu = new JLabel("Menü");
        lMenu.setFont(new Font("Magneto", Font.PLAIN, 40));
        lMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
            
        JLabel lDif = new JLabel("Schwierigkeit");
        lDif.setFont(new Font("Arial", Font.PLAIN, 15));
        lDif.setAlignmentX(Component.CENTER_ALIGNMENT);
            
        String[] saDif = {"Leicht","Normal","Schwer"};
        JComboBox cbDif = new JComboBox(saDif);
        cbDif.setMaximumSize(new Dimension(100, 30));
        cbDif.setFont(new Font("Arial", Font.PLAIN, 15));
        cbDif.setAlignmentX(Component.CENTER_ALIGNMENT);
            
        JButton bStart = new JButton("Start");
        bStart.setFont(new Font("Arial", Font.PLAIN, 15));
        bStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        bStart.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                MeteorWorld Mworld = new MeteorWorld();
                Greenfoot.setWorld(Mworld);
                Greenfoot.start();
                meinJDialog.dispose();
            }
        
        });
     
        panel.add(lMenu);
        panel.add(lDif);
        panel.add(cbDif);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(bStart);

            
        //JButton j
            
        panel.setBackground(Color.gray);
        meinJDialog.add(panel);
        meinJDialog.setVisible(true);
    }
}
