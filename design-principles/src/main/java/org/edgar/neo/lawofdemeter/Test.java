package org.edgar.neo.lawofdemeter;

public class Test {

    public static void main(String[] args) {
        TeamLeader leader = new TeamLeader();
        Employee employee = new Employee();
        leader.checkCourseNumber(employee);
    }
}
