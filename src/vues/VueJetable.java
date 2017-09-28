package vues;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleurs.Session;

public class VueJetable implements ActionListener{
	private JFrame fenetre;
	private Session session = new Session();
	private EnumTypeEcran vue;
	public static void main(String[] args) {
		new VueJetable();
	}
	public VueJetable(){
		fenetre = new JFrame();
		fenetre.setTitle("French chic - login");
		fenetre.pack();
		fenetre.setSize(1000, 800);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		écranAccueil();
	}
	
	public void écranPanier() {
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		pan.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();

		fenetre.setContentPane(pan);
		fenetre.setVisible(true);
	}
	public void écranPerso() {
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		pan.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
		JTextArea title = new JTextArea("French Chic");
		title.setForeground(Color.MAGENTA);
		title.setFont(new Font("Arial", Font.PLAIN, 100));
		title.setEditable(false);
	    title.setPreferredSize(new Dimension(600, 150));
	    JLabel texte1 = new JLabel("Bonjour Marie Dupon");
	    JLabel texte2 = new JLabel("Le produit du jour est le \"pantalon zouk\" au prix HT de 50€");
	    JLabel texte3 = new JLabel("Quantité");
	    JTextField quantite = new JTextField();
	    quantite.setPreferredSize(new Dimension(100, 35));
		JButton button = new JButton("Ajouter le produit du jour au panier");
		button.addActionListener(this);
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan.add(title, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
		pan.add(texte1, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 2;
		pan.add(texte2, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
		pan.add(texte3, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
		pan.add(quantite, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.gridwidth = 3;
		pan.add(button, gbc);
		fenetre.setContentPane(pan);
		fenetre.setVisible(true);
	}
	public void écranAccueil() {
		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		pan.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
		JTextField field1 = new JTextField();
		field1.setPreferredSize(new Dimension(300, 50));
		field1.setFont(new Font("Arial", Font.PLAIN, 50));
		JTextField field2 = new JTextField();
		field2.setPreferredSize(new Dimension(300, 50));
		field2.setFont(new Font("Arial", Font.PLAIN, 50));
		JTextArea title = new JTextArea("French Chic");
		title.setForeground(Color.MAGENTA);
		title.setFont(new Font("Arial", Font.PLAIN, 100));
		title.setEditable(false);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
	    title.setPreferredSize(new Dimension(600, 150));
		JLabel label1 = new JLabel("Pseudo");
		label1.setLocation(200, 500);
		JLabel label2 = new JLabel("Mot de passe");
		JButton button = new JButton("S'identifier");
		button.addActionListener(this);
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan.add(title, gbc);
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
		pan.add(label1, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan.add(field1, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
		pan.add(label2, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
		pan.add(field2, gbc);
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.gridx = 0;
	    gbc.gridy = 3;
		pan.add(button, gbc);
		fenetre.setContentPane(pan);
		fenetre.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		EnumTypeEcran vue = Session.traiterConnexion(e.getActionCommand());
		switch(vue){
		case ECRAN_ACCUEIL:
			écranAccueil();
            break;
        case ECRAN_PERSO:
        	écranPerso();
        	break;
        case ECRAN_PANIER:
        	écranPanier();
            break;
		}
	}
}
