package beans;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;

@Data
@ManagedBean
@SessionScoped
@Entity
@Table(name = "point")
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "x", nullable = false)
    private String x;
    @Column(name = "y", nullable = false)
    private String y;
    @Column(name = "r", nullable = false)
    private String r;
    @Column(name = "currentTime", nullable = false)
    private String currentTime;
    @Column(name = "hit", nullable = false)
    private String hit;

    public Point() {
        this.r = "2.0";
    }

//    public Point(double x, double y, int r, String currentTime, String scriptTime, String hit) {
//        this.x = x;
//        this.y = y;
//        this.r = r;
//        this.currentTime = currentTime;
//        this.scriptTime = scriptTime;
//        this.hit = hit;
//    }

    public String toJSON() {
        return "{" +
                "\"x\":" + "\"" + this.x + "\"" + "," +
                "\"y\":" + "\"" + this.y + "\"" + "," +
                "\"r\":" + "\"" + this.r + "\"" + "," +
//                "\"currentTime\":" + "\"" + this.currentTime + "\"" + "," +
//                "\"scriptTime\":" + "\"" + this.scriptTime + "\"" + "," +
                "\"hit\":" + "\"" + this.hit + "\"" +
                "}";
    }

    public String toMessage() {
        return "Проверка точки (" + this.x + "; " + this.y + ")\n" +
                "Параметр: " + this.r + "\n" +
                "Время отправки: " + this.currentTime + "\n" +
                "Результат: " + this.hit;
    }
}
