package ASRSController;

import java.util.List;
import java.util.ArrayList;

class TSPAlgorithm {
     static List<Package> sort(List<Package> packageList){
        List<Package> path = new ArrayList<>();
        path.add(packageList.get(0));

        int steps = 0;
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
            steps++;
        }

        return path;
    }

}
