package ASRSController;

public class Package {
    private final int productNr;
    private final String name;
    private final int x;
    private final int y;
    private final int height;

    Package(int productNr, String name, int x, int y, int height) {
        this.productNr = productNr;
        this.name = name;
        this.x = x;
        this.y = y;
        this.height = height;
    }
    
    int getProductNr() {
        return productNr;
    }

    String getName() {
        return name;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Package{" + "name=" + name + ", x=" + x + ", y=" + y + ", height=" + height + '}';
    }
}
