public interface Employee {
    default int getEno(int eno) {
        return eno;
    }
}
