package Immutab;

import java.util.List;

public class Immutab {
        private final List<String> SPISOK;

    public Immutab(List<String> SPISOK) {
        this.SPISOK = SPISOK;
    }


    public List<String> getSPISOK() {
        return List.copyOf(SPISOK);
    }
}
