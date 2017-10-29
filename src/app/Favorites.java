package app;

/**
 *
 * @author waltereckard
 */
interface Favorites {
    Favorites clone();
}

class fav1 implements Favorites {
    private final String NAME = "Favorites";
    
    public Favorites clone() {
        return new fav1();
    }
}
