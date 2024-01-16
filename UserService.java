public class UserService {

    private final BookService bookService;

    private User[] users;
    private int userCount;

    public UserService(BookService bookService) {
        this.bookService = bookService;
        this.users = new User[100];
        this.userCount = 0;
    }

    public void addUser(User user) {
        users[userCount] = user;
        userCount++;
    }

    public void delate(User user) {
        users[userCount] = user;
        userCount--;

    }
    public void update(User user, int id) {
        boolean updateService = false;
        for (int a = 0; a < userCount; a++) {
            if (users[a].getId() == id) {
                String name = users[a].getName();
                String lastName = users[a].getLastName();
                users[a] = user;
                updateService = true;
                break;
            }
        }
        if (updateService){
            System.out.println("Bilgiler güncellenmiştir.");
        }else {
            System.out.println("Bilgiler güncelenemedi.");
        }

    }

    public User getUserBYTC(int id) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        System.out.println("Böyle bir kullanıcı bulunamadı.");
        return null;
    }

    public static String  assignBookToUser(int userId, int bookId) {
        return "Kimlik ile rezervasyon yapın " + bookId + " kimliğine sahip kullanıcıya başarıyla atandı " + userId + " .";
    }
    // Delete YAPILDI
    // Update YAPILDI
    // getUserBYTC YAPILDI
    // assignBookToUser yapıldı
    // methodlariniz yaziniz.
}
