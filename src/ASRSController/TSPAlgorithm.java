package ASRSController;

import java.util.ArrayList;
import java.util.List;

class TSPAlgorithm {
    static List<Package> sort(List<Package> packageList) {
        List<Package> path = new ArrayList<>();
        path.add(packageList.get(0));

        while (packageList.size() > path.size()) {
            double shortestDistance = 99999;
            Integer shortestIndex = null;
            for (int i = 0; i < packageList.size(); i++) {
                if (path.contains(packageList.get(i))) continue;
                double dist = packageList.get(i).getDistanceTo(path.get(path.size() - 1));
                if (dist < shortestDistance) {
                    shortestDistance = dist;
                    shortestIndex = i;
                }
            }
            //noinspection ConstantConditions
            path.add(packageList.get(shortestIndex));
        }

        return path;
    }

}
