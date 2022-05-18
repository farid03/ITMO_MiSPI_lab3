package beans;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
//TODO приделать базу данных

@ManagedBean
@SessionScoped
@Data
public class ResultsBean implements Serializable {
    private ArrayList<Point> points;
    private Point newPoint = new Point();
    private Point lastPoint;

    public ResultsBean() {
        this.points = new ArrayList<>();
    }

    public ResultsBean(ArrayList<Point> points) {
        this.points = points;
    }

    public synchronized void addPoint() {
        newPoint.setCurrentTime(new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime()));
        if (Validator.isValidDate(newPoint)) {
            points.add(0, newPoint);
            lastPoint = newPoint;
            newPoint = new Point();
        } else {
            newPoint.setHit("Некорректно введены данные!");
        }
    }

    public synchronized void clear() {
        points.clear();
        newPoint.setHit("Таблица успешно очищена!");
    }
}