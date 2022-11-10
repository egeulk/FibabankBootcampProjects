package com.example.bootcamphw1;

public class Employee {
    private long employeeId;

    private String employeeName;

    private long monthlySalary;

    public Employee(long employeeId, String employeeName, long monthlySalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(long monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String toString(){
        return "Bu calisanin id'si" + getEmployeeId()+
                "Bu calisanin ismi" + getEmployeeName()+
                "Bu calisanin maasi" + getMonthlySalary();
    }
}
