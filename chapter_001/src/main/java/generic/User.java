package generic;

public class User extends Base {

    String name;

    protected User(String id, String name) {
        super(id);
        this.name = name;
    }
}
