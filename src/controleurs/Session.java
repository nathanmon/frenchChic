package controleurs;

import javax.swing.JFrame;
import vues.EnumTypeEcran;

public class Session extends JFrame {
	
	public Session() {
	}
	
	public static EnumTypeEcran traiterConnexion(String src) {
		switch(src){
		case "Accueil":
			return EnumTypeEcran.ECRAN_ACCUEIL;
		case "S'identifier":
			return EnumTypeEcran.ECRAN_PERSO;
		case "Ajouter le produit du jour au panier":
			return EnumTypeEcran.ECRAN_PANIER;
		default:
			return null;
		}
	}
}
