package ASRSController;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private final int productNr;
    private final String name;
    private final int x;
    private final int y;
    private final int height;
    private final boolean packed;



    Package(int productNr, String name, int x, int y, int height, boolean packed) {
        this.productNr = productNr;
        this.name = name;
        this.x = x;
        this.y = y;
        this.height = height;
        this.packed = packed;
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

    public boolean getPacked() {
        return this.packed;
    }

    @Override
    public String toString() {
        return "Package{" + "name=" + name + ", x=" + x + ", y=" + y + ", height=" + height + '}';
    }
}
