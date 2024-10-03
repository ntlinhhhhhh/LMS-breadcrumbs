public class Admin extends User {

    public Admin(String id, String full_name, String user_name, String email, String password, String phone) {
        super(id, full_name, user_name, email, password, phone, "UserRead");
    }

    public void PrintInfo() {
        super.PrintInfo();
    }
}
