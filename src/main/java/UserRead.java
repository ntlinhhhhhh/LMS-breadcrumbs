public class UserRead extends User {

    public UserRead(String id, String full_name, String user_name, String email, String password, String phone) {
        super(id, full_name, user_name, email, password, phone, "UserRead");
    }

    @Override
    public void PrintInfo() {
        super.PrintInfo();
    }
}
