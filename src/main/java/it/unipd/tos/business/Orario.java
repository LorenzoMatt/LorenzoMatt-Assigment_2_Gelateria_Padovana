////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

public class Orario {
    private int Ore;
    private int Minuti;
    private int Secondi;
    public Orario(int Ore,int Minuti,int Secondi) 
    {
        this.Ore=(Ore >=0 && Ore <24) ? Ore : 0;
        this.Minuti=(Minuti >=0 && Minuti <60) ? Minuti : 0;
        this.Secondi=(Secondi >=0 && Secondi<60) ? Secondi: 0;
    }
    public Orario(Orario orario) {
        this.Ore=orario.Ore;
        this.Minuti=orario.Minuti;
        this.Secondi=orario.Secondi;
    }
    public void setOre(int Ore){
        this.Ore= Ore>=0 && Ore<24 ? Ore : 0;
    }
    public int getOre() {
        return Ore;
    }
    public int getMinuti() {
        return Minuti;
    }
    public int getSecondi() {
        return Secondi;
    }
}
