package ASRSController;

import java.util.ArrayList;
import java.util.List;

class Container {
    private List<Package> packages;

    Container() {
        this.packages = new ArrayList<>();
    }

    void addPackage(Package p) {
        this.packages.add(p);
    }

    List<Package> getPackages() {
        return this.packages;
    }

    int getPercentageFilled() {
        int result = 0;
        for (Package p : this.packages) {
            result += p.getHeight();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Package(" + this.packages.size() + "," + this.getPercentageFilled() + "%)";
    }
}
