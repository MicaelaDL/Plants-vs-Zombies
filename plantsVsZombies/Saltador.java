/*
Zombi saltador de pértiga: Salta sobre la primera planta que encuentra con su pértiga para luego
 */
package plantsVsZombies;

public class Saltador extends Zombie {
    public Saltador(int coorX) {
        super(coorX);
        this.id = 'S';
    }
}