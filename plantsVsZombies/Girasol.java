/*
Girasol: Produce soles con un valor de 25 para que puedas sembrar otras plantas, su producción de
soles demora en los niveles nocturnos. Tiene un coste de 50 soles.

Birasol: Proporciona el doble de soles que el Girasol. Se necesita estar plantada sobre un Girasol.
Su coste inicial de 150 soles.
 */
package plantsVsZombies;
public class Girasol extends Planta {
    protected int generaSol;

    public Girasol (int x, int y){
        super(x,y);
        this.generaSol=25;
        this.costo=50;
        this.danio=0;
        this.id='G';
        
    }
    @Override
    //aumenta la cantidad de soles del juego en vez de atacar
    public void atacar(Planta p, Juego juego){
        juego.setSoles(juego.getSoles()+this.generaSol);
    }
}
