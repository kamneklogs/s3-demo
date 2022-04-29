package s3.demo.examples.logs;

import s3.demo.logs.Loggable;

public class ProfileViewLog implements Loggable {

    private String name;

    private String data;

    public ProfileViewLog(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
