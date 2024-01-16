
public class BookService {
    private Book[] books;
    private int bookCount;

    public BookService() {
        this.books = new Book[100];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        books[bookCount] = book;
        bookCount++;
    }

    public void updateBook(Book book, int id) {
        boolean isBookFound = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                book.setId(books[i].getId());
                book.setPage(books[i].getPage());
                books[i] = book;
                isBookFound = true;
                break;
            }
        }

        if (isBookFound) {
            System.out.println("Kitap gucellenmistir...");
        } else {
            System.out.println("Kitap bulunamadi...");
        }

    }

    public Book[] getBooks() {
        return books;
    }

    public void delete(Book book) {
        books[bookCount] = book;
        bookCount--;
    }

    public static void getBookById(Book book, int Id) {
        if (book.getId() == Id) {
            System.out.println("Bulunan Kitap: " + book);
        } else {
            System.out.println("Kimlik ile rezervasyon yapın: " + Id + " bulunamadı.");
        }
    }

    public void getBooksByAuthorName(Book name, Book writer) {
        if (name.getName() == writer.getAuthorName()) {
            System.out.println("Eşleşmeler:");
            for (int a = 0; a < books.length; a++) {
                if (books[a] != null && books[a].getAuthorName().equals(writer.getAuthorName())) {
                    System.out.println(books[a].getName());
                }
            }
        }else {
            System.out.println("Eşleşme yapılamadı");
        }
    }
}
// delete Yapıldı
// getBookById Yapıldı
// getBooksByAuthorName  Yıpıldı

