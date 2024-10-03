public abstract class User {
    private String id;
    private String full_name;
    private String user_name;
    private String email;
    private String password;
    private String phone;
    private String role;

    // constructor
    public User(String id, String full_name, String user_name, String email, String password, String phone, String role) {
        this.id = id;
        this.full_name = full_name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    //getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ham PrintInfo
    public void PrintInfo() {
        System.out.println("ID: " + getId() + " Full_name: " + getFull_name() + " User_name: " + getUser_name() + " Email: " + getEmail() + " Password: " + getPassword() + " Phone: " + getPhone() + " Role: " + getRole());
    }
}
