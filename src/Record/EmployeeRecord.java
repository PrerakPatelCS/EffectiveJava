package Record;

public record EmployeeRecord(String name, int employeeNumber) {
    /**
     * Creates an immutable class with these objects
     * makes a canonical constructor
     * overrides equals,hashcode, and toString automatically
     * you can add to it, implement add methods calculated fields and so on
     */
}
