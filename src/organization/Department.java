package organization;

import java.util.*;

public class Department {
    private int departmentId;
    private String departmentName;

    List<Employee> employees = new ArrayList();

    public Department(String departmentName) {
//        this.employees = ;
        this.departmentName = departmentName;
    }

    public Department(List<Employee> employees) {
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int numberOfEmployees(){
        return this.employees.size();
    }

    public int totalSalary(){
        int totalSum = 0;
        for(int i = 0; i<this.employees.size(); i++){
            totalSum += this.employees.get(i).getSalary();
        }
        return totalSum;
    }

    public void pointsToEmployee(String name, String surname){
        for(Employee employee : employees){
            if(employee.getName() == name && employee.getSurname()== surname){
                System.out.println("This is an employee with name:" + name + " and surname:"
                        + surname + " with salary:" + employee.getSalary() + " at position:" + employee.getPosition());
                return ;
            }
        }
        System.out.println("There is no such an employee");
    }

    public void dismissEmployee(String name, String surname, String position){
        for(Employee employee : employees){
            if(employee.getName() == name && employee.getSurname() == surname
                    && employee.getPosition() == position){
                employees.remove(employee);
            }
        }
    }

    public void acceptEmployee(Employee employee){
        employees.add(employee);
    }

    public Employee[] getAll(){
        Employee[] emplArr = new Employee[employees.size()];
        employees.toArray(emplArr);
        return emplArr;
    }

    public Employee[] getSorted(){
        List<Employee> needList = new ArrayList<>(); //Create tempList where we will sort our employees
        List<String> surnames = new ArrayList<>(); //Create list of surnames where we will sort by surnames
        for(int i = 0; i < employees.size(); i++){
            surnames.add(employees.get(i).getSurname()); //Add employees surnames to surname list
        }
        List<String> surnames2 = new ArrayList<>(surnames);//New list where we will sort the surnames,
        Collections.sort(surnames2);                       // in order to find needed index to get employee
        for(int i = 0; i < surnames.size(); i++){ // here i for sorted surnames, and j for original list
            for(int j = 0; j < surnames.size(); j++){ // It's like checking two list: list1=[b, c, a]; list2=[a, b, c]
                if(Objects.equals(surnames2.get(i),surnames.get(j) )){ //When we found needed index, add the employee
                    needList.add(employees.get(j));  //to the needList by founded index
                }
            }
        }

        for(int i = 1; i < needList.size(); i++){ //Checking the names
            if(Objects.equals(needList.get(i - 1).getSurname(), needList.get(i).getSurname())){
                String name1 = needList.get(i-1).getName();
                String name2 = needList.get(i).getName();
                if(!isCorrectNameOrder(name1,name2)){
                    Employee temp = needList.get(i);
                    needList.remove(i);
                    needList.add(i-1,temp);
                }
            }
        }

        Employee[] array = new Employee[needList.size()];
        needList.toArray(array);
        return array;
    }

    public boolean isCorrectNameOrder(String s1, String s2){
        List<String> list = new ArrayList<>();
        for(int i =0; i < Math.min(s1.length(), s2.length()); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if((int) ch1 < (int) ch2){
                return true;
            }
            if((int) ch1 > (int) ch2){
                return false;
            }
        }
        return true;
    }
}
