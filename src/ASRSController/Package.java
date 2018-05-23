package ASRSController;

public class Package {
    private final int productNr;
    private final String name;
    private final int x;
    private final int y;
    private final int height;

    public Package(int productNr, String name, int x, int y, int height) {
        this.productNr = productNr;
        this.name = name;
        this.x = x;
        this.y = y;
        this.height = height;
    }
    
    public int getProductNr() {
        return productNr;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Package{" + "name=" + name + ", x=" + x + ", y=" + y + ", height=" + height + '}';
    }
}
