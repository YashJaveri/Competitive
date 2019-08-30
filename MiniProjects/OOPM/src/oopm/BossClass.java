package oopm;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yashjaveri
 */
public class BossClass {

    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    static ArrayList<TaskObject> taskObjs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    public static void launchBossUI() {
        taskObjs = new ArrayList<>();
        estConnection();
        taskObjs = sqlQuery();
        manageUI();
    }

    static void manageUI() {
        BossUI bossUI = new BossUI(taskObjs);
        bossUI.setVisible(true);
    }

    static ArrayList<TaskObject> sqlQuery() {
        ArrayList<TaskObject> _taskObjs = new ArrayList<>();
        estConnection();
        try {
            System.out.println(conn);
            ps = conn.prepareStatement("SELECT * from ROUTINE");
            System.out.println("ps");
            rs = ps.executeQuery();
            System.out.println("rs");
            while (rs.next()) {
                _taskObjs.add(fromSql(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BossClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        String amPm;
        for (TaskObject t : _taskObjs) {
            if (t.isAM()) {
                amPm = "AM";
            } else {
                amPm = "PM";
            }
        }
        return _taskObjs;
    }

    static TaskObject fromSql(String task, int hour, int minute, int duration) {
        TaskObject taskObject;
        Boolean isAM = true;
        if (hour > 12) {
            hour = hour - 12;
            isAM = false;
        }
        taskObject = new TaskObject(task, hour, minute, isAM, duration);
        return taskObject;
    }

    static private void estConnection() {

        if (conn == null) {
            conn = sqldb.javaDb();
        }
    }
}
