import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bresya on 19.12.2015.
 */
public class Player{

    private String name;
    private int age;
    private boolean isInMain;
    private Role role;
    private int[] stats = new int[6];

    public Player(String name, int age, boolean isInMain, Role role, int[] stats) {
        this.name = name;
        this.age = age;
        this.isInMain = isInMain;
        this.role = role;
        this.stats = stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (age != player.age) return false;
        if (isInMain != player.isInMain) return false;
        if (!name.equals(player.name)) return false;
        return role == player.role && Arrays.equals(stats, player.stats);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (isInMain ? 1 : 0);
        result = 31 * result + role.hashCode();
        result = 31 * result + Arrays.hashCode(stats);
        return result;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isInMain() {
        return isInMain;
    }

    public void setInMain(boolean isInMain) {
        this.isInMain = isInMain;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }



}
