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

   public String delate(User user) {
        boolean userFound = false;
        for (int b = 0; b < userCount; b++) {
            if (users[b].getId() == user.getId()) {
                userFound = true;
                break;
            }
            if (userFound) {
                User[] updatedusers = new User[userCount - 1];
                int index = 0;
                for (int a = 0; a < userCount; a++) {
                    if (a != b) {
                        updatedusers[index++] = users[a];
                    }
                }
                return "İşlem tamamlandı";
            }
        }
        return "Bu ID'ye sahip bir kitap bulunamadı , İşlem başarısız oldu tekrar deneyiniz.";
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
        List < Book > userBooks = user.getBooks();
        userBooks.add(book);
        user.setBooks(userBooks);
        return "Kitap başarıyla kullanıcıya atandı.";
    }
    // Delete YAPILDI
    // Update YAPILDI
    // getUserBYTC YAPILDI
    // assignBookToUser YAPILDI
    // methodlariniz yaziniz.
}
