import java.util.List;

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
 public String delate(User userId) {
        boolean isUserFound = false;
        for (int b = 0; b < userCount; b++) {
            if (users[b].getId() == userId.getId()) {
                isUserFound = true;
                break;
            }
            if (isUserFound) {
                User[] updatedusers = new User[userCount - 1];
                int updatedUserCount = 0;
                for (int a = 0; a < userCount; a++) {

                    updatedusers[updatedUserCount] = users[a];
                    updatedUserCount++;
                }
                users = updatedusers;
                userCount = updatedUserCount;
                return "Kimliği olan kullanıcı " + userId + " silindi. ";
            } else {
                return "Kimliği olan kullanıcı " + userId + " bulunamadı. ";
            }

        }
        return "hata tekrar deneyiniz.";
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

        if (updateService) {
            System.out.println("Bilgiler güncellenmiştir.");
        } else {
        System.out.println("Bilgiler güncellenemedi tekrar deneyiniz.");
        }

    }



    public User getUserBYTC(int TC) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId() == TC) {
                return users[i];
            }
        }
        System.out.println("Böyle bir kullanıcı bulunamadı.");
        return null;
    }
 public static String assignBookToUser(User user, Book book) {
        if (user != null && book !=null) {
            List<Book> userBooks = user.getBooks();
            if (userBooks == null) {
                userBooks = new ArrayList<>();


            }
            userBooks.add(book);
            user.setBooks(userBooks);
            return "Kitap başarıyla kullanıcıya atandı.";
        }

        return "hata oluştu tekrar deneyiniz";
  


    public static String assignBookToUser(User user, Book book) {
         if (user != null && book !=null) {
            List<Book> userBooks = user.getBooks();
            if (userBooks == null) {
                userBooks = new ArrayList<>();
            }
            userBooks.add(book);
            user.setBooks(userBooks);
            return "Kitap başarıyla kullanıcıya atandı.";
        }
        return "hata oluştu tekrar deneyiniz

    }
    // Delete YAPILDI
    // Update YAPILDI
    // getUserBYTC YAPILDI
    // assignBookToUser YAPILDI
    // methodlariniz yaziniz.
}
