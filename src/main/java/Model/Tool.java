package Model;

import java.time.LocalDate;
import java.util.Date;

public class Tool {
    private int tool_id;
    private String tool_name;
    private String tool_mark;
    private String tool_model;
    private LocalDate tool_year;

    public int getTool_id() {
        return tool_id;
    }

    public void setTool_id(int tool_id) {
        this.tool_id = tool_id;
    }

    public String getTool_name() {
        return tool_name;
    }

    public void setTool_name(String tool_name) {
        this.tool_name = tool_name;
    }

    public String getTool_mark() {
        return tool_mark;
    }

    public void setTool_mark(String tool_mark) {
        this.tool_mark = tool_mark;
    }

    public String getTool_model() {
        return tool_model;
    }

    public void setTool_model(String tool_model) {
        this.tool_model = tool_model;
    }

    public LocalDate getTool_year() {
        return tool_year;
    }

    public void setTool_year(LocalDate tool_year) {
        this.tool_year = tool_year;
    }
}
