package agent;

import environnement.Minerai;

public class Transporteur extends Agent{
    private Minerai minerai;
    
    public Transporteur(int x, int y) {
        super(x, y);
    }
    
    public void transporter(Minerai minerai) {
        this.seDeplacer(minerai.getPositionx(), minerai.getPositiony());
        this.setMinerai(minerai);
        this.seDeplacer(this.getBase().getPositionx(), this.getBase().getPositiony());
    }
    
    public void setMinerai(Minerai minerai) {
        this.minerai = minerai;
    }
   public Minerai getMinerai() {
       return this.minerai;
   }
}
