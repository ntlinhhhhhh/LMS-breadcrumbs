public class Main {

    public static void main(String[] args) {
        Book book = new Book("1111", "100", "0001", "Chi Pheo", "Nam Cao", "Truyen ngan", 200);

        book.PrintInfo();

        UserRead u = new UserRead("0001", "Nguyen Thuy Linh", "haha", "23021610@..", "26012005", "0291401");
        u.PrintInfo();

        Admin ad = new Admin("10203", "NGuyen thuy Linh", "hihi", "nguyenthuyLinh204", "204032", "204914");
        ad.PrintInfo();

    }

}
