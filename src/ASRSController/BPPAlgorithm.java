package ASRSController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class BPPAlgorithm {
    static List<Container> solve(List<Package> packages) {
        List<Container> solution = Stream.generate(Container::new).limit(5).collect(Collectors.toList());
        int cursor = 0;

        for (Package p : packages) {
            while (solution.get(cursor).getPercentageFilled() + p.getHeight() > 100) {
                cursor += 1;
            }
            solution.get(cursor).addPackage(p);
            cursor = 0;
        }

        return solution;
    }
}
