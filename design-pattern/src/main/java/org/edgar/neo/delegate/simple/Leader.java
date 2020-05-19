package org.edgar.neo.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee{

    private Map<String, IEmployee> employeeMap = new HashMap<String, IEmployee>();

    public Leader() {
        employeeMap.put("duty1", new EmployeeA());
        employeeMap.put("duty2", new EmployeeB());
    }

    /**
     * 委派给具体员工执行
     */
    public void doing(String task) {
        if (employeeMap.containsKey(task)){
            employeeMap.get(task).doing(task);
        }
    }
}
