package environnement;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Grille {
	
	private int taille_x;
	private int taille_y;
	private ArrayList <Element> elementList;
	
	public Grille(int x, int y){
		this.setTaille_x(x);
		this.setTaille_y(y);
		this.elementList = new ArrayList<Element>();
		
		JFrame frame = new JFrame();
		frame.setSize(500, 600);
		frame.setTitle("Mars attack");
		
		JPanel pan = new JPanel (new GridLayout (x,y));
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		for(int i = 0; i < (x*y);i++){
		   JPanel ptest = new JPanel();
		   ptest.setBorder(blackline);
		   pan.add(ptest);
		}
		pan.setBorder(blackline);
		
		frame.add(pan);
		frame.setVisible(true);
	}

	public int getTaille_x() {
		return taille_x;
	}

	public void setTaille_x(int taille_x) {
		this.taille_x = taille_x;
	}

	public int getTaille_y() {
		return taille_y;
	}

	public void setTaille_y(int taille_y) {
		this.taille_y = taille_y;
	}

	public ArrayList<Element> getElementList() {
		return elementList;
	}

	public void setElementList(ArrayList<Element> elementList) {
		this.elementList = elementList;
	}

	public void addElement(Element element) {	
		this.elementList.add(element);
	}
	
	public void deleteElement(Element element){
		this.elementList.remove(element);
	}
	
	public Element getElementByPosition(int pos_x, int pos_y){
		for (Element e : elementList) {
			if(e != null){
				if(e.getPositionx() == pos_x){
					if(e.getPositiony() == pos_y){
						return e;
					}
				}
			}
		}
		return null;
	}
	
	public boolean isFree(int pos_x, int pos_y){
		if(pos_x > taille_x || pos_x < 0 || pos_y > taille_y || pos_y < 0){
			return false;
		}
		Element element = getElementByPosition(pos_x,pos_y);
		//Si il y a bien un �l�ment � cette position sur la grille
		if(element != null){
			//V�rifier quel type d'Element est sur la case pour savoir si on peut y aller
			if(element instanceof Minerai){
				return true;
			}else if(element instanceof Obstacle){
				return false;
			}else if(element instanceof Base){
				return true;
			}
		}
		//Sinon c'est que la case est libre
		return true;
	}
}
