/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee a=new Employee();
        for(Employee e:employees){
            if(e.id==id){
                a=e;
                break;
            }
        }
        int sans=a.importance;
        for(int e:a.subordinates){
            sans+=getImportance(employees,e);
        }
        return sans;
    }
}