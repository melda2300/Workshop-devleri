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

    public void delate(User user) {
        boolean bookFound = false;
        for (int a = 0; a < bookCount; a++) {
            if (books[a].getId() == book.getId()) {
                bookFound = true;
                break;
            }
            if (bookFound) {
                Book[] updatedBooks = new Book[bookCount - 1];
                int index = 0;
                for (int b = 0; b < bookCount; b++) {
                    if (b != a) {
                        updatedBooks[index++] = books[b];
                    }
                }
                return "işlem tamamlandı.";
            }
        }
        return "Bu ID'ye sahip bir kitap bulunamadı , İşlem başarısız oldu tekrar deneyiniz..";

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
        List<Book> userBooks = user.getBooks();
        userBooks.add(book);
        user.setBooks(userBooks);
        return "Kitap başarıyla kullanıcıya atandı.";
    }
    // Delete YAPILDI
    // Update YAPILDI
    // getUserBYTC YAPILDI
    // assignBookToUser yapıldı
    // methodlariniz yaziniz.
}
