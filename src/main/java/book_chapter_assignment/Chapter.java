package book_chapter_assignment;

import java.util.Objects;

public class Chapter implements Comparable<Chapter>{

    private String name;
    private String number;

    public Chapter(String name, String number) {
        if ( !number.matches("^\\d+(\\.\\d+)?$") ) { throw new IllegalArgumentException(); }
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object chapter) {
        if (chapter == null) {
            return false;
        }

        if (chapter == this) return true;

        if (!(chapter instanceof Chapter)) {
            return false;
        }

        return name.equals(((Chapter) chapter).name) && number.equals(((Chapter) chapter).number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public int compareTo(Chapter o) {
        if ( Double.parseDouble( this.getNumber() ) < ( Double.parseDouble(o.getNumber()) )) {
            return 1;
        }
        return 0;
    }
}
