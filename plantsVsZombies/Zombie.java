/*
Zombi: Zombi de jardín común, no tiene nada en especial.
 */
package plantsVsZombies;

public class Zombie{
    protected char id; // char con el que se va identificar por pantalla
    protected int x;
    protected int y;
    protected int vida;
    protected int danio; // el daño que realiza al atacar
    protected int ralentizado; // si ha sido ralentizado
    protected boolean atacando;

    public Zombie(int coorX) {
        this.id = 'z';
        this.x = coorX;
        this.y = 9; //aparece en el extremo derecho
        this.vida = 100;
        this.danio = 25;
        this.ralentizado = 0;
        this.atacando = false;
    }

    protected void avanzar(Juego juego, Zombie zombie){
        if (zombie.getRalentizado() == 2) { // si esta ralentizado...
            zombie.setRalentizado(getRalentizado() - 1); // se reduce en uno
        } else { // si no
            if (zombie.getRalentizado() > 0) {
                zombie.setRalentizado(getRalentizado() - 1); // se reduce en uno
            }
            if (zombie.isAtacando()) { //si el zombie está atacando
                atacar(juego, zombie);
            } else { //si no está atacando...
                caminar(juego, zombie);
            }
        }
    }

    protected void atacar(Juego juego, Zombie zombie) {
        Jardin jardin = juego.jardin;
        int i, j;
        i = zombie.getX();
        j = zombie.getY();
        int vida = jardin.jardinP[i][j - 1].getVida() - jardin.jardinZ[i][j].getDanio();
        if (vida > 0) {
            jardin.jardinP[i][j - 1].setVida(vida); // le quita vida a la planta
            System.out.printf("- La planta '%s' en la posición (%d,%d) ha recibido %d de danio y su vida actual es %d.\n",
                    jardin.jardinP[i][j - 1].getId(), i + 1, j, jardin.jardinZ[i][j].getDanio(), vida);
        } else { // si mata a la planta
            switch (jardin.jardinP[i][j - 1].getId()) { // si mata a una de estas plantas...
                case 'G': {
                    juego.setCantGirasoles(juego.getCantGirasol() - 1); // reduce su cantidad en uno
                    break;
                }
                case 'R': {
                    juego.setCantRepetidora(juego.getCantRepetidora() - 1);
                    break;
                }
                case 'P': {
                    juego.setCantPatatapum(juego.getCantPatatapum() - 1);
                    break;
                }
            }
            System.out.printf("- Un zombie ha comido a la planta '%s' que estaba en la posición (%d,%d)! T-T\n", jardin.jardinP[i][j - 1].getId(), i + 1, j);
            juego.setTotalPlantas(juego.getTotalPlantas() - 1);
            jardin.jardinP[i][j - 1] = null; //la eliminamos
            zombie.setAtacando(false); //deja de atacar
        }
    }

    protected void caminar(Juego juego, Zombie zombie) {
        Jardin jardin = juego.jardin;
        int i, j;
        i = zombie.getX();
        j = zombie.getY();
        // si no hay nada adelante avanza
        if (j > 0 && jardin.jardinZ[i][j - 1] == null && jardin.jardinP[i][j - 1] == null) {
            zombie.setY(j - 1); //cambiamos la coor 'y' del zombie
            jardin.jardinZ[i][j - 1] = jardin.jardinZ[i][j]; //lo movemos en el tablero
            jardin.jardinZ[i][j] = null; //borramos donde estaba antes
            // si al caminar queda al lado de una planta...
            if ((j - 2) >= 0 && jardin.jardinP[i][j - 2] != null) {
                jardin.jardinZ[i][j - 1].setAtacando(true); //deja de caminar porque va a estar atacando
            }
        } else if (j == 0) { // si el zombie se encuentra en el limite derecho
            jardin.jardinZ[i][j] = null; //borramos donde estaba antes
            System.out.println("Se ha pasado un zombie! (>_<)");
            juego.setVidas(juego.getVidas() - 1);
        }
    }

    // Getters y setters
    public char getId() {
        return this.id;
    }
    public void setId(char id) {
        this.id = id;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getVida() {
        return this.vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getDanio() {
        return this.danio;
    }
    public int getRalentizado() {
        return ralentizado;
    }
    public void setRalentizado(int ralentizado) {
        this.ralentizado = ralentizado;
    }
    public boolean isAtacando() {
        return atacando;
    }
    public void setAtacando(boolean atacando) {
        this.atacando = atacando;
    }
}
