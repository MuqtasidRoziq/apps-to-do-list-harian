/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generic;

/**
 *
 * @author muqta
 */
public class loginSession {

    private static String userId;
    private static String fullname;

    public static void setUser(String id, String name) {
        userId = id;
        fullname = name;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getFullname() {
        return fullname;
    }

    public static void clear() {
        userId = null;
        fullname = null;
    }
}
