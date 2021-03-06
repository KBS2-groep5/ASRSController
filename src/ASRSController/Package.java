package ASRSController;

public class Package {
    private final int productNr;
    private final String name;
    private final int x;
    private final int y;
    private final int height;
    private boolean packed;
    private boolean kickedOut;

    Package(int productNr, String name, int x, int y, int height, boolean packed, boolean kickedOut) {
        this.productNr = productNr;
        this.name = name;
        this.x = x;
        this.y = y;
        this.height = height;
        this.packed = packed;
        this.kickedOut = kickedOut;
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

    boolean getPacked() {
        return this.packed;
    }

    void setPacked(boolean packed) {
        this.packed = packed;
    }

    boolean getKickedOut() {
        return this.kickedOut;
    }

    void setKickedOut(boolean kickedOut) {
        this.kickedOut = kickedOut;
    }

    double getDistanceTo(Package c2) {
        double a = Math.max(this.x, c2.getX()) - Math.min(this.x, c2.getX());
        double b = Math.max(this.y, c2.getY()) - Math.min(this.y, c2.getY());
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public String toString() {
        return "Package{" + "name=" + name + ", x=" + x + ", y=" + y + ", height=" + height + '}';
    }
}
