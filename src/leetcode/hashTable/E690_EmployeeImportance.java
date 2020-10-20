package leetcode.hashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/20 16:41
 * @desc: https://leetcode.com/problems/employee-importance/
 */
public class E690_EmployeeImportance {

    /**
     * hashMap + dfs
     * @param employees
     * @param id
     * @return
     */
    public int getImportance2(List<Employee> employees, int id) {
        
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }

    private int getImportanceHelper(Map<Integer, Employee> map, int id) {

        Employee root = map.get(id);
        int importance = root.importance;
        if (root.subordinates == null) {
            return root.importance;
        }else {
            List<Integer> subordinates = root.subordinates;
            for (Integer subordinate : subordinates) {
                importance += getImportanceHelper(map, subordinate);
            }
            return importance;
        }
    }


    /**
     * dfs
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        Employee employee = getEmployee(employees, id);
        if (employee == null) {
            return 0;
        }

        if (employee.subordinates == null) {
            return employee.importance;
        }else {
            importance += employee.importance;
            List<Integer> subordinates = employee.subordinates;
            for (Integer subordinate : subordinates) {
                if (getEmployee(employees, subordinate) != null) {
                    // 递归
                    importance += getImportance(employees, subordinate);
                }
            }
        }
        return importance;
    }

    public Employee getEmployee(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
