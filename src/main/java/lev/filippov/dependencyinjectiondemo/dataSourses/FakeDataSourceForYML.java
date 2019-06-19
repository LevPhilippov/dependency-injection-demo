package lev.filippov.dependencyinjectiondemo.dataSourses;

//В этом примере настройки подтянутся из YML - файла. application.yml читается по умолчанию, на остальное нужно указывать через @PropertySourse
public class FakeDataSourceForYML {

    private String username;
    private String password;
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
